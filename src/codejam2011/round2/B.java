package codejam2011.round2;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B {

    Scanner             sc       = new Scanner(getClass().getResourceAsStream(IN));
    static final String FILENAME = "B";
    static final String IN       = FILENAME + ".in";
    static final String OUT      = FILENAME + ".out";
    PrintStream         out      = System.out;
    boolean writeToFile = true;
//    boolean writeToFile = false;

    //    2
    //    6 7 2
    //    1111111
    //    1122271
    //    1211521
    //    1329131
    //    1242121
    //    1122211
    //    3 3 7
    //    123
    //    234
    //    345
    private void solve() {
        int I = sc.nextInt();
        int J = sc.nextInt();
        int D = sc.nextInt();
        int[][] M = new int[I][J];
        for (int i = 0; i < I; i++) {
            char[] c = sc.next().toCharArray();
            for (int j = 0; j < J; j++) {
                M[i][j] = c[j] - '0' + D;
            }
        }
        int guess = Math.min(I, J);
//        out.println(guess);
        boolean d = false;
        done: while (true) {
            if (guess < 3) {
                break;
            }
            if (d) {
                break;
            }
            for (int ii = 0; ii + guess -1 < I; ii++) {
                for (int jj = 0; jj + guess -1 < J; jj++) {
                    if (mass(ii, jj, M, guess) == 0) {
                        d = true;
                        continue done;
                    }
                }
            }
            guess--;
        }
        if (guess < 3) {
            out.println("IMPOSSIBLE");
        } else {
            out.println(guess);
        }
    }

    private double mass(int ii, int jj, int[][] m, int l) {
//        out.println(ii + " " + jj + " " + l);
        double massx = 0;
        double massy = 0;
        double x = ii+0.5 + (l-1)/2.0;
        double y = jj+0.5 + (l-1)/2.0;
        for (int i = ii; i < ii+l; i++) {
            for (int j = jj; j < jj+l; j++) {
                if ((i == ii && j == jj) || (i == ii && j == jj+l-1) || (i==ii+l-1 && j==jj) || (i==ii+l-1 && j==jj+l-1)) {
                    continue;
                }
                massx += (i+0.5-x) * m[i][j];
                massy += (j+0.5-y) * m[i][j];
            }
        }
//        out.println(ii + " " + jj + " " + l + " " + massx + " " + massy);
        if (massx == 0 && massy == 0) {
            return 0;
        }
        return -1;
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
        new B().run();
    }
}
