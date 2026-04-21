package tp5.exo2.simple;

public class CreditCardPayment implements Payable {
    private String cardHolder;
    private String maskedCardNumber;

    public CreditCardPayment(String cardHolder, String cardNumber) {
        this.cardHolder = cardHolder;
        this.maskedCardNumber = "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public String getMaskedCardNumber() {
        return maskedCardNumber;
    }

    public void pay(double amount) {
        System.out.println("[Credit Card] Payment of " + String.format("%.2f", amount)
                + " DA charged to " + cardHolder + " (" + maskedCardNumber + ").");
    }

    public void refund(double amount) {
        System.out.println("[Credit Card] Refund of " + String.format("%.2f", amount)
                + " DA credited to " + cardHolder + " (" + maskedCardNumber + ").");
    }

    public String getPaymentMethod() {
        return "Credit Card";
    }

    public String toString() {
        return "[Credit Card] " + cardHolder + " | Card: " + maskedCardNumber;
    }
}
