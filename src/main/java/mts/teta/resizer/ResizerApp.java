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

  private static final String APP_NAME = "resizer";
  private static final String VERSION = APP_NAME + " 0.0.1";
  private static final String GITHUB_LINK = "https://github.com/kukinpower/crop-crop";
  private static final String DESCRIPTION = "Available formats: jpeg png";
  private static final String RESIZE_OPTION = "--resize";
  private static final String RESIZE_PARAMS = "width height";
  private static final String RESIZE_DESCRIPTION = "resize the image";
  private static final String QUALITY_OPTION = "--quality";
  private static final String QUALITY_PARAMS = "value";
  private static final String QUALITY_DESCRIPTION = "PEG/PNG compression level";
  private static final String CROP_OPTION = "--crop";
  private static final String CROP_PARAMS = "width height x y";
  private static final String CROP_DESCRIPTION = "сut out one or more rectangular regions of the image";
  private static final String BLUR_OPTION = "--blur";
  private static final String BLUR_PARAMS = "{radius}";
  private static final String BLUR_DESCRIPTION = "reduce image noise and reduce detail levels";
  private static final String FORMAT_OPTION = "--format";
  private static final String FORMAT_PARAMS = "\"outputFormat\"";
  private static final String FORMAT_DESCRIPTION = "the image format type";
  private static final String HELP = String.join(System.lineSeparator(),
      "Version: " + VERSION + " " + GITHUB_LINK,
      DESCRIPTION,
      "Usage: convert input-file [options ...] output-file",
      "Options Settings:",
      createOptionString(RESIZE_OPTION, RESIZE_PARAMS, RESIZE_DESCRIPTION),
      createOptionString(QUALITY_OPTION, QUALITY_PARAMS, QUALITY_DESCRIPTION),
      createOptionString(CROP_OPTION, CROP_PARAMS, CROP_DESCRIPTION),
      createOptionString(BLUR_OPTION, BLUR_PARAMS, BLUR_DESCRIPTION),
      createOptionString(FORMAT_OPTION, FORMAT_PARAMS, FORMAT_DESCRIPTION)
  );

  private static String createOptionString(String option, String params, String description) {
    return String.format("  %-29s %s", option + " " + params, description);
  }

  protected void printHelp() {
    System.err.println(HELP);
  }
}

class ImageProcessor {

}

@CommandLine.Command(name = "resizer", mixinStandardHelpOptions = true, version = "resizer 0.0.1", description = "...")
public class ResizerApp extends ConsoleAttributes implements Callable<Integer> {

  private File inputFile;
  private File outputFile;
  private Integer resizeWidth;
  private Integer resizeHeight;
  private Integer quality;

  public void setInputFile(File file) {
    if (file.exists()) {
      inputFile = file;
    }
  }

  public void setOutputFile(File file) {
    if (file.exists()) {
      outputFile = file;
    }
  }

  public void setResizeWidth(Integer reducedPreviewWidth) {
    resizeWidth = reducedPreviewWidth;
  }

  public void setResizeHeight(Integer reducedPreviewHeight) {
    resizeHeight = reducedPreviewHeight;
  }

  public void setQuality(Integer quality) {
    this.quality = quality;
  }

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
//        imageProcessor.processImage(ImageIO.read(inputFile), this);
    return 0;
  }
}
