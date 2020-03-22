package dk.ku.di.oodcr.visualizer.layoutalgorithms;

import dk.ku.di.oodcr.graph.DCRGraph;
import dk.ku.di.oodcr.visualizer.Node;

import java.util.ArrayList;

public interface ILayoutAlgorithm {
    ArrayList<Node> generateNodes(DCRGraph dcrGraph);
}
