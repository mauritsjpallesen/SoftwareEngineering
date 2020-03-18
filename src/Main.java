import DCRGraphVis.ImageType;
import DCRGraphVis.LayoutAlgorithms.FRLayoutAlgorithm;
import DCRGraphVis.Visualizer;
import Parser.InputFileParser;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: jar DCRGraphVis [options] <input file>");
            System.out.println("\n Options:");
            System.out.println("\t output format:\t\t -jpg -png. Defaults to png.");
        }

        var parser = new InputFileParser();
        var dcrGraph = parser.parse("");

        var layoutAlg = new FRLayoutAlgorithm();
        var visualizer = new Visualizer(layoutAlg);

        var requestedImageType = getImageTypeFromArguments(args);
        try {
            var fileNameWithOutExt = args[args.length - 1].replaceFirst("[.][^.]+$", "");
            visualizer.GenerateImage(dcrGraph, fileNameWithOutExt + "_DCRGraphVis." + requestedImageType.toString(), requestedImageType);
        } catch (IOException ioException) {
            System.out.println("An unexpected error occurred: \n " + ioException.getMessage() + "\n" + ioException.getStackTrace());
        }
    }

    private static ImageType getImageTypeFromArguments(String[] args) {
        for (String arg : args)
            switch (arg.toLowerCase()) {
                case "-jpg":
                    return ImageType.JPG;
                case "-png":
                    return ImageType.PNG;
            }

        return ImageType.PNG;
    }
}
