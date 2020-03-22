package dk.ku.di.oodcr;

import dk.ku.di.oodcr.parser.dcr.DCRGraphGrammarLexer;
import dk.ku.di.oodcr.parser.dcr.DCRGraphGrammarParser;

import dk.ku.di.oodcr.visualizer.ImageType;
import dk.ku.di.oodcr.visualizer.Visualizer;
import dk.ku.di.oodcr.visualizer.layoutalgorithms.FRLayoutAlgorithm;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: jar DCRGraphVis [options] <input file>");
            System.out.println("\n Options:");
            System.out.println("\t output format:\t\t -jpg -png. Defaults to png.");
        }

        var layoutAlg = new FRLayoutAlgorithm();
        var visualizer = new Visualizer(layoutAlg);

        var requestedImageType = getImageTypeFromArguments(args);
        try {
            var graphFilePath = args[args.length - 1];
            var actualParser = setupParser(graphFilePath);
            var fileNameWithOutExt = graphFilePath.replaceFirst("[.][^.]+$", "");
            var graph = actualParser.graph().value;
            visualizer.GenerateImage(graph, fileNameWithOutExt + "_DCRGraphVis." + requestedImageType.toString(), requestedImageType);
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

    private static DCRGraphGrammarParser setupParser(String filePathToParse) {

        DCRGraphGrammarLexer lexer = null;

        try {
            var inputStream = new FileInputStream(filePathToParse);
            lexer = new DCRGraphGrammarLexer(CharStreams.fromStream(inputStream, StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        DCRGraphGrammarParser parser = new DCRGraphGrammarParser(tokens);

        parser.setInputStream(new CommonTokenStream(lexer));

        return parser;
    }
}
