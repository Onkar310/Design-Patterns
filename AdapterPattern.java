import java.io.File;


class LegacyPrinter {
    public void printDocument(String text) {
        System.out.println("Printing document: " + text);
    }
}


interface Printer {
    void print(File file);
}


class LegacyPrinterAdapter implements Printer {
    private LegacyPrinter legacyPrinter;

    public LegacyPrinterAdapter(LegacyPrinter legacyPrinter) {
        this.legacyPrinter = legacyPrinter;
    }

    @Override
    public void print(File file) {
        
        String content = readContentFromFile(file);
        legacyPrinter.printDocument(content);
    }

    private String readContentFromFile(File file) {
       return "Content of file: " + file.getName();
    }
}


public class AdapterPattern {
    public static void main(String[] args) {
        LegacyPrinter legacyPrinter = new LegacyPrinter();
        Printer printerAdapter = new LegacyPrinterAdapter(legacyPrinter);
        File file = new File("example.txt");
        printerAdapter.print(file);
    }
}
