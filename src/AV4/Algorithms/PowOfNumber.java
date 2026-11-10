package AV4.Algorithms;

public class PowOfNumber {
    public static void main(String[] args) {

    }

    public static int powDivideAndConquere(int x, int n) {
        int r = 0;
        if (n == 0) {
            return 1;
        } else if (n % 2 == 0) {
            r = powDivideAndConquere(x, n / 2);
            return r * r;
        } else {
            r = powDivideAndConquere(x, n - 1);
            return r * r * x;
        }
    }
}
