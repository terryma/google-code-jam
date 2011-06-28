package codejam2011.round2;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D {

    Scanner             sc       = new Scanner(getClass().getResourceAsStream(IN));
    static final String FILENAME = "D";
    static final String IN       = FILENAME + ".in";
    static final String OUT      = FILENAME + ".out";
    PrintStream         out      = System.out;
    boolean writeToFile = false;

    private void solve() {
        int x = sc.nextInt();
        out.println(x);
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
        new D().run();
    }
}
