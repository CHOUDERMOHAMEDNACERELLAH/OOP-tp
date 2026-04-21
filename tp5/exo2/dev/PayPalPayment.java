package tp5.exo2.dev;

public class PayPalPayment implements Payable {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void pay(double amount) {
        System.out.println("[PayPal] Payment of " + String.format("%.2f", amount)
                + " DA sent from account " + email + ".");
    }

    public void refund(double amount) {
        System.out.println("[PayPal] Refund of " + String.format("%.2f", amount)
                + " DA returned to account " + email + ".");
    }

    public String getPaymentMethod() {
        return "PayPal";
    }

    public String toString() {
        return "[PayPal] " + email;
    }
}
