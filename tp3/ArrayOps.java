public class ArrayOps {
    int[] array;

    ArrayOps(int[] array) {
        this.array = array;
    }

    int sum() {
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }
        return total;
    }

    int max() {
        int maximum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maximum) {
                maximum = array[i];
            }
        }
        return maximum;
    }

    public static void main(String[] args) {
        int[] data = { 3, 7, 1, 9, 4, 6 };
        ArrayOps ops = new ArrayOps(data);

        System.out.print("Array: ");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
        System.out.println("sum() = " + ops.sum());
        System.out.println("max() = " + ops.max());
    }
}
