package mts.teta.resizer.tool;

import java.awt.image.BufferedImage;
import java.io.IOException;
import mts.teta.resizer.ResizerApp;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.Thumbnails.Builder;

public class FormatTool implements ImageTool<Builder<BufferedImage>> {

  @Override
  public Builder<BufferedImage> execute(BufferedImage bufferedImage,
      ResizerApp resizerApp) {
    Builder<BufferedImage> builder = Thumbnails.of(bufferedImage);
    try {
      builder.outputFormat(resizerApp.getOutputFormat()).toFile(resizerApp.getOutputFile());
      return builder;
    } catch (IOException e) {
      return null;
    }
  }
}
