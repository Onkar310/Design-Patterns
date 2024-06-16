
public interface Image {
    void display();
}


public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading image: " + filename);
        
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
        
    }
}


public class ImageProxy implements Image {
    private RealImage realImage;
    private String filename;

    public ImageProxy(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}


public class ProxyPattern {
    public static void main(String[] args) {
        Image image = new ImageProxy("example.jpg");
        image.display();
    }
}
