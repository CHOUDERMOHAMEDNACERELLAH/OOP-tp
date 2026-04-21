
package tp2;

import java.util.Scanner;

public class SignChecker {
    int number;

    SignChecker(int number) {
        this.number = number;
    }

    String checkSign() {
        if (number > 0) {
            return "Positive";
        } else if (number < 0) {
            return "Negative";
        } else {
            return "Zero";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = scanner.nextInt();
        scanner.close();

        SignChecker sc = new SignChecker(n);
        System.out.println(n + " is " + sc.checkSign() + ".");
    }
}
