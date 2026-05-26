// Abstract parent class - demonstrates ABSTRACTION and INHERITANCE base
public abstract class Person {

    // Encapsulated (private) data members
    private int id;
    private String name;

    // Constructor - initializes Person
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters (Encapsulation)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Setters (Encapsulation)
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Abstract method - enforces POLYMORPHISM through method overriding
    public abstract void displayDetails();
}
