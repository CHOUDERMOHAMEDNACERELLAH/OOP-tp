package tp5.exo2.dev;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static List<Payable> methods = new ArrayList<Payable>();

    public static void main(String[] args) {
        methods.add(new CreditCardPayment("Ali Mansour", "1234567890123456"));
        methods.add(new PayPalPayment("sara.boudia@email.com"));
        methods.add(new BankTransferPayment("Karim Hadj", "0987654321"));

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Choice: ");
            switch (choice) {
                case 1:
                    showAll();
                    break;
                case 2:
                    addMethod();
                    break;
                case 3:
                    processPayment();
                    break;
                case 4:
                    processRefund();
                    break;
                case 5:
                    demoAll();
                    break;
                case 0:
                    System.out.println("\nGoodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("[!] Invalid choice.");
            }
        }
        scanner.close();
    }

    static void printMenu() {
        System.out.println("\n=== Marketplace Payment System ===");
        System.out.println("1. Show all payment methods");
        System.out.println("2. Add a payment method");
        System.out.println("3. Process a payment");
        System.out.println("4. Process a refund");
        System.out.println("5. Polymorphism demo (all methods)");
        System.out.println("0. Exit");
    }

    static void showAll() {
        if (methods.isEmpty()) {
            System.out.println("  No payment methods registered.");
            return;
        }
        System.out.println("\n--- Payment Methods (" + methods.size() + ") ---");
        for (int i = 0; i < methods.size(); i++) {
            System.out.println("  [" + i + "] " + methods.get(i));
        }
    }

    static void addMethod() {
        System.out.println("  1. Credit Card");
        System.out.println("  2. PayPal");
        System.out.println("  3. Bank Transfer");
        int type = readInt("Type: ");
        switch (type) {
            case 1:
                String holder = readString("Card holder name: ");
                String number = readString("Card number (16 digits): ");
                if (number.length() < 4) {
                    System.out.println("[!] Invalid card number.");
                    return;
                }
                methods.add(new CreditCardPayment(holder, number));
                break;
            case 2:
                String email = readString("PayPal email: ");
                methods.add(new PayPalPayment(email));
                break;
            case 3:
                String name = readString("Account holder name: ");
                String account = readString("Account number: ");
                if (account.length() < 4) {
                    System.out.println("[!] Invalid account number.");
                    return;
                }
                methods.add(new BankTransferPayment(name, account));
                break;
            default:
                System.out.println("[!] Invalid type.");
                return;
        }
        System.out.println("Added: " + methods.get(methods.size() - 1));
    }

    static void processPayment() {
        showAll();
        int idx = readInt("Select method index (-1 to cancel): ");
        if (idx == -1)
            return;
        if (idx < 0 || idx >= methods.size()) {
            System.out.println("[!] Invalid index.");
            return;
        }
        double amount = readDouble("Amount (DA): ");
        methods.get(idx).pay(amount);
    }

    static void processRefund() {
        showAll();
        int idx = readInt("Select method index (-1 to cancel): ");
        if (idx == -1)
            return;
        if (idx < 0 || idx >= methods.size()) {
            System.out.println("[!] Invalid index.");
            return;
        }
        double amount = readDouble("Amount (DA): ");
        methods.get(idx).refund(amount);
    }

    static void demoAll() {
        double amount = readDouble("Demo amount (DA): ");
        System.out.println("\n--- Paying " + String.format("%.2f", amount) + " DA via all methods ---");
        for (Payable p : methods) {
            p.pay(amount);
        }
        System.out.println("\n--- Refunding " + String.format("%.2f", amount / 2) + " DA via all methods ---");
        for (Payable p : methods) {
            p.refund(amount / 2);
        }
    }

    static int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print(prompt);
        }
        int val = scanner.nextInt();
        scanner.nextLine();
        return val;
    }

    static double readDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            scanner.next();
            System.out.print(prompt);
        }
        double val = scanner.nextDouble();
        scanner.nextLine();
        return val;
    }

    static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}
