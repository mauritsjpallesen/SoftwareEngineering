package DCRGraphVis;

import oodcr.DCRGraph;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Visualizer {

    final static BasicStroke solid = new BasicStroke();
    final static BasicStroke dashed = new BasicStroke(1.0f,
            BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, new float[] { 5.0f }, 0.0f);

    private Image tickImage;
    private Image exclamationMarkImage;

    private Polygon arrowHead;

    private LayoutAlgorithm layoutAlgorithm;

    public Visualizer(LayoutAlgorithm layoutAlgorithm) {
        this.layoutAlgorithm = layoutAlgorithm;

        try {
            tickImage = ImageIO.read(new File("src/DCRGraphVis/Images/tick.png"));
            exclamationMarkImage = ImageIO.read(new File("src/DCRGraphVis/Images/exclamation-mark.png"));
        } catch (IOException e) {
            throw new NullPointerException(e.getMessage());
        }

        arrowHead = new Polygon();
        arrowHead.addPoint( 0,3);
        arrowHead.addPoint( -3, -3);
        arrowHead.addPoint( 3,-3);
    }

    public void GenerateImage(DCRGraph graph, String fileName, ImageType imageType) throws IOException {
        if (fileName == null)
            throw new NullPointerException("No filename given");

        var nodes = layoutAlgorithm.generateWithJGraphT(graph);
        var boundingBox = boundingBox(nodes);
        var borderWidth = 15;

        var image = new BufferedImage(boundingBox.width + 2 * borderWidth, boundingBox.height + 2 * borderWidth, BufferedImage.TYPE_INT_RGB);
        var g2d = image.createGraphics();
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, boundingBox.width + 2 * borderWidth, boundingBox.height + 2 * borderWidth);

        for (Node node: nodes) {
            node.X = node.X + borderWidth;
            node.Y = node.Y + borderWidth;
            drawNode(g2d, node);
        }

        for (Node e: nodes) {
            for (Node n: nodes) {
                if (e.Event.excludes.contains(n.Event))
                    drawRelation(g2d, e, n, RelationType.Excludes);

                if (e.Event.includes.contains(n.Event))
                    drawRelation(g2d, e, n, RelationType.Includes);

                if (e.Event.responses.contains(n.Event))
                    drawRelation(g2d, e, n, RelationType.Response);

                if (e.Event.milestones.contains(n.Event))
                    drawRelation(g2d, e, n, RelationType.Milestone);

                if (e.Event.conditions.contains(n.Event))
                    drawRelation(g2d, e, n, RelationType.Condition);
            }
        }

        g2d.dispose();

        var imageFile = new File(fileName);
        ImageIO.write(image, imageType.toString(), imageFile);
    }

    public void drawNode(Graphics2D g, Node node) {
        g.setColor(Color.black);
        if (!node.Event.marking.included)
            g.setStroke(dashed);
        else
            g.setStroke(solid);

        g.draw(new RoundRectangle2D.Float(node.X, node.Y, Node.Width, Node.Height, 10, 10));
        var formattedLabel = String.join("\n", splitStringByNumberOfCharacters(node.Event.label, 10));

        var labelX = node.X + 10;
        var labelY = node.Y + 15;
        var labelBounds = getBoundingBoxOfString(g, formattedLabel, labelX, labelY);

        g.drawString(formattedLabel, labelX, labelY);
        g.drawLine(node.X, labelY + labelBounds.height, node.X + Node.Width, labelY + labelBounds.height);

        if (node.Event.marking.executed)
            g.drawImage(tickImage, node.X + 5, labelY + labelBounds.height + 5, null);

        if (node.Event.marking.pending)
            g.drawImage(exclamationMarkImage, node.X + Node.Width - 5 - exclamationMarkImage.getWidth(null), labelY + labelBounds.height + 5, null);
    }

    public void drawRelation(Graphics2D g, Node nodeFrom, Node nodeTo, RelationType relationType) {
        g.setStroke(solid);
        setDrawColorAccordingToRelationshipType(g, relationType);

        Line2D line = null;
        int xSpacing = 0;
        int ySpacing = 0;

        if (nodeFrom.X < nodeTo.X && nodeFrom.Y < nodeTo.Y) {
            xSpacing = -10;
            ySpacing = -10;
            line = new Line2D.Float(nodeFrom.X + Node.Width, nodeFrom.Y + Node.Height, nodeTo.X - 10, nodeTo.Y - 10);
        }

        if (nodeFrom.X < nodeTo.X && nodeFrom.Y == nodeTo.Y) {
            xSpacing = -15;
            ySpacing = 0;
            line = new Line2D.Float(nodeFrom.X + Node.Width, nodeFrom.Y + Node.Height/2, nodeTo.X - 15, nodeTo.Y + Node.Height/2);
        }

        if (nodeFrom.X < nodeTo.X && nodeFrom.Y > nodeTo.Y) {
            xSpacing = -10;
            ySpacing = 10;
            line = new Line2D.Float(nodeFrom.X + Node.Width, nodeFrom.Y, nodeTo.X - 10, nodeTo.Y + Node.Height + 10);
        }

        if (nodeFrom.X == nodeTo.X && nodeFrom.Y < nodeTo.Y) {
            xSpacing = 0;
            ySpacing = -15;
            line = new Line2D.Float(nodeFrom.X + Node.Width/2, nodeFrom.Y + Node.Height, nodeTo.X + Node.Width/2, nodeTo.Y - 15);
        }

        if (nodeFrom.X == nodeTo.X && nodeFrom.Y > nodeTo.Y) {
            xSpacing = 0;
            ySpacing = 15;
            line = new Line2D.Float(nodeFrom.X + Node.Width/2, nodeFrom.Y, nodeTo.X + Node.Width/2, nodeTo.Y + Node.Height + 15);
        }

        if (nodeFrom.X > nodeTo.X && nodeFrom.Y == nodeTo.Y) {
            xSpacing = 15;
            ySpacing = 0;
            line = new Line2D.Float(nodeFrom.X, nodeFrom.Y + Node.Height/2, nodeTo.X + Node.Width + 15, nodeTo.Y + Node.Height/2);
        }

        if (nodeFrom.X > nodeTo.X && nodeFrom.Y > nodeTo.Y) {
            xSpacing = 10;
            ySpacing = 10;
            line = new Line2D.Float(nodeFrom.X, nodeFrom.Y, nodeTo.X + Node.Width + 10, nodeTo.Y + Node.Height + 10);
        }

        if (nodeFrom.X > nodeTo.X && nodeFrom.Y < nodeTo.Y) {
            xSpacing = 10;
            ySpacing = -10;
            line = new Line2D.Float(nodeFrom.X + Node.Width, nodeFrom.Y + Node.Height, nodeTo.X + 10, nodeTo.Y - 10);
        }

        if (line == null)
            throw new NullPointerException("Relation line was never set");

        if (relationType == RelationType.Response) {
            line.setLine(line.getX1(), line.getY1(), line.getX2() - xSpacing, line.getY2() - ySpacing);
            g.drawString(relationType.toString(), (float)line.getX1(), (float)line.getY1());
        }
        else
            g.drawString(relationType.toString(), (float)line.getX2() - xSpacing, (float)line.getY2() - ySpacing);
        drawRelationShipArrowHead(g, line);
        g.draw(line);

        g.setColor(Color.black);
    }

    private void drawRelationShipArrowHead(Graphics2D g, Line2D line) {
        AffineTransform tx = new AffineTransform();
        tx.setToIdentity();
        double angle = Math.atan2(line.getY2()-line.getY1(), line.getX2()-line.getX1());
        tx.translate(line.getX2(), line.getY2());
        tx.rotate((angle-Math.PI/2d));

        var t = g.getTransform();
        g.setTransform(tx);
        g.fill(arrowHead);
        g.setTransform(t);
    }

    private Rectangle getBoundingBoxOfString(Graphics2D g2, String str, int x, int y)
    {
        FontRenderContext frc = g2.getFontRenderContext();
        GlyphVector gv = g2.getFont().createGlyphVector(frc, str);
        return gv.getPixelBounds(null, x, y);
    }

    private static String[] splitStringByNumberOfCharacters(String str, int size) {
        return (size<1 || str==null) ? null : str.split("(?<=\\G.{" + size + "})");
    }

    private static Rectangle boundingBox(ArrayList<Node> nodes) {
        var minX = Integer.MAX_VALUE;
        var minY = Integer.MAX_VALUE;
        var maxX = 0;
        var maxY = 0;

        for (Node node: nodes) {
            if (node.X < minX)
                minX = node.X;

            if (node.Y < minY)
                minY = node.Y;

            if (node.X + Node.Width > maxX)
                maxX = node.X + Node.Width;

            if (node.Y + Node.Height > maxY)
                maxY = node.Y + Node.Height;
        }

        return new Rectangle(minX, minY, maxX, maxY);
    }

    private void setDrawColorAccordingToRelationshipType(Graphics2D g, RelationType relationshipType) {
        switch (relationshipType) {
            case Condition:
                g.setColor(Color.yellow);
                break;
            case Response:
                g.setColor(Color.blue);
                break;
            case Milestone:
                g.setColor(Color.pink);
                break;
            case Includes:
                g.setColor(Color.green);
                break;
            case Excludes:
                g.setColor(Color.red);
                break;
        }
    }
}
