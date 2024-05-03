
/**
 * The Bulkhead pattern is a design pattern used in distributed systems to improve fault isolation and
 * resilience by limiting the impact of failures in one part of the system on other parts. It's named
 * after the watertight compartments in ships (bulkheads) that prevent flooding in one area from
 * affecting the entire vessel.
 * 
 * @author wasif
 * @version 1.0
 * @since 03/05/2024
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Bulkhead class managing resources and isolating failures
class ResourceBulkhead {
    private ExecutorService threadPool;

    // Constructor to initialize the bulkhead with a fixed-size thread pool
    public ResourceBulkhead(int poolSize) {
        // Create a fixed-size thread pool for the bulkhead
        threadPool = Executors.newFixedThreadPool(poolSize);
    }

    // Method to execute a task within the bulkhead
    public void executeTask(Runnable task) {
        // Submit the task to the thread pool for execution
        threadPool.submit(task);
    }

    // Method to shut down the bulkhead and release resources
    public void shutdown() {
        // Shut down the thread pool when no longer needed
        threadPool.shutdown();
    }
}

// Main class to demonstrate the Bulkhead pattern
public class BulkheadPattern {
    public static void main(String[] args) {
        // Create a bulkhead with a pool size of 3 threads
        ResourceBulkhead bulkhead = new ResourceBulkhead(3);

        // Simulate executing tasks within the bulkhead
        for (int i = 0; i < 5; i++) {
            int taskId = i + 1;
            bulkhead.executeTask(() -> {
                // Simulate task execution
                System.out.println("Task " + taskId + " executing in thread: " + Thread.currentThread().getName());
                // Simulate task execution time
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task " + taskId + " completed");
            });
        }

        // Shut down the bulkhead after tasks are completed
        bulkhead.shutdown();
    }
}