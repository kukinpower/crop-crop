package mts.teta.resizer.imageprocessor;

import java.awt.image.BufferedImage;
import java.io.IOException;
import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;
import marvinplugins.MarvinPluginCollection;
import mts.teta.resizer.ResizerApp;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.Thumbnails.Builder;

class ImageContainer {

  private BufferedImage bufferedImage;
  private ResizerApp resizerApp;
  private Builder<BufferedImage> thumbnailsBuilder;
  private MarvinImage marvinImage;

  public ImageContainer(BufferedImage bufferedImage, ResizerApp resizerApp) {
    this.bufferedImage = bufferedImage;
    this.resizerApp = resizerApp;
  }

  public ImageContainer(BufferedImage bufferedImage, ResizerApp resizerApp,
      Builder<BufferedImage> thumbnailsBuilder, MarvinImage marvinImage) {
    this.bufferedImage = bufferedImage;
    this.resizerApp = resizerApp;
    this.thumbnailsBuilder = thumbnailsBuilder;
    this.marvinImage = marvinImage;
  }

  public ImageContainer blur() throws IOException {
    if (resizerApp.getBlurRadius() == null) {
      return this;
    }

    if (thumbnailsBuilder != null) {
      bufferedImage = thumbnailsBuilder.asBufferedImage();
    }
    marvinImage = new MarvinImage(bufferedImage);
    MarvinPluginCollection
        .gaussianBlur(marvinImage.clone(), marvinImage, resizerApp.getBlurRadius());

    return this;
  }

  public ImageContainer crop() throws IOException {
    if (resizerApp.getCropHeight() == null) {
      return this;
    }

    if (marvinImage == null) {
      if (thumbnailsBuilder != null) {
        bufferedImage = thumbnailsBuilder.asBufferedImage();
      }
      marvinImage = new MarvinImage(bufferedImage);
    }

    MarvinPluginCollection.crop(marvinImage.clone(), marvinImage,
        resizerApp.getCropX(), resizerApp.getCropY(),
        resizerApp.getCropWidth(), resizerApp.getCropHeight());

    return this;
  }

  public ImageContainer changeQuality()
      throws IOException {
    if (resizerApp.getQuality() == null) {
      return this;
    }

    return new ImageContainer(bufferedImage,
        resizerApp,
        Thumbnails.of(bufferedImage).outputQuality(resizerApp.getQuality() * 1.0 / 100),
        marvinImage);
  }

  public ImageContainer resize()
      throws IOException {
    if (resizerApp.getResizeWidth() == null) {
      return this;
    }

    if (thumbnailsBuilder != null) {
      thumbnailsBuilder.forceSize(resizerApp.getResizeWidth(), resizerApp.getResizeHeight());
    } else {
      thumbnailsBuilder = Thumbnails.of(bufferedImage)
          .forceSize(resizerApp.getResizeWidth(), resizerApp.getResizeHeight());
    }

    return this;
  }

  private void processMarvinImageWrite() {
    if (resizerApp.getOutputFormat() != null) {
      MarvinImageIO.saveImage(marvinImage,
          resizerApp.getOutputFile().getAbsolutePath() + "." + resizerApp.getOutputFormat());
    } else {
      MarvinImageIO.saveImage(marvinImage, resizerApp.getOutputFile().getAbsolutePath());
    }
  }

  private void processBuilderWrite() throws IOException {
    if (resizerApp.getOutputFormat() != null) {
      thumbnailsBuilder.outputFormat(resizerApp.getOutputFormat())
          .toFile(resizerApp.getOutputFile());
    } else {
      thumbnailsBuilder.toFile(resizerApp.getOutputFile());
    }

  }

  public void callWrite() throws IOException {
    if (marvinImage != null) {
      processMarvinImageWrite();
    } else {
      processBuilderWrite();
    }
  }
}
