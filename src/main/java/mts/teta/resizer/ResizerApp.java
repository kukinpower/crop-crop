package mts.teta.resizer;

import picocli.CommandLine;

import javax.imageio.ImageIO;
import java.util.concurrent.Callable;
import mts.teta.resizer.imageprocessor.BadAttributesException;
import picocli.CommandLine;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

class ConsoleAttributes {

}

class ImageProcessor {

}

@CommandLine.Command(name = "resizer", mixinStandardHelpOptions = true, version = "resizer 0.0.1", description = "...")
public class ResizerApp extends ConsoleAttributes implements Callable<Integer> {
    public static void main(String... args) {
        int exitCode = 1;
        if (args.length < 2) { //todo args count
            System.out.println("No args provided");
        } else {
            exitCode = runConsole(args);
        }
        System.exit(exitCode);
    }

    protected static int runConsole(String[] args) {
        return new CommandLine(new ResizerApp()).execute(args);
    }

    @Override
    public Integer call() throws Exception {
        ImageProcessor imageProcessor = new ImageProcessor();
        imageProcessor.processImage(ImageIO.read(inputFile), this);
        return 0;
    }
}
