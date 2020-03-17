package DCRGraphVis;

import dk.ku.di.oodcr.DCRGraph;
import dk.ku.di.oodcr.Event;
import dk.ku.di.oodcr.RelationshipType;
import org.jgrapht.Graph;
import org.jgrapht.alg.drawing.FRLayoutAlgorithm2D;
import org.jgrapht.alg.drawing.model.Point2D;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

public class SimpleLayoutTilt implements ILayoutAlgorithm {
    public ArrayList<Node> generateNodes(DCRGraph dcrGraph) {
        Graph<Event, DefaultEdge> g = new SimpleGraph<>(DefaultEdge.class);
        var events = dcrGraph.events.values();

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

        //var layoutAlg = new JGraphSimpleLayout();
        //var layout = new LayoutModel(events.size());
        //layoutAlg.layout(g, layout);
        var retVal = new ArrayList<Node>();

        //for (Map.Entry<Event, Point2D> tmp : layout)
        //   retVal.add(new Node((int) tmp.getValue().getX(), (int) tmp.getValue().getY(), tmp.getKey()));

        return retVal;
    }
}
