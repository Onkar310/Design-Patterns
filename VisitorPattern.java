

import java.util.ArrayList;
import java.util.List;


interface PackageVisitor {
    void visit(DocumentPackage pack);
    void visit(FragilePackage pack);
    void visit(PerishablePackage pack);
}


class PackageProcessingVisitor implements PackageVisitor {
    @Override
    public void visit(DocumentPackage pack) {
        System.out.println("Processing document package: " + pack.getContent());
    }

    @Override
    public void visit(FragilePackage pack) {
        System.out.println("Processing fragile package with care: " + pack.getDescription());
    }

    @Override
    public void visit(PerishablePackage pack) {
        System.out.println("Processing perishable package with refrigeration: " + pack.getProductName());
    }
}

interface Package {
    void accept(PackageVisitor visitor);
}

class DocumentPackage implements Package {
    private String content;

    public DocumentPackage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public void accept(PackageVisitor visitor) {
        visitor.visit(this);
    }
}

class FragilePackage implements Package {
    private String description;

    public FragilePackage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void accept(PackageVisitor visitor) {
        visitor.visit(this);
    }
}

class PerishablePackage implements Package {
    private String productName;

    public PerishablePackage(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public void accept(PackageVisitor visitor) {
        visitor.visit(this);
    }
}

public class VisitorPatternExample {
    public static void main(String[] args) {
        List<Package> packages = new ArrayList<>();
        packages.add(new DocumentPackage("Important documents"));
        packages.add(new FragilePackage("Handle with care"));
        packages.add(new PerishablePackage("Fresh fruits"));

        PackageVisitor visitor = new PackageProcessingVisitor();

        for (Package pack : packages) {
            pack.accept(visitor);
        }
    }
}
