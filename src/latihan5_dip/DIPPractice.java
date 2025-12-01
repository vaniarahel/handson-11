package latihan5_dip;
import latihan5_dip.good.*;

public class DIPPractice {
    public static void main(String[] args) {
        // ... (BAD PRACTICE code here) ...

        System.out.println("\n" + "=".repeat(70));

        // ===== PART 2: GOOD PRACTICE - Mengikuti DIP =====
        System.out.println("\n=== GOOD PRACTICE: Mengikuti DIP ===\n");

        // UNCOMMENT CODE DI BAWAH SETELAH REFACTORING SELESAI
        System.out.println("--- Setup 1: Stripe Payment Gateway ---");
        // Create concrete implementations (low-level modules)
        CardValidator cardValidator = new LuhnCardValidator();
        FraudDetector fraudDetector = new RuleBasedFraudDetector();
        PaymentGateway stripeGateway = new StripePaymentGateway();
        TransactionLogger transactionLogger = new DatabaseTransactionLogger();
        NotificationSender notificationSender = new EmailNotificationSender();

        // Inject dependencies into PaymentService (high-level module)
        // PaymentService depend on ABSTRACTIONS, not concrete classes
        PaymentService stripePaymentService = new PaymentService(
                cardValidator,
                fraudDetector,
                stripeGateway,
                transactionLogger,
                notificationSender
        );

        stripePaymentService.processPayment("4532-1234-5678-9010", 150000.0, "user@example.com");

        System.out.println("\n" + "=".repeat(70));
        System.out.println("\n--- Setup 2: PayPal Payment Gateway ---");

        // Bisa dengan mudah ganti implementasi tanpa ubah PaymentService!
        // Cukup ganti PaymentGateway saja
        PaymentGateway paypalGateway = new PayPalPaymentGateway(); // Buat class ini

        PaymentService paypalPaymentService = new PaymentService(
                cardValidator,
                fraudDetector,
                paypalGateway,  // Ganti gateway
                transactionLogger,
                notificationSender
        );

        paypalPaymentService.processPayment("4532-9876-5432-1098", 250000.0, "buyer@example.com");

        System.out.println("\n" + "=".repeat(70));
        System.out.println("\n--- Setup 3: Testing with Mock (for Unit Testing) ---");

        // Untuk unit testing, bisa inject mock objects
        // PaymentService mockService = new PaymentService(
        //      new MockCardValidator(),
        //      new MockFraudDetector(),
        //      new MockPaymentGateway(),
        //      new MockTransactionLogger(),
        //      new MockNotificationSender()
        // );
        // mockService.processPayment("1234-5678-9012-3456", 100000.0, "test@example.com");

        System.out.println("\n--- Keuntungan Setelah Refactoring ---");
        System.out.println("✓ Loose coupling - PaymentService tidak depend on concrete classes");
        System.out.println("✓ Easy to test - Bisa inject mock dependencies untuk unit testing");
        System.out.println("✓ Flexible - Bisa ganti gateway dari Stripe ke PayPal tanpa ubah PaymentService");
        System.out.println("✓ Reusable - PaymentService bisa digunakan dengan berbagai implementasi");
        System.out.println("✓ Follow DIP - High-level module depend on abstractions");
        System.out.println("✓ Open for extension - Mudah tambah payment gateway baru");

        // ... (EKSPEKTASI OUTPUT comments here) ...
    }
}
