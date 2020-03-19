package DCRGraphVis.LayoutAlgorithms;

import DCRGraphVis.LayoutModel;
import DCRGraphVis.Node;
import dk.ku.di.oodcr.DCRGraph;
import dk.ku.di.oodcr.Event;

import java.util.ArrayList;

import dk.ku.di.oodcr.RelationshipType;
import org.jgrapht.alg.drawing.model.Point2D;
import org.jgrapht.graph.*;
import  org.jgrapht.alg.drawing.*;
import java.util.*;

public class FRLayoutAlgorithm implements ILayoutAlgorithm {

    public ArrayList<Node> generateNodes(DCRGraph graph) {
        var g = new SimpleGraph<Event, DefaultEdge>(DefaultEdge.class);
        var events = graph.events.values();

        for (Event e: events) {
            g.addVertex(e);
        }

        for (Event e1: events) {
            var relations = e1.getRelationships().entrySet();
            for (Map.Entry<RelationshipType, HashSet<Event>> entry: relations) {
                for (Event e2 : entry.getValue())
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
