
package tp2;

import java.util.Scanner;

public class EvenOdd {
    int number;

    EvenOdd(int number) {
        this.number = number;
    }

    boolean isEven() {
        return number % 2 == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = scanner.nextInt();
        scanner.close();

        EvenOdd eo = new EvenOdd(n);
        if (eo.isEven()) {
            System.out.println(n + " is Even.");
        } else {
            System.out.println(n + " is Odd.");
        }
    }
}
