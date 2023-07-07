package com.solution;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.solution.Adapter.logger;
import static com.solution.ImageType.*;

public class Adapter {
    public static final Logger logger = Logger.getLogger(Adapter.class.getName());

    public static void main(String[] args) {

        ViewerFactory factory = new ViewerFactory();
        Format<? extends Image> webp = factory.createFormat(WEBP);
        Format<? extends Image> jpg = factory.createFormat(ImageType.JPG);
        Format<? extends Image> png = factory.createFormat(ImageType.PNG);

        ImageViewer webpViewer = new ImageViewerAdapter(webp.getValue());
        ImageViewer jpgViewer = new ImageViewerAdapter(png.getValue());
        ImageViewer pngViewer = new ImageViewerAdapter(jpg.getValue());
        webpViewer.view();
        jpgViewer.view();
        pngViewer.view();

        ImageCompressionStrategy strategy = new JpgCompressionStrategy();
        jpg.getValue().compress(getImageData(strategy, "image.jpg"));
        webp.getValue().compress(getImageData(strategy, "image.webp"));
        png.getValue().compress(getImageData(strategy, "image.ppg"));
    }

    @SneakyThrows
    private static byte[] getImageData(
            ImageCompressionStrategy strategy, String filename) {
        return strategy.compress(
                Files.readAllBytes(
                        Paths.get(filename)));
    }
}

@Getter
@AllArgsConstructor
abstract class Image implements ImageCompressionStrategy {
    protected ImageType type;

    void display() {
        logger.log(Level.INFO, type.name());
    }
}

@Getter
class WebP extends Image {
    private int compressionLevel;

    public WebP(ImageType type) {
        super(type);
    }

    public WebP(ImageType type, int compressionLevel) {
        super(type);
        this.compressionLevel = compressionLevel;
    }

    @Override
    public byte[] compress(byte[] imageData) {
        return getBytes(imageData, type);
    }
}

@Getter
class Jpg extends Image {
    private int quality;

    public Jpg(ImageType type) {
        super(type);
    }

    public Jpg(ImageType type, int quality) {
        super(type);
        this.quality = quality;
    }

    @Override
    public byte[] compress(byte[] imageData) {
        return getBytes(imageData, type);
    }
}

@Getter
class Png extends Image {
    private boolean opacity;

    public Png(ImageType type) {
        super(type);
    }

    public Png(ImageType type, boolean opacity) {
        super(type);
        this.opacity = opacity;
    }

    @Override
    public byte[] compress(byte[] imageData) {
        return getBytes(imageData, type);
    }
}

@Getter
@AllArgsConstructor
class Format<T> {
    private T value;
}

interface FormatFactory<T> {
    Format<T> createFormat(ImageType type);
}

class WebPFormatFactory implements FormatFactory<WebP> {
    @Override
    public Format<WebP> createFormat(ImageType type) {
        return new Format<>(new WebP(type));
    }
}

class JpgFormatFactory implements FormatFactory<Jpg> {
    @Override
    public Format<Jpg> createFormat(ImageType type) {
        return new Format<>(new Jpg(type));
    }
}

class PngFormatFactory implements FormatFactory<Png> {
    @Override
    public Format<Png> createFormat(ImageType type) {
        return new Format<>(new Png(type));
    }
}

interface ImageFormatFactory {
    Format<? extends Image> createFormat(ImageType type);
}

class ViewerFactory implements ImageFormatFactory {
    private final FormatFactory<? extends Image> webPFactory = new WebPFormatFactory();
    private final FormatFactory<? extends Image> jpgFactory = new JpgFormatFactory();
    private final FormatFactory<? extends Image> pngFactory = new PngFormatFactory();

    @Override
    public Format<? extends Image> createFormat(ImageType type) {
        Format<? extends Image> format;
        if (type == WEBP) {
            format = webPFactory.createFormat(type);
        } else if (type == ImageType.JPG) {
            format = jpgFactory.createFormat(type);
        } else if (type == ImageType.PNG) {
            format = pngFactory.createFormat(type);
        } else {
            throw new IllegalArgumentException("No viewer registered for the image type: " + type);
        }
        return format;
    }
}

@AllArgsConstructor
class ImageViewerAdapter implements ImageViewer {
    private final Image image;

    @Override
    public void view() {
        image.display();
    }
}

interface ImageViewer {
    void view();
}

enum ImageType {
    PNG, WEBP, JPG
}

interface ImageCompressionStrategy {
    byte[] compress(byte[] imageData);

    @SneakyThrows
    default byte[] getBytes(byte[] imageData, ImageType type) {
        BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageData));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, type.name().toLowerCase(Locale.ROOT), outputStream);
        return outputStream.toByteArray();
    }
}

class PngCompressionStrategy
        implements ImageCompressionStrategy {
    @Override
    public byte[] compress(byte[] imageData) {
        return getBytes(imageData, PNG);
    }
}

class JpgCompressionStrategy
        implements ImageCompressionStrategy {
    @Override
    public byte[] compress(byte[] imageData) {
        return getBytes(imageData, JPG);
    }
}

class WebPCompressionStrategy
        implements ImageCompressionStrategy {
    @Override
    public byte[] compress(byte[] imageData) {
        return getBytes(imageData, WEBP);
    }
}
