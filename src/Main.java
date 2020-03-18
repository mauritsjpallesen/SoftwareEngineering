import DCRGraphVis.FRLayoutAlgorithm;
import DCRGraphVis.ImageType;
import DCRGraphVis.FastOrganicLayout;
import DCRGraphVis.Visualizer;
import Parser.InputFileParser;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide an input file");
        }

        var parser = new InputFileParser();
        var dcrGraph = parser.parse("");

        var layoutAlg = new FRLayoutAlgorithm();
        var layoutAlg1 = new FastOrganicLayout();

        var visualizer = new Visualizer(layoutAlg);
        var visualizer1 = new Visualizer(layoutAlg1);

        try {
            visualizer.GenerateImage(dcrGraph, "testImage.png", ImageType.PNG);
            visualizer1.GenerateImage(dcrGraph, "testImage1.png", ImageType.PNG);
        } catch (IOException ioException) {
            System.out.println("An unexpected error occurred: \n " + ioException.getMessage() + "\n" + ioException.getStackTrace());
        }
    }
}
