import java.io.InputStream;

interface ImageReader {
    public DecodedImage getDecodedImage();
}

class GifReader implements ImageReader {
    DecodedImage decodedImage;
    public GifReader( InputStream in ) {
        // check that it's a gif, throw exception if it's not, then if it is decode it.
    }

    public DecodedImage getDecodedImage() {
        return decodedImage;
    }
}

class DecodedImage {}

class JpegReader implements ImageReader {
    @Override
    public DecodedImage getDecodedImage() {
        return null;
    }
    //...
}
