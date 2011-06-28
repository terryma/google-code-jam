package codejam2011.round1b;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.text.DecimalFormat;
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

    //    2
    //    3
    //    .10
    //    0.1
    //    10.
    //    4
    //    .11.
    //    0.00
    //    01.1
    //    .10.
    private void solve() {
        int n = sc.nextInt();
        Boolean[][] teams = new Boolean[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                if (c == '0') teams[i][j] = false;
                else if (c == '1') teams[i][j] = true;
            }
        }
        // calculate wp
        double[] wp = new double[n];
        for (int i = 0; i < n; i++) {
            int numW = 0;
            int numL = 0;
            for (int j = 0; j < n; j++) {
                Boolean b = teams[i][j];
                if (b == null) continue;
                if (b) numW++;
                else numL++;
            }
            wp[i] = numW*1.0/(numW+numL);
        }

        //      .10
        //      0.1
        //      10.
        double[][] wps = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Boolean b = teams[i][j];
                if (b == null) continue;
                else {
                    int numW = 0;
                    int numL = 0;
                    for (int k = 0; k < n; k++) {
                        Boolean bb = teams[i][k];
                        if (bb == null) continue;
                        if (j == k) continue;
                        if (bb) numW++;
                        else numL++;
                    }
                    wps[i][j] = numW*1.0/(numW+numL);
                }
            }
        }
        double[] owp = new double[n];
        for (int i = 0; i < n; i++) {
            int numO = 0;
            double sum = 0;
            for (int j = 0; j < n; j++) {
                Boolean b = teams[i][j];
                if (b == null) continue;
                numO++;
                sum += wps[j][i];
            }
            owp[i] = sum/numO;
        }

        double[] oowp = new double[n];
        for (int i = 0; i < n; i++) {
            int numO = 0;
            double sum = 0;
            for (int j = 0; j < n; j++) {
                Boolean b = teams[i][j];
                if (b == null) continue;
                numO++;
                sum += owp[j];
            }
            oowp[i] = sum/numO;
        }
        double[] r = new double[n];
        out.println();
        DecimalFormat f = new DecimalFormat("#.############");
        for (int i = 0; i < n; i++) {
            r[i] = 0.25 * wp[i] + 0.5 * owp[i] + 0.25 * oowp[i];
            out.println(f.format(r[i]));
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
