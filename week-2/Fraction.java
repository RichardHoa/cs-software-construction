public class Fraction {
    private int num;
    private int den;

    public Fraction() {
        num = 0;
        den = 1;
    }

    public Fraction(int n, int d) {
        num = n;
        den = d;
    }

    public Fraction(Fraction other) {
        num = other.num;
        den = other.den;
    }

    public void print() {
        System.out.println(num + "/" + den);
    }

    public Fraction plus(Fraction other) {
        int newNum = (num * other.den) + (other.num * den);
        int newDen = den * other.den;
        return new Fraction(newNum, newDen);
    }

    public Fraction minus(Fraction other) {
        int newNum = (num * other.den) - (other.num * den);
        int newDen = den * other.den;
        return new Fraction(newNum, newDen);
    }
}
