package mts.teta.resizer.imageprocessor;

import mts.teta.resizer.ResizerApp;

public interface ImageCheckable {

  default boolean isAnyNotNullAndAnyNull(Object... args) {
    boolean notNull = false;
    boolean anyNull = false;
    for (Object arg : args) {
      if (!notNull && arg != null) {
        notNull = true;
      }
      if (!anyNull && arg == null) {
        anyNull = true;
      }
      if (notNull && anyNull) {
        return true;
      }
    }
    return false;
  }

  default boolean isAnyNull(Object... args) {
    for (Object arg : args) {
      if (arg == null) {
        return true;
      }
    }
    return false;
  }

  default boolean checkIfBlur(ResizerApp resizerApp) {
    return !(resizerApp.getBlurRadius() != null && resizerApp.getBlurRadius() < 0);
  }

  default boolean checkIfQuality(ResizerApp resizerApp) {
    if (resizerApp.getQuality() != null && resizerApp.getQuality() < 1) {
      return false;
    }
    return true;
  }

  default boolean checkIfCrop(ResizerApp resizerApp) {
    if (isAnyNotNullAndAnyNull(resizerApp.getCropHeight(),
        resizerApp.getCropWidth(),
        resizerApp.getCropX(),
        resizerApp.getCropY())) {
      return false;
    }
    if (!isAnyNull(resizerApp.getCropHeight(),
        resizerApp.getCropWidth(),
        resizerApp.getCropX(),
        resizerApp.getCropY())) {
      return resizerApp.getCropHeight() >= 1 && resizerApp.getCropWidth() >= 1
          && resizerApp.getCropX() >= 1 && resizerApp.getCropY() >= 1;
    }
    return true;
  }

  default boolean checkIfResize(ResizerApp resizerApp) {
    if (isAnyNotNullAndAnyNull(resizerApp.getResizeWidth(), resizerApp.getResizeHeight())) {
      return false;
    }
    if (!isAnyNull(resizerApp.getResizeWidth(), resizerApp.getResizeHeight())) {
      return resizerApp.getResizeWidth() >= 1 && resizerApp.getResizeHeight() >= 1;
    }
    return true;
  }

  default boolean isValidArgsInput(ResizerApp resizerApp) {
    return checkIfResize(resizerApp) && checkIfQuality(resizerApp) &&
        checkIfCrop(resizerApp) && checkIfBlur(resizerApp);
  }
}
