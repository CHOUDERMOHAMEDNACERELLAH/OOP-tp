public class Calculator {
    int a;
    int b;

    Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    int add() {
        return a + b;
    }

    int sub() {
        return a - b;
    }

    int mul() {
        return a * b;
    }

    double div() {
        if (b != 0)
            return (double) a / b;
        else {
            System.out.println("Error: Division by zero!");
            return 0;
        }
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator(10, 3);
        System.out.println("a = " + calc.a + ", b = " + calc.b);
        System.out.println("add() = " + calc.add());
        System.out.println("sub() = " + calc.sub());
        System.out.println("mul() = " + calc.mul());
        System.out.println("div() = " + calc.div());
    }
}
