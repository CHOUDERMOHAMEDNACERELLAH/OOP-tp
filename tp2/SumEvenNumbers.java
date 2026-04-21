
package tp2;

import java.util.Scanner;

public class SumEvenNumbers {
    int n;

    SumEvenNumbers(int n) {
        this.n = n;
    }

    int compute() {
        int sum = 0;
        for (int i = 2; i <= n; i += 2) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = scanner.nextInt();
        scanner.close();

        SumEvenNumbers sen = new SumEvenNumbers(n);
        System.out.println("Sum of even numbers from 1 to " + n + " = " + sen.compute());
    }
}
