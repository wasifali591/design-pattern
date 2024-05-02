/**
 * The Builder pattern is a creational design pattern that allows the
 * construction of complex objects step by step. It separates the construction
 * of a complex object from its representation, enabling the same construction
 * process to create different representations. The Builder pattern is
 * particularly useful when dealing with objects that have a large number of
 * optional parameters or configurations.
 * 
 * @author wasif
 * @version 1.0
 * @since 02/05/2024
 */


// Product class representing a computer
class Computer {
    // Fields representing different components of a computer
    private String cpu;
    private String gpu;
    private int ram;
    private int storage;

    // Private constructor to prevent direct instantiation
    private Computer() {
    }

    // Getters for the computer components
    public String getCpu() {
        return cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    // Builder class for building Computer objects
    public static class Builder {
        // Fields representing the optional parameters
        private String cpu;
        private String gpu;
        private int ram;
        private int storage;

        // Setter methods for optional parameters, allowing method chaining (fluent
        // interface)
        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder gpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Builder ram(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder storage(int storage) {
            this.storage = storage;
            return this;
        }

        // Build method to construct the final object
        public Computer build() {
            // Create a new Computer instance and set its fields using the values from the
            // builder
            Computer computer = new Computer();
            computer.cpu = this.cpu;
            computer.gpu = this.gpu;
            computer.ram = this.ram;
            computer.storage = this.storage;
            return computer;
        }
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        // Create a Computer using the Builder pattern
        Computer computer = new Computer.Builder()
                .cpu("Intel i7")
                .gpu("Nvidia GTX 3080")
                .ram(16)
                .storage(512)
                .build();

        // Output the details of the Computer
        System.out.println("CPU: " + computer.getCpu());
        System.out.println("GPU: " + computer.getGpu());
        System.out.println("RAM: " + computer.getRam() + "GB");
        System.out.println("Storage: " + computer.getStorage() + "GB");
    }
}
