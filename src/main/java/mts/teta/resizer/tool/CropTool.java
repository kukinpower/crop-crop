package mts.teta.resizer.tool;

import java.awt.image.BufferedImage;
import marvin.image.MarvinImage;
import marvinplugins.MarvinPluginCollection;
import mts.teta.resizer.ResizerApp;

public class CropTool implements ImageTool<MarvinImage> {

  @Override
  public MarvinImage execute(BufferedImage bufferedImage, ResizerApp resizerApp) {
    MarvinImage marvinImage = new MarvinImage(bufferedImage);
    MarvinPluginCollection.crop(marvinImage.clone(), marvinImage, resizerApp.getCropX(), resizerApp.getCropY(), resizerApp.getCropWidth(), resizerApp.getCropHeight());
    return marvinImage;
  }
}
