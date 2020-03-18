package DCRGraphVis;

import java.lang.reflect.*;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxFastOrganicLayout;
import com.mxgraph.layout.mxPartitionLayout;
import com.mxgraph.layout.mxStackLayout;
import dk.ku.di.oodcr.DCRGraph;
import dk.ku.di.oodcr.Event;
import dk.ku.di.oodcr.RelationshipType;
import org.apache.commons.lang3.ObjectUtils;
import org.jgrapht.Graph;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

public class FastOrganicLayout implements ILayoutAlgorithm {
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

        var adapter = new JGraphXAdapter<Event, DefaultEdge>(g);
        var layout = new mxFastOrganicLayout(adapter);
        layout.setForceConstant(200);
        layout.execute(adapter.getDefaultParent());
        var niceGraph = layout.getGraph();
        var vertices = niceGraph.getChildVertices(adapter.getDefaultParent());


        var retVal = new ArrayList<Node>();

        for (Object tmp : vertices) {
            try {
                Class<?> clazz = tmp.getClass();
                var valueMethod = clazz.getMethod("getValue");
                var geometryMethod = clazz.getMethod("getGeometry");
                var event = (Event)valueMethod.invoke(tmp);
                var geometry = geometryMethod.invoke(tmp);
                var x = (double)geometry.getClass().getMethod("getX").invoke(geometry);
                var y = (double)geometry.getClass().getMethod("getY").invoke(geometry);
                y = y < 0 ? 0 : y;
                x = x < 0 ? 0 : x;
                retVal.add(new Node((int)Math.round(x), (int)Math.round(y), event));
            } catch (Exception e) {
                throw new NullPointerException(e.getMessage());
            }
        }

        return retVal;
    }
}
