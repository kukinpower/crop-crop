package mts.teta.resizer.tool;

import java.awt.image.BufferedImage;
import mts.teta.resizer.ResizerApp;
import net.coobird.thumbnailator.Thumbnails;

public class ResizeTool implements ImageTool<Thumbnails.Builder<BufferedImage>> {

  @Override
  public Thumbnails.Builder<BufferedImage> execute(BufferedImage bufferedImage,
      ResizerApp resizerApp) {
    return Thumbnails.of(bufferedImage)
        .forceSize(resizerApp.getResizeWidth(), resizerApp.getResizeHeight());
  }
}
