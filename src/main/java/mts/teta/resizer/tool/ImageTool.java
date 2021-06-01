package mts.teta.resizer.tool;

import java.awt.image.BufferedImage;
import mts.teta.resizer.ResizerApp;

public interface ImageTool<T> {

  public T execute(BufferedImage bufferedImage, ResizerApp resizerApp);
}
