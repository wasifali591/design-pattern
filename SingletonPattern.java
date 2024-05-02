/**
 * The Singleton pattern is a creational design pattern that ensures a class has
 * only one instance and provides a global point of access to that instance.
 * It's useful when exactly one object is needed to coordinate actions across
 * the system
 * 
 * @author wasif
 * @version 1.0
 * @since 02/05/2024
 */


//Singleton class
class Singleton {
    // Private static variable to hold the single instance of the class
    private static Singleton instance;

    // Private constructor to prevent instantiation from outside
    private Singleton() {
    }

    // Public static method to get the single instance of the class
    public static Singleton getInstance() {
        // Lazy initialization: create the instance if it doesn't exist yet
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Example method
    public void showMessage() {
        System.out.println("Hello, I am a Singleton instance!");
    }
}

//main
public class SingletonPattern {
    public static void main(String[] args) {
        // Get the singleton instance
        Singleton singleton = Singleton.getInstance();

        // Call methods on the singleton instance
        singleton.showMessage();
    }
}
