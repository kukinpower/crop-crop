package mts.teta.resizer;

import picocli.CommandLine;

public class ConsoleAttributes {

  private static final String APP_NAME = "resizer";
  private static final String VERSION = APP_NAME + " 0.0.1";
  private static final String GITHUB_LINK = "https://github.com/kukinpower/crop-crop";
  private static final String DESCRIPTION = "Available formats: jpeg png";
  private static final String HEADER_HEADING = "Usage: convert input-file [options ...] output-file\nOptions Settings:";

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
      HEADER_HEADING,
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

  @CommandLine.Command(name = APP_NAME,
      mixinStandardHelpOptions = true,
      version = VERSION,
      description = DESCRIPTION,
      headerHeading = HEADER_HEADING)

  @CommandLine.Option(names = RESIZE_OPTION, paramLabel = RESIZE_PARAMS, description = RESIZE_DESCRIPTION)
  protected Integer[] resize = new Integer[2];

  @CommandLine.Option(names = QUALITY_OPTION, paramLabel = QUALITY_PARAMS, description = QUALITY_DESCRIPTION)
  protected Integer quality;

  @CommandLine.Option(names = CROP_OPTION, paramLabel = CROP_PARAMS, description = CROP_DESCRIPTION)
  protected Integer[] crop = new Integer[4];

  @CommandLine.Option(names = BLUR_OPTION, paramLabel = BLUR_PARAMS, description = BLUR_DESCRIPTION)
  private Integer blurRadius;

  @CommandLine.Option(names = FORMAT_OPTION, paramLabel = FORMAT_PARAMS, description = FORMAT_DESCRIPTION)
  private String outputFormat;

  public Integer getResizeWidth() {
    return resize[0];
  }

  public Integer getResizeHeight() {
    return resize[1];
  }

  public void setResizeWidth(Integer width) {
    this.resize[0] = width;
  }

  public void setResizeHeight(Integer height) {
    this.resize[1] = height;
  }

  public Integer getQuality() {
    return quality;
  }

  public void setQuality(Integer quality) {
    this.quality = quality;
  }

  public Integer getCropWidth() {
    return crop[0];
  }

  public Integer getCropHeight() {
    return crop[1];
  }

  public Integer getCropX() {
    return crop[2];
  }

  public Integer getCropY() {
    return crop[3];
  }

  public void setCropWidth(Integer width) {
    this.crop[0] = width;
  }

  public void setCropHeight(Integer height) {
    this.crop[1] = height;
  }

  public void setCropY(Integer y) {
    this.crop[2] = y;
  }

  public void setCropX(Integer x) {
    this.crop[3] = x;
  }

  public Integer getBlurRadius() {
    return blurRadius;
  }

  public void setBlurRadius(Integer blurRadius) {
    this.blurRadius = blurRadius;
  }

  public String getOutputFormat() {
    return outputFormat;
  }

  public void setOutputFormat(String outputFormat) {
    this.outputFormat = outputFormat;
  }

  public static void main(String[] args) {
    new ConsoleAttributes().printHelp();
  }
}
