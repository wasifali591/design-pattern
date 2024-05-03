import java.util.concurrent.ThreadLocalRandom;

// BookingService class responsible for booking a hotel room
class BookingService {
    public void bookRoom() throws Exception {
        // Simulate booking a room
        System.out.println("Booking a hotel room...");
        // Simulate random failure
        if (ThreadLocalRandom.current().nextBoolean()) {
            throw new Exception("Booking failed");
        }
        System.out.println("Room booked successfully");
    }

    public void cancelRoomBooking() {
        // Simulate canceling the room booking (compensating action)
        System.out.println("Canceling hotel room booking...");
    }
}

// PaymentService class responsible for processing payment
class PaymentService {
    public void processPayment() throws Exception {
        // Simulate processing payment
        System.out.println("Processing payment...");
        // Simulate random failure
        if (ThreadLocalRandom.current().nextBoolean()) {
            throw new Exception("Payment failed");
        }
        System.out.println("Payment processed successfully");
    }

    public void refundPayment() {
        // Simulate refunding the payment (compensating action)
        System.out.println("Refunding payment...");
    }
}

// NotificationService class responsible for sending confirmation
class NotificationService {
    public void sendConfirmation() throws Exception {
        // Simulate sending confirmation
        System.out.println("Sending confirmation...");
        // Simulate random failure
        if (ThreadLocalRandom.current().nextBoolean()) {
            throw new Exception("Confirmation email sending failed");
        }
        System.out.println("Confirmation sent successfully");
    }
}

// SagaOrchestrator class coordinating the saga
class SagaOrchestrator {
    public void bookHotelRoomSaga() {
        try {
            // Step 1: Book a room
            BookingService bookingService = new BookingService();
            bookingService.bookRoom();

            // Step 2: Process payment
            PaymentService paymentService = new PaymentService();
            paymentService.processPayment();

            // Step 3: Send confirmation
            NotificationService notificationService = new NotificationService();
            notificationService.sendConfirmation();

            System.out.println("Hotel booking saga completed successfully");
        } catch (Exception e) {
            // If any step fails, catch the exception
            System.out.println("Hotel booking saga failed: " + e.getMessage());
            // Perform compensation to maintain data consistency
            compensate();
        }
    }

    private void compensate() {
        // Execute compensating actions
        try {
            BookingService bookingService = new BookingService();
            bookingService.cancelRoomBooking();
        } catch (Exception e) {
            System.out.println("Failed to compensate for room booking: " + e.getMessage());
        }

        try {
            PaymentService paymentService = new PaymentService();
            paymentService.refundPayment();
        } catch (Exception e) {
            System.out.println("Failed to compensate for payment: " + e.getMessage());
        }
    }
}

// Main class to demonstrate the Saga pattern
public class SagaPattern {
    public static void main(String[] args) {
        // Create an instance of the SagaOrchestrator and start the saga
        SagaOrchestrator orchestrator = new SagaOrchestrator();
        orchestrator.bookHotelRoomSaga();
    }
}
