package tp5.exo2.simple;

public interface Payable {
    void pay(double amount);

    void refund(double amount);

    String getPaymentMethod();
}
