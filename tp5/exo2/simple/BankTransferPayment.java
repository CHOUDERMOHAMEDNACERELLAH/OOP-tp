package tp5.exo2.simple;

public class BankTransferPayment implements Payable {
    private String accountHolder;
    private String maskedAccountNumber;

    public BankTransferPayment(String accountHolder, String accountNumber) {
        this.accountHolder = accountHolder;
        this.maskedAccountNumber = "****" + accountNumber.substring(accountNumber.length() - 4);
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getMaskedAccountNumber() {
        return maskedAccountNumber;
    }

    public void pay(double amount) {
        System.out.println("[Bank Transfer] Transfer of " + String.format("%.2f", amount)
                + " DA initiated by " + accountHolder + " (Account: " + maskedAccountNumber + ").");
    }

    public void refund(double amount) {
        System.out.println("[Bank Transfer] Reversal of " + String.format("%.2f", amount)
                + " DA to " + accountHolder + " (Account: " + maskedAccountNumber + ").");
    }

    public String getPaymentMethod() {
        return "Bank Transfer";
    }

    public String toString() {
        return "[Bank Transfer] " + accountHolder + " | Account: " + maskedAccountNumber;
    }
}
