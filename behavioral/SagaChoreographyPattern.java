/**
 * The Saga Choreography pattern is an alternative to the Saga pattern for
 * managing distributed transactions in a microservices architecture. While the
 * Saga pattern typically employs a central orchestrator to coordinate the
 * transaction's steps, the Saga Choreography pattern distributes the
 * coordination responsibility among the participating services themselves.
 * 
 * @author wasif
 * @version 1.0
 * @since 03/05/2024
 */

// BookingService emits events for booking a room and canceling the booking
class BookingService {
    // Method to book a room
    public void bookRoom() {
        // Simulate booking a room
        System.out.println("Booking a hotel room...");
        // Simulate room booking
        System.out.println("Room booked successfully");
        // Emit event: Room booked
        emitEvent("RoomBookedEvent");
    }

    // Method to cancel a room booking
    public void cancelRoomBooking() {
        // Simulate canceling the room booking
        System.out.println("Canceling hotel room booking...");
        // Simulate room booking cancellation
        System.out.println("Room booking canceled");
        // Emit event: Room booking canceled
        emitEvent("RoomBookingCanceledEvent");
    }

    // Method to emit an event
    private void emitEvent(String eventName) {
        System.out.println("Event emitted: " + eventName);
    }
}

// PaymentService emits events for processing payment and refunding the payment
class PaymentService {
    // Method to process payment
    public void processPayment() {
        // Simulate processing payment
        System.out.println("Processing payment...");
        // Simulate payment processing
        System.out.println("Payment processed successfully");
        // Emit event: Payment processed
        emitEvent("PaymentProcessedEvent");
    }

    // Method to refund payment
    public void refundPayment() {
        // Simulate refunding the payment
        System.out.println("Refunding payment...");
        // Simulate payment refunding
        System.out.println("Payment refunded");
        // Emit event: Payment refunded
        emitEvent("PaymentRefundedEvent");
    }

    // Method to emit an event
    private void emitEvent(String eventName) {
        System.out.println("Event emitted: " + eventName);
    }
}

// NotificationService emits events for sending confirmation emails
class NotificationService {
    // Method to send confirmation
    public void sendConfirmation() {
        // Simulate sending confirmation
        System.out.println("Sending confirmation...");
        // Simulate confirmation sending
        System.out.println("Confirmation sent successfully");
        // Emit event: Confirmation sent
        emitEvent("ConfirmationSentEvent");
    }

    // Method to emit an event
    private void emitEvent(String eventName) {
        System.out.println("Event emitted: " + eventName);
    }
}

// SagaChoreography class to demonstrate the Saga Choreography pattern
class SagaChoreography {
    // Method to execute the saga
    public void executeSaga() {
        // Instantiate services
        BookingService bookingService = new BookingService();
        PaymentService paymentService = new PaymentService();
        NotificationService notificationService = new NotificationService();

        // Step 1: Book a room
        bookingService.bookRoom();

        // Step 2: Process payment
        paymentService.processPayment();

        // Step 3: Send confirmation
        notificationService.sendConfirmation();

        // Simulate a failure scenario where payment refund is required
        // In a real-world scenario, failure detection and compensation triggering would
        // be more sophisticated
        boolean paymentRefundRequired = true;
        if (paymentRefundRequired) {
            // Step 4: If payment refund is required, trigger compensating actions
            bookingService.cancelRoomBooking(); // Trigger compensating action for canceled room booking
            paymentService.refundPayment(); // Trigger compensating action for refunded payment
        }
    }
}

// Main class to call the SagaChoreography class and execute the saga
public class SagaChoreographyPattern {
    public static void main(String[] args) {
        // Instantiate SagaChoreography and execute the saga
        SagaChoreography saga = new SagaChoreography();
        saga.executeSaga();
    }
}