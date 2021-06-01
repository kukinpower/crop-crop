package mts.teta.resizer.tool;

import java.awt.image.BufferedImage;
import marvin.image.MarvinImage;
import marvinplugins.MarvinPluginCollection;
import mts.teta.resizer.ResizerApp;
import net.coobird.thumbnailator.Thumbnails;

public class QualityTool implements ImageTool<Thumbnails.Builder<BufferedImage>> {

  @Override
  public Thumbnails.Builder<BufferedImage> execute(BufferedImage bufferedImage, ResizerApp resizerApp) {
    return Thumbnails.of(bufferedImage).outputQuality(resizerApp.getQuality() * 1.0 / 100);
  }
}
