package DCRGraphVis.LayoutAlgorithms;

import DCRGraphVis.Node;
import dk.ku.di.oodcr.DCRGraph;

import java.util.ArrayList;

public interface ILayoutAlgorithm {
    ArrayList<Node> generateNodes(DCRGraph dcrGraph);
}
