// Person.java

public class Person {
    private final String firstName;
    private final String lastName;
    private final String middleName;
    private final String email;
    private final String phone;

    private Person(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.middleName = builder.middleName;
        this.email = builder.email;
        this.phone = builder.phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public static class Builder {
        private final String firstName;
        private final String lastName;
        private String middleName;
        private String email;
        private String phone;

        public Builder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    public static void main(String[] args) {
        // Example usage:
        Person person = new Person.Builder("John", "Doe")
                            .middleName("Smith")
                            .email("john.doe@example.com")
                            .phone("123-456-7890")
                            .build();

        System.out.println("First Name: " + person.getFirstName());
        System.out.println("Last Name: " + person.getLastName());
        System.out.println("Middle Name: " + person.getMiddleName());
        System.out.println("Email: " + person.getEmail());
        System.out.println("Phone: " + person.getPhone());
    }
}
