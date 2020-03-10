import DCRGraphVis.ImageType;
import DCRGraphVis.LayoutAlgorithm;
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

        var visualizer = new Visualizer(new LayoutAlgorithm());

        try {
            visualizer.GenerateImage(dcrGraph, "testImage.png", ImageType.PNG);
        } catch (IOException ioException) {
            System.out.println("An unexpected error occurred: \n " + ioException.getMessage() + "\n" + ioException.getStackTrace());
        }
    }
}
