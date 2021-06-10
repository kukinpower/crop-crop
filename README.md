# Сrop-crop-resize-resize simple app

The goal was to create some simple app with interface like this:
```bash
Version: name version https://gitlab.com/link/
Available formats: jpeg png
Usage: convert input-file [options ...] output-file
Options Settings:
  --resize width height       resize the image
  --quality value             PEG/PNG compression level
  --crop width height x y     сut out one or more rectangular regions of the image
  --blur {radius}             reduce image noise and reduce detail levels 
  --format "outputFormat"     the image format type
```

Using libraries: [picocli.info](https://picocli.info/), [thumbnailator](https://github.com/coobird/thumbnailator), [marvin project](https://github.com/gabrielarchanjo/marvin-framework)

This project is a selection task for training courses "MTS-Teta"
