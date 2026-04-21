
package tp2;

import java.util.Scanner;

public class ArrayMinMax {
    int[] array;

    ArrayMinMax(int[] array) {
        this.array = array;
    }

    int findMax() {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    int findMin() {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
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

        ArrayMinMax amm = new ArrayMinMax(arr);
        System.out.println("Maximum = " + amm.findMax());
        System.out.println("Minimum = " + amm.findMin());
    }
}
