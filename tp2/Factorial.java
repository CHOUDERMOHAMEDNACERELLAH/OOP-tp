
package tp2;

import java.util.Scanner;

public class Factorial {
    int n;

    Factorial(int n) {
        this.n = n;
    }

    long compute() {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer n: ");
        int n = scanner.nextInt();
        scanner.close();

        Factorial f = new Factorial(n);
        System.out.println(n + "! = " + f.compute());
    }
}
