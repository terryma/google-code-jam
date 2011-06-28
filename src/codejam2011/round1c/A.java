package codejam2011.round1c;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A {

    Scanner             sc       = new Scanner(getClass().getResourceAsStream(IN));
    static final String FILENAME = "A";
    static final String IN       = FILENAME + ".in";
    static final String OUT      = FILENAME + ".out";
    PrintStream         out      = System.out;
    boolean writeToFile = true;

//    3
//    2 3
//    ###
//    ###
//    1 1
//    .
//    4 5
//    .##..
//    .####
//    .####
//    .##..
    private void solve() {
        int r = sc.nextInt();
        int c = sc.nextInt();
        char[][] m = new char[r][c];
        for (int i = 0; i < r; i++) {
            String s = sc.next();
            for (int j = 0; j < c; j++) {
                m[i][j] = s.charAt(j);
            }
        }
        boolean done = false;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                char ch = m[i][j];
                if (ch == '#') {
                    if (i+1 == r || j+1 == c) {
                        done = true;
                        break;
                    }
                    if (m[i+1][j] != '#' || m[i][j+1] != '#' || m[i+1][j+1] != '#') {
                        done = true;
                        break;
                    }
                    m[i][j] = '/';
                    m[i][j+1] = '\\';
                    m[i+1][j] = '\\';
                    m[i+1][j+1] = '/';
                }
            }
            if (done) {
                break;
            }
        }
        out.println();
        if (done) {
            out.println("Impossible");
        } else {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    out.print(m[i][j]);
                }
                out.println();
            }
        }
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
