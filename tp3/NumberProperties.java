public class NumberProperties {
    int n;

    NumberProperties(int n) {
        this.n = n;
    }

    boolean isOdd() {
        return n % 2 != 0;
    }

    boolean isMultipleOfFive() {
        return n % 5 == 0;
    }

    public static void main(String[] args) {
        NumberProperties np = new NumberProperties(15);
        System.out.println("n = " + np.n);
        System.out.println("isOdd() = " + np.isOdd());
        System.out.println("isMultipleOfFive() = " + np.isMultipleOfFive());

        System.out.println();

        NumberProperties np2 = new NumberProperties(8);
        System.out.println("n = " + np2.n);
        System.out.println("isOdd() = " + np2.isOdd());
        System.out.println("isMultipleOfFive() = " + np2.isMultipleOfFive());
    }
}
