package mts.teta.resizer.imageprocessor;

import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;
import marvinplugins.MarvinPluginCollection;
import mts.teta.resizer.ResizerApp;
import mts.teta.resizer.exception.BadAttributesException;
import net.coobird.thumbnailator.Thumbnails;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageProcessor implements ImageCheckable {
  private Thumbnails.Builder<BufferedImage> thumbnailsBuilder;
  private MarvinImage marvinImage;

  public void processImage (BufferedImage image, ResizerApp app) throws BadAttributesException, IOException {

    if (!isValidArgsInput(app)) {
      throw new BadAttributesException("Please check params!");
    }

  }
}


//public class ImageProcessor implements ImageCheckable {
//  private Thumbnails.Builder<BufferedImage> thumbnailsBuilder;
//  private MarvinImage marvinImage;
//
//
//  public void processImage (BufferedImage image, ResizerApp app) throws BadAttributesException, IOException {
//
//  private void processWithMarvinImage(BufferedImage bufferedImage, ResizerApp resizerApp)
//      throws BadAttributesException {
//    MarvinImage marvinImage = null;
//
//    if (resizerApp.getBlurRadius() != null) {
//      marvinImage = new BlurTool().execute(bufferedImage, resizerApp);
//    } else if (resizerApp.getCropWidth() != null) {
//      marvinImage = new CropTool().execute(bufferedImage, resizerApp);
//    }
//
//    if (marvinImage != null) {
//      MarvinImageIO.saveImage(marvinImage, resizerApp.getOutputFile().getAbsolutePath());
//    }
//    throw new BadAttributesException("Please check params!");
//  }
//
//  private void processWithThumbnailsBuilder(BufferedImage bufferedImage, ResizerApp resizerApp)
//      throws IOException, BadAttributesException {
//    Thumbnails.Builder<BufferedImage> thumbnailsBuilder = null;
//
//    if (resizerApp.getQuality() != null) {
//      thumbnailsBuilder = new QualityTool().execute(bufferedImage, resizerApp);
//    } else if (resizerApp.getResizeWidth() != null) {
//      thumbnailsBuilder = new ResizeTool().execute(bufferedImage, resizerApp);
//    } else if (resizerApp.getOutputFormat() != null) {
//      thumbnailsBuilder = new FormatTool().execute(bufferedImage, resizerApp);
//      if (thumbnailsBuilder == null) {
//        throw new BadAttributesException("Please check params!");
//      }
//      return;
//    }
//    if (thumbnailsBuilder != null) {
//      thumbnailsBuilder.outputFormat(resizerApp.getOutputFormat()).toFile(resizerApp.getOutputFile());
//    }
//    throw new BadAttributesException("Please check params!");
//  }
//
//  public void processImage(BufferedImage bufferedImage, ResizerApp resizerApp)
//      throws BadAttributesException, IOException {
//
//    // check arguments
//    if (!isValidArgsInput(resizerApp)) {
//      throw new BadAttributesException("Please check params!");
//    }
//
//    if (resizerApp.getBlurRadius() != null || resizerApp.getCropWidth() != null) {
//      processWithMarvinImage(bufferedImage, resizerApp);
//    } else if (resizerApp.getQuality() != null || resizerApp.getResizeWidth() != null || resizerApp.getOutputFormat() != null) {
//      processWithThumbnailsBuilder(bufferedImage, resizerApp);
//    }
//  }

//}
