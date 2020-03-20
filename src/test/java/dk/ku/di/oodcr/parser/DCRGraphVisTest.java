package dk.ku.di.oodcr.parser;

import DCRGraphVis.ImageType;
import DCRGraphVis.LayoutAlgorithms.FRLayoutAlgorithm;
import DCRGraphVis.Visualizer;

import dk.ku.di.oodcr.DCRGraph;

import org.junit.jupiter.api.Test;

import java.io.IOException;


public class DCRGraphVisTest {

    /* All test images will be written to ./src/test/test-images/ folder */

    @Test
    void simpleEventTest() {
        var g = new DCRGraph();
        g.addEvent("e1");
        g.addEvent("e2");

        g.addCondition("e1", "e2");

        var layoutAlg = new FRLayoutAlgorithm();
        var visualizer = new Visualizer(layoutAlg);

        try {
            visualizer.GenerateImage(g, "./src/test/test-images/simpleEventTest.png", ImageType.PNG);
        } catch (IOException ioException) {
            System.out.println("An unexpected error occurred: \n " + ioException.getMessage() + "\n" + ioException.getStackTrace());
        }
    }

    @Test
    void relationConditionTest() {
        var g = new DCRGraph();
        g.addEvent("e1");
        g.addEvent("e2");

        g.addCondition("e1", "e2");

        var layoutAlg = new FRLayoutAlgorithm();
        var visualizer = new Visualizer(layoutAlg);

        try {
            visualizer.GenerateImage(g, "./src/test/test-images/relationConditionTest.png", ImageType.PNG);
        } catch (IOException ioException) {
            System.out.println("An unexpected error occurred: \n " + ioException.getMessage() + "\n" + ioException.getStackTrace());
        }
    }

    @Test
    void relationMilestoneTest() {
        var g = new DCRGraph();
        g.addEvent("e1");
        g.addEvent("e2");

        g.addMilestone("e1", "e2");

        var layoutAlg = new FRLayoutAlgorithm();
        var visualizer = new Visualizer(layoutAlg);

        try {
            visualizer.GenerateImage(g, "./src/test/test-images/relationMilestoneTest.png", ImageType.PNG);
        } catch (IOException ioException) {
            System.out.println("An unexpected error occurred: \n " + ioException.getMessage() + "\n" + ioException.getStackTrace());
        }
    }

    @Test
    void relationResponseTest() {
        var g = new DCRGraph();
        g.addEvent("e1");
        g.addEvent("e2");

        g.addResponse("e1", "e2");

        var layoutAlg = new FRLayoutAlgorithm();
        var visualizer = new Visualizer(layoutAlg);

        try {
            visualizer.GenerateImage(g, "./src/test/test-images/relationResponseTest.png", ImageType.PNG);
        } catch (IOException ioException) {
            System.out.println("An unexpected error occurred: \n " + ioException.getMessage() + "\n" + ioException.getStackTrace());
        }
    }

    @Test
    void relationIncludeTest() {
        var g = new DCRGraph();
        g.addEvent("e1");
        g.addEvent("e2");

        g.addInclude("e1", "e2");

        var layoutAlg = new FRLayoutAlgorithm();
        var visualizer = new Visualizer(layoutAlg);

        try {
            visualizer.GenerateImage(g, "./src/test/test-images/relationIncludeTest.png", ImageType.PNG);
        } catch (IOException ioException) {
            System.out.println("An unexpected error occurred: \n " + ioException.getMessage() + "\n" + ioException.getStackTrace());
        }
    }

    @Test
    void relationExcludeTest() {
        var g = new DCRGraph();
        g.addEvent("e1");
        g.addEvent("e2");

        g.addExclude("e1", "e2");

        var layoutAlg = new FRLayoutAlgorithm();
        var visualizer = new Visualizer(layoutAlg);

        try {
            visualizer.GenerateImage(g, "./src/test/test-images/relationExcludeTest.png", ImageType.PNG);
        } catch (IOException ioException) {
            System.out.println("An unexpected error occurred: \n " + ioException.getMessage() + "\n" + ioException.getStackTrace());
        }
    }

    @Test
    void ComplexDrawingTest1() {
        var g = new DCRGraph();
        g.addEvent("e1");
        g.addEvent("e2");
        g.addEvent("e3");
        g.addEvent("e4");

        g.addExclude("e1", "e2");
        g.addExclude("e1", "e3");
        g.addCondition("e3", "e4");
        g.addInclude("e4", "e2");

        var layoutAlg = new FRLayoutAlgorithm();
        var visualizer = new Visualizer(layoutAlg);

        try {
            visualizer.GenerateImage(g, "./src/test/test-images/ComplexDrawingTest1.png", ImageType.PNG);
        } catch (IOException ioException) {
            System.out.println("An unexpected error occurred: \n " + ioException.getMessage() + "\n" + ioException.getStackTrace());
        }
    }

    @Test
    void ComplexDrawingTest2() {
        var g = new DCRGraph();
        g.addEvent("e1");
        g.addEvent("e2");
        g.addEvent("e3");
        g.addEvent("e4");
        g.addEvent("e5");

        g.addCondition("e1", "e2");
        g.addCondition("e1", "e5");
        g.addExclude("e2", "e1");
        g.addCondition("e2", "e3");
        g.addExclude("e2", "e5");
        g.addCondition("e3", "e4");
        g.addInclude("e3", "e4");
        g.addResponse("e3", "e4");

        var layoutAlg = new FRLayoutAlgorithm();
        var visualizer = new Visualizer(layoutAlg);

        try {
            visualizer.GenerateImage(g, "./src/test/test-images/ComplexDrawingTest2.png", ImageType.PNG);
        } catch (IOException ioException) {
            System.out.println("An unexpected error occurred: \n " + ioException.getMessage() + "\n" + ioException.getStackTrace());
        }
    }

}
