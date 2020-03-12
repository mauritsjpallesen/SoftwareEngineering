package DCRGraphVis;

import oodcr.DCRGraph;
import oodcr.Event;

import java.util.ArrayList;

import org.jgrapht.*;
import org.jgrapht.alg.drawing.model.Point2D;
import org.jgrapht.graph.*;
import  org.jgrapht.alg.drawing.*;
import java.util.*;

public class LayoutAlgorithm {

    public ArrayList<Node> generateNodes(DCRGraph graph) {
        var nodes = new ArrayList<Node>();
        var events = graph.events.values().toArray(new Event[0]);

        var gridSize = (int) Math.ceil(events.length/2);

        var counterX = 0;
        var counterY = 0;
        for (Event e: events) {
            var spacingX = counterX == 0 ? 0 : 50;
            var spacingY = counterY == 0 ? 0 : 50;
            nodes.add(new Node(counterX * Node.Width + counterX * spacingX,
                    counterY * Node.Height + counterY * spacingY, e));

            counterY = counterX >= gridSize - 1
                    ? counterY + 1
                    : counterY;

            counterX = counterX >= gridSize - 1
                    ? 0
                    : counterX + 1;
        }

        return nodes;
    }

    public ArrayList<Node> generateWithJGraphT(DCRGraph graph) {
        Graph<Event, DefaultEdge> g = new SimpleGraph<>(DefaultEdge.class);
        var events = graph.events.values();

        for (Event e: events) {
            g.addVertex(e);
        }

        for (Event e1: events) {
            for (Event e2: events) {
                if (e1.excludes.contains(e2))
                    g.addEdge(e1, e2);

                if (e1.includes.contains(e2))
                    g.addEdge(e1, e2);

                if (e1.responses.contains(e2))
                    g.addEdge(e1, e2);

                if (e1.milestones.contains(e2))
                    g.addEdge(e1, e2);

                if (e1.conditions.contains(e2))
                    g.addEdge(e1, e2);
            }
        }

        var layoutAlg = new FRLayoutAlgorithm2D<Event, DefaultEdge>();
        var layout = new LayoutModel(events.size());
        layoutAlg.layout(g, layout);
        var retVal = new ArrayList<Node>();

        for (Map.Entry<Event, Point2D> tmp : layout)
            retVal.add(new Node((int) tmp.getValue().getX(), (int) tmp.getValue().getY(), tmp.getKey()));

        return retVal;
    }
}
