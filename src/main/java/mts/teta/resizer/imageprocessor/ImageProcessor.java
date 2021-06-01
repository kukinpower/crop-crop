package mts.teta.resizer.imageprocessor;

import java.awt.image.BufferedImage;
import java.io.IOException;
import mts.teta.resizer.ResizerApp;
import mts.teta.resizer.exception.BadAttributesException;

public class ImageProcessor implements ImageCheckable {

  public void processImage(BufferedImage image, ResizerApp resizerApp)
      throws BadAttributesException, IOException {
    if (!isValidArgsInput(resizerApp)) {
      throw new BadAttributesException("Please check params!");
    }

    new ImageContainer(image, resizerApp).changeQuality().resize().blur().crop().callWrite();
  }
}
