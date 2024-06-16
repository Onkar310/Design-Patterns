// PrototypeExample.java

// Prototype interface
interface Prototype {
    Prototype clone();
}

// Concrete prototype
class Person implements Prototype {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    public Person(Person person) {
        this.name = person.name;
        this.age = person.age;
    }

    @Override
    public Prototype clone() {
        return new Person(this); // Using copy constructor to create a deep copy
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

// Client code
public class Shape {
    public static void main(String[] args) {
        // Original person object
        Person original = new Person("John Doe", 30);

        // Cloning the original person object
        Person clone = (Person) original.clone();

        // Output original and clone
        System.out.println("Original: " + original);
        System.out.println("Clone: " + clone);
    }
}
