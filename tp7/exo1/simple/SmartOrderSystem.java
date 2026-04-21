package tp7.exo1.simple;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SmartOrderSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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

            System.out.println(result == null ? "STANDARD CLIENT" : result.toUpperCase());

            if (discount == 0) {
                throw new ArithmeticException("Division by zero is not allowed.");
            }
            double total = (price * quantity) / discount;

            int parsed = Integer.parseInt("123abc");
            Object obj = Integer.valueOf(10);
            String str = (String) obj;

            System.out.println("Parsed number: " + parsed);
            System.out.println("Casted value: " + str);
            System.out.println("Final total: " + total);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input type. Please retry with correct values.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index. Allowed range is 0..2.");
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic problem: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Number parsing failed for the string '123abc'.");
        } catch (ClassCastException e) {
            System.out.println("Invalid cast: Integer cannot be converted to String.");
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } finally {
            sc.close();
            System.out.println("Program ended normally.");
        }
    }
}
