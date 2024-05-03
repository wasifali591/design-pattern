
/**
 * The Factory Method pattern is a creational design pattern that provides an
 * interface for creating objects in a superclass, but allows subclasses to
 * alter the type of objects that will be created. It encapsulates the object
 * creation logic and allows the client code to work with instances of a class
 * without needing to know the specific implementation.
 * 
 * @author wasif
 * @version 1.0
 * @since 02/05/2024
 */

// Shape interface
interface Shape {
    void draw(); // Method to draw the shape
}

// Concrete implementations of Shape interface
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

// Factory interface or abstract class
interface ShapeFactory {
    Shape createShape(); // Factory method to create a shape
}

// Concrete implementations of ShapeFactory
class CircleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        // Create and return a new instance of Circle
        return new Circle();
    }
}

class RectangleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        // Create and return a new instance of Rectangle
        return new Rectangle();
    }
}

// Client code
public class FactoryMethod {
    public static void main(String[] args) {
        // Creating a Circle using CircleFactory
        ShapeFactory circleFactory = new CircleFactory();
        Shape circle = circleFactory.createShape(); // Factory method to create a Circle
        circle.draw(); // Output: Drawing Circle

        // Creating a Rectangle using RectangleFactory
        ShapeFactory rectangleFactory = new RectangleFactory();
        Shape rectangle = rectangleFactory.createShape(); // Factory method to create a Rectangle
        rectangle.draw(); // Output: Drawing Rectangle
    }
}