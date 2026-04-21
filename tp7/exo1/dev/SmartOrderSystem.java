package tp7.exo1.dev;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SmartOrderSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Smart Order Processing System ===");

        try {
            System.out.print("Enter client name: ");
            String name = sc.nextLine();

            System.out.print("Enter price: ");
            double price = sc.nextDouble();

            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();

            System.out.print("Enter discount code (number): ");
            int discount = sc.nextInt();

            System.out.print("Enter index to access: ");
            int index = sc.nextInt();

            int[] data = new int[3];
            data[index] = quantity;

            String result = null;
            if ("admin".equalsIgnoreCase(name)) {
                result = "Priority Client";
            }

            if (result != null) {
                System.out.println(result.toUpperCase());
            } else {
                System.out.println("STANDARD CLIENT");
            }

            if (discount == 0) {
                throw new ArithmeticException("Discount code cannot be zero.");
            }
            double total = (price * quantity) / discount;

            String numberStr = "123abc";
            int parsed = Integer.parseInt(numberStr);

            Object obj = Integer.valueOf(10);
            String str = (String) obj;

            System.out.println("Parsed number: " + parsed);
            System.out.println("Cast value: " + str);
            System.out.println("Final total: " + total);

        } catch (InputMismatchException e) {
            System.out.println("[Input Error] Please enter values with correct types (text, double, int).");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("[Array Error] Index must be between 0 and 2.");
        } catch (ArithmeticException e) {
            System.out.println("[Math Error] " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("[Parsing Error] Cannot convert '123abc' to an integer.");
        } catch (ClassCastException e) {
            System.out.println("[Casting Error] Cannot cast Integer to String.");
        } catch (Exception e) {
            System.out.println("[Unexpected Error] " + e.getMessage());
        } finally {
            sc.close();
            System.out.println("Program ended normally.");
        }
    }
}
