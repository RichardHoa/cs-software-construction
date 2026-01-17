public class Main {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(1, 2); // 1/2
        Fraction f2 = new Fraction(1, 4); // 1/4

        Fraction sum = f1.plus(f2);      // Result: 6/8
        Fraction diff = f1.minus(f2);    // Result: 2/8

        System.out.print("Sum: ");
        sum.print();

        System.out.print("Difference: ");
        diff.print();
    }

    
}
