package DCRGraphVis;

import oodcr.DCRGraph;

import java.util.ArrayList;

public interface ILayoutAlgorithm {
    ArrayList<Node> generateNodes(DCRGraph dcrGraph);
}
