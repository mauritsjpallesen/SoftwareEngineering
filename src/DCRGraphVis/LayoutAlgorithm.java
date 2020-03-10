package DCRGraphVis;

import oodcr.DCRGraph;
import oodcr.Event;

import java.util.ArrayList;

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
}
