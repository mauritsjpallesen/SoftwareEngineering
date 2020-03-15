package DCRGraphVis;

import oodcr.DCRGraph;
import oodcr.Event;

import java.util.ArrayList;

import org.jgrapht.*;
import org.jgrapht.alg.drawing.model.Point2D;
import org.jgrapht.graph.*;
import  org.jgrapht.alg.drawing.*;
import java.util.*;

public class FRLayoutAlgorithm implements ILayoutAlgorithm {

    public ArrayList<Node> generateNodes(DCRGraph graph) {
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
