package codejam2011.round1a;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A {

    Scanner             sc       = new Scanner(getClass().getResourceAsStream(IN));
    static final String FILENAME = "A-large";
    static final String IN       = FILENAME + ".in";
    static final String OUT      = FILENAME + ".out";
    PrintStream         out      = System.out;
    boolean writeToFile = true;

    private void solve() {
        long n = sc.nextLong();
        long x = sc.nextLong();
        long y = sc.nextLong();
        if(s(n, x, y)) {
            out.println("Possible");
        } else {
            out.println("Broken");
        }
    }

    private boolean s(long n, long x, long y) {
        if (y == 100) {
            return x == 100;
        }
        if (y == 0) {
            return x == 0;
        }
        BigInteger xx = new BigInteger(String.valueOf(x));
        return n >= (100 / xx.gcd(BigInteger.valueOf(100)).longValue());
    }

    private void run() throws Exception {
        if (writeToFile) {
            out = new PrintStream(new FileOutputStream(OUT));
        }
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");
            solve();
        }
        sc.close();
        out.close();
    }

    public static void main(String args[]) throws Exception {
        new A().run();
    }

}
