package tp5.exo2.simple;

public class Main {
    public static void main(String[] args) {
        Payable[] methods = {
                new CreditCardPayment("Ali Mansour", "1234567890123456"),
                new PayPalPayment("sara.boudia@email.com"),
                new BankTransferPayment("Karim Hadj", "0987654321")
        };

        System.out.println("=== Registered Payment Methods ===");
        for (Payable p : methods) {
            System.out.println("  " + p);
        }

        System.out.println("\n=== Processing Payments (1500.00 DA) ===");
        for (Payable p : methods) {
            p.pay(1500.00);
        }

        System.out.println("\n=== Processing Refunds (300.00 DA) ===");
        for (Payable p : methods) {
            p.refund(300.00);
        }
    }
}
