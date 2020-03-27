package dk.ku.di.oodcr.visualizer.layoutalgorithms;

import dk.ku.di.oodcr.graph.DCRGraph;
import dk.ku.di.oodcr.visualizer.Node;

import java.util.ArrayList;

/***
 * @summary An interface describing the only public method a layout algorithm class should have.
 */
public interface ILayoutAlgorithm {
    ArrayList<Node> generateNodes(DCRGraph dcrGraph);
}
