
/**
 * The Circuit Breaker pattern is a design pattern used in distributed systems to improve the fault
 * tolerance and resilience of services that depend on remote services or resources. It prevents cascading
 * failures by temporarily interrupting the flow of requests to a failing service or resource, thereby
 * allowing the system to gracefully degrade and recover.
 * 
 * @author wasif
 * @version 1.0
 * @since 02/05/2024
 */

import java.util.Random;

// CircuitBreaker class implementing the Circuit Breaker pattern
class CircuitBreaker {
    private static final int FAILURE_THRESHOLD = 3;
    private static final int COOLDOWN_PERIOD = 5000; // 5 seconds
    private int consecutiveFailures = 0;
    private long lastFailureTime = 0;

    // Method to handle requests with circuit breaker logic
    public String handleRequest() {
        if (isCircuitOpen()) {
            return "Fallback: Service unavailable";
        }

        // Simulate calling the dependent service or resource
        boolean success = callService();
        // System.out.println(success);

        if (!success) {
            handleFailure();
            return "Fallback: Service unavailable";
        }

        return "Success";
    }

    // Method to simulate calling the dependent service or resource
    private boolean callService() {
        // Simulate a random success/failure scenario
        Random random = new Random();
        return random.nextBoolean();
    }

    // Method to check if the circuit is open
    private boolean isCircuitOpen() {
        if (consecutiveFailures >= FAILURE_THRESHOLD
                && System.currentTimeMillis() - lastFailureTime < COOLDOWN_PERIOD) {
            return true;
        }
        return false;
    }

    // Method to handle failures and update circuit state
    private void handleFailure() {
        consecutiveFailures++;
        lastFailureTime = System.currentTimeMillis();
        // System.out.println(consecutiveFailures + "---" + lastFailureTime);
    }
}

// Main class to demonstrate the Circuit Breaker pattern
public class CircuitBreakerPattern {
    public static void main(String[] args) {
        CircuitBreaker circuitBreaker = new CircuitBreaker();

        // Simulate handling requests through the Circuit Breaker
        for (int i = 0; i < 10; i++) {
            System.out.println("Request " + (i + 1) + ": " + circuitBreaker.handleRequest());
        }
    }
}