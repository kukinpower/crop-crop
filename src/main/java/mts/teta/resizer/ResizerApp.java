package mts.teta.resizer;

import java.util.concurrent.Callable;
import javax.imageio.ImageIO;
import mts.teta.resizer.consoleattributes.ConsoleAttributes;
import mts.teta.resizer.imageprocessor.ImageProcessor;
import picocli.CommandLine;

public class ResizerApp extends ConsoleAttributes implements Callable<Integer> {

  public static void main(String... args) {
    int exitCode = 1;
    if (args.length < 2) {
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
    imageProcessor.processImage(ImageIO.read(getInputFile()), this);
    return 0;
  }
}
