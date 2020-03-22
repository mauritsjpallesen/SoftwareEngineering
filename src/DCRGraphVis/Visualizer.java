package DCRGraphVis;

import DCRGraphVis.LayoutAlgorithms.ILayoutAlgorithm;
import dk.ku.di.oodcr.*;
import dk.ku.di.oodcr.Event;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

public class Visualizer {

    final static BasicStroke solidThin = new BasicStroke();
    final static BasicStroke solidThick = new BasicStroke(2);
    final static BasicStroke dashed = new BasicStroke(1.0f,
            BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, new float[] { 5.0f }, 0.0f);

    private BufferedImage tickImage;
    private BufferedImage exclamationMarkImage;

    private Polygon arrowHead;

    private ILayoutAlgorithm layoutAlgorithm;

    public Visualizer(ILayoutAlgorithm layoutAlgorithm) {
        this.layoutAlgorithm = layoutAlgorithm;

        try {
            tickImage = ImageIO.read(new File("Images/tick.png"));
            exclamationMarkImage = ImageIO.read(new File("Images/exclamation-mark.png"));
        } catch (IOException e) {
            drawTickImage();
            drawExclamationMarkImage();
        }

        arrowHead = new Polygon();
        arrowHead.addPoint( 0,2);
        arrowHead.addPoint( -5, -9);
        arrowHead.addPoint( 5,-9);
    }

    public void GenerateImage(DCRGraph graph, String outputFileName, ImageType imageType) throws IOException {
        if (outputFileName == null)
            throw new NullPointerException("No filename given");

        var nodes = layoutAlgorithm.generateNodes(graph);
        var boundingBox = boundingBox(nodes);
        var borderWidth = 15;

        var image = new BufferedImage(boundingBox.x + boundingBox.width + 2 * borderWidth, boundingBox.y + boundingBox.height + 3 * borderWidth, BufferedImage.TYPE_INT_RGB);
        var g2d = image.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, boundingBox.x + boundingBox.width + 2 * borderWidth, boundingBox.y + boundingBox.height + 3 * borderWidth);

        for (Node node: nodes)
            drawNode(g2d, node);

        for (Node e: nodes) {
            var relations = e.Event.getRelationships().entrySet();
            for (Map.Entry<RelationshipType, HashSet<Event>> entry: relations) {
                for (Event e1 : entry.getValue()) {
                    Node n = null;
                    for (Node no: nodes) {
                        if (no.Event == e1) {
                            n = no;
                            break;
                        }
                    }

                    if (n == null)
                        continue;

                    drawRelation(g2d, e, n, entry.getKey());
                }
            }
        }

        var croppedImage = image.getSubimage(boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height);
        g2d.dispose();

        var imageFile = new File(outputFileName);
        ImageIO.write(croppedImage, imageType.toString(), imageFile);
    }

    public void drawNode(Graphics2D g, Node node) {
        g.setColor(Color.black);
        if (!node.Event.marking.included)
            g.setStroke(dashed);
        else
            g.setStroke(solidThin);

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

    public void drawRelation(Graphics2D g, Node nodeFrom, Node nodeTo, RelationshipType relationshipType) {
        g.setStroke(solidThick);
        setDrawColorAccordingToRelationshipType(g, relationshipType);

        var symbolMargin = 15;
        Point symbolPosition = null;

        Line2D line = null;
        var angle = angleBetweenNodes(nodeFrom, nodeTo);

        if (angle <= -150 || angle > 150) {
            symbolPosition = new Point(nodeTo.X + Node.Width, nodeTo.Y + Node.Height / 3 + 2 * symbolMargin / 5);
            if (-170 < angle && angle < -150)
                line = new Line2D.Float(nodeFrom.X, nodeFrom.Y + Node.Height / 3, nodeTo.X + Node.Width + symbolMargin, nodeTo.Y + Node.Height / 3);
            else if (170 > angle && angle > 150)
                line = new Line2D.Float(nodeFrom.X, nodeFrom.Y + Node.Height / 3, nodeTo.X + Node.Width + symbolMargin, nodeTo.Y + Node.Height / 3);
            else
                line = new Line2D.Float(nodeFrom.X, nodeFrom.Y + Node.Height / 3, nodeTo.X + Node.Width + symbolMargin, nodeTo.Y + Node.Height / 3);
        } else if (-150 <= angle && angle < -120) {
            line = new Line2D.Float(nodeFrom.X + Node.Width / 5, nodeFrom.Y, nodeTo.X + Node.Width + 2 * symbolMargin / 3, nodeTo.Y + 4 * Node.Height / 5 + symbolMargin / 5);
            symbolPosition = new Point(nodeTo.X + Node.Width, nodeTo.Y + 4 * Node.Height / 5);
        } else if (-120 <= angle && angle < -60) {
            symbolPosition = new Point(nodeTo.X + 2 * Node.Width / 3 , nodeTo.Y + Node.Height + 4 * symbolMargin / 5 );
            if (angle < -100)
                line = new Line2D.Float(nodeFrom.X + 2 * Node.Width / 3, nodeFrom.Y, nodeTo.X + 2 * Node.Width / 3 + symbolMargin, nodeTo.Y + Node.Height + symbolMargin);
            else if (-80 < angle)
                line = new Line2D.Float(nodeFrom.X + 2 * Node.Width / 3, nodeFrom.Y, nodeTo.X + 2 * Node.Width / 3, nodeTo.Y + Node.Height + symbolMargin);
            else
                line = new Line2D.Float(nodeFrom.X + 2 * Node.Width / 3, nodeFrom.Y, nodeTo.X + 2 * Node.Width / 3, nodeTo.Y + Node.Height + symbolMargin);
        } else if (-60 <= angle && angle < -30) {
            line = new Line2D.Float(nodeFrom.X + Node.Width, nodeFrom.Y + Node.Height / 5, nodeTo.X + Node.Width / 5, nodeTo.Y + Node.Height + symbolMargin);
            symbolPosition = new Point(nodeTo.X + Node.Width / 5, nodeTo.Y + Node.Height + 4 * symbolMargin / 5);
        } else if (-30 <= angle && angle < 30 ) {
            line = new Line2D.Float(nodeFrom.X + Node.Width, nodeFrom.Y + 2 * Node.Height / 3, nodeTo.X - symbolMargin, nodeTo.Y + 2 * Node.Height / 3);
            if (angle < -10)
                symbolPosition = new Point(nodeTo.X - 4 * symbolMargin / 5, nodeTo.Y + 2 * Node.Height / 3 + symbolMargin / 5);
            else if (10 < angle)
                symbolPosition = new Point(nodeTo.X - 4 * symbolMargin / 5, nodeTo.Y + 2 * Node.Height / 3 + 2 * symbolMargin / 5);
            else
                symbolPosition = new Point(nodeTo.X - 4 * symbolMargin / 5, nodeTo.Y + 2 * Node.Height / 3 + symbolMargin / 5);
        } else if (30 <= angle && angle < 60 ) {
            line = new Line2D.Float(nodeFrom.X + 4 * Node.Width / 5, nodeFrom.Y + Node.Height, nodeTo.X - 2 * symbolMargin / 3, nodeTo.Y + Node.Height / 5 - 2 * symbolMargin / 3);
            symbolPosition = new Point( nodeTo.X - 4 * symbolMargin / 5, nodeTo.Y + Node.Height / 5);
        } else if (60 <= angle && angle < 120 ) {
            symbolPosition = new Point(nodeTo.X + Node.Width / 3, nodeTo.Y);
            if (angle < 80)
                line = new Line2D.Float(nodeFrom.X + Node.Width / 3, nodeFrom.Y + Node.Height, nodeTo.X + Node.Width / 3 - symbolMargin / 2, nodeTo.Y - symbolMargin);
            else if (100 < angle)
                line = new Line2D.Float(nodeFrom.X + Node.Width / 3, nodeFrom.Y + Node.Height, nodeTo.X + Node.Width / 3 + symbolMargin, nodeTo.Y - symbolMargin);
            else
                line = new Line2D.Float(nodeFrom.X + Node.Width / 3, nodeFrom.Y + Node.Height, nodeTo.X + Node.Width / 3 + symbolMargin / 3, nodeTo.Y - symbolMargin);
        } else if (120 <= angle && angle <= 150) {
            line = new Line2D.Float(nodeFrom.X, nodeFrom.Y + 4 * Node.Height / 5, nodeTo.X + 4 * Node.Width / 5 + symbolMargin, nodeTo.Y - symbolMargin);
            symbolPosition = new Point(nodeTo.X + 4 * Node.Width / 5, nodeTo.Y);
        }

        if (relationshipType == RelationshipType.RESPONSES) {
            var symbolRadius = 5;
            if (angle <= -150 || angle > 150) {
                line = new Line2D.Float(nodeFrom.X - symbolRadius, nodeFrom.Y + Node.Height / 3, nodeTo.X + Node.Width + 2, nodeTo.Y + Node.Height / 3);
                symbolPosition = new Point(-symbolRadius, 0);
            } else if (-150 <= angle && angle < -120) {
                line = new Line2D.Float(nodeFrom.X + Node.Width / 5, nodeFrom.Y - symbolRadius, nodeTo.X + Node.Width + 2, nodeTo.Y + 4 * Node.Height / 5);
                symbolPosition = new Point(-symbolRadius, -symbolRadius);
            } else if (-120 <= angle && angle < -60) {
                line = new Line2D.Float(nodeFrom.X + 2 * Node.Width / 3, nodeFrom.Y - symbolRadius, nodeTo.X + 2 * Node.Width / 3, nodeTo.Y + Node.Height + 2);
                symbolPosition = new Point(0, -symbolRadius);
            } else if (-60 <= angle && angle < -30) {
                line = new Line2D.Float(nodeFrom.X + Node.Width + symbolRadius, nodeFrom.Y + Node.Height / 5, nodeTo.X + Node.Width / 5, nodeTo.Y + Node.Height + 2);
                symbolPosition = new Point(symbolRadius, symbolRadius);
            } else if (-30 <= angle && angle < 30 ) {
                line = new Line2D.Float(nodeFrom.X + Node.Width + symbolRadius, nodeFrom.Y + 2 * Node.Height / 3, nodeTo.X - 2, nodeTo.Y + 2 * Node.Height / 3);
                symbolPosition = new Point(symbolRadius, 0);
            } else if (30 <= angle && angle < 60 ) {
                line = new Line2D.Float(nodeFrom.X + 4 * Node.Width / 5, nodeFrom.Y + Node.Height + symbolRadius, nodeTo.X - 2, nodeTo.Y + Node.Height / 5);
                symbolPosition = new Point(symbolRadius, symbolRadius);
            } else if (60 <= angle && angle < 120 ) {
                line = new Line2D.Float(nodeFrom.X + Node.Width / 3, nodeFrom.Y + Node.Height + symbolRadius, nodeTo.X + Node.Width / 3, nodeTo.Y - 2);
                symbolPosition = new Point(0, symbolRadius);
            } else if (120 <= angle && angle <= 150) {
                line = new Line2D.Float(nodeFrom.X - symbolRadius, nodeFrom.Y + 4 * Node.Height / 5 - symbolRadius, nodeTo.X + 4 * Node.Width / 5, nodeTo.Y - 2);
                symbolPosition = new Point(-symbolRadius, symbolRadius);
            }

            var circle = new Ellipse2D.Double(-symbolRadius, -symbolRadius, 2.0 * symbolRadius, 2.0 * symbolRadius);
            drawPolygonRelativeToLine(g, line, circle, RelativePosition.Start);
        }
        else {
            var curFont = g.getFont();
            g.drawString(relationshipType.toString(), symbolPosition.x, symbolPosition.y);
            g.setFont(curFont);
        }

        if (line == null)
            throw new NullPointerException("Relation line was never set");

        drawPolygonRelativeToLine(g, line, arrowHead, RelativePosition.End);
        g.draw(line);

        g.setColor(Color.black);
    }

    private void drawPolygonRelativeToLine(Graphics2D g, Line2D line, Shape shape, RelativePosition relativePosition) {
        var curStroke = g.getStroke();
        g.setStroke(new BasicStroke(4));
        AffineTransform tx = new AffineTransform();
        tx.setToIdentity();
        double angle = Math.atan2(line.getY2()-line.getY1(), line.getX2()-line.getX1());
        if (relativePosition == RelativePosition.End)
            tx.translate(line.getX2(), line.getY2());
        else
            tx.translate(line.getX1(), line.getY1());
        tx.rotate((angle-Math.PI/2d));

        var t = g.getTransform();
        g.setTransform(tx);
        g.fill(shape);
        g.setTransform(t);
        g.setStroke(curStroke);
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

        return new Rectangle(minX, minY, maxX - minX, maxY - minY);
    }

    private void setDrawColorAccordingToRelationshipType(Graphics2D g, RelationshipType relationshipType) {
        switch (relationshipType) {
            case CONDITIONS:
                g.setColor(Color.decode("#ffa600"));
                break;
            case RESPONSES:
                g.setColor(Color.blue);
                break;
            case MILESTONES:
                g.setColor(Color.pink);
                break;
            case INCLUDES:
                g.setColor(Color.decode("#2D9244"));
                break;
            case EXCLUDES:
                g.setColor(Color.red);
                break;
        }
    }

    private void drawExclamationMarkImage() {
        exclamationMarkImage = new BufferedImage(16, 16, BufferedImage.TYPE_INT_RGB);
        var exclamationMarkImageG2d = exclamationMarkImage.createGraphics();
        exclamationMarkImageG2d.setColor(Color.white);
        exclamationMarkImageG2d.fillRect(0, 0, 16, 16);
        exclamationMarkImageG2d.setColor(Color.red);
        exclamationMarkImageG2d.setStroke(new BasicStroke(3));
        exclamationMarkImageG2d.drawLine(7, 1, 7, 8);
        exclamationMarkImageG2d.fillRect(6, 13, 3, 3);
        exclamationMarkImageG2d.dispose();
    }

    private void drawTickImage() {
        tickImage = new BufferedImage(16, 16, BufferedImage.TYPE_INT_RGB);
        var tickImageG2d = tickImage.createGraphics();
        tickImageG2d.setColor(Color.white);
        tickImageG2d.fillRect(0, 0, 16, 16);
        tickImageG2d.setColor(Color.decode("#2D9244"));
        tickImageG2d.setStroke(new BasicStroke(3));
        tickImageG2d.drawLine(5, 10, 8, 14);
        tickImageG2d.drawLine(8, 14, 14, 5);
        tickImageG2d.dispose();
    }

    private double angleBetweenNodes(Node nodeFrom, Node nodeTo) {
        var radians = Math.atan2(nodeTo.Y-nodeFrom.Y, nodeTo.X-nodeFrom.X);
        return radians * 180 / Math.PI;
    }
}
