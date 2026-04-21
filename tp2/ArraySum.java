
package tp2;

import java.util.Scanner;

public class ArraySum {
    int[] array;

    ArraySum(int[] array) {
        this.array = array;
    }

    int compute() {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array size N: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        ArraySum as = new ArraySum(arr);
        System.out.println("Sum of array elements = " + as.compute());
    }
}
