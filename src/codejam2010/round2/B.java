package codejam2010.round2;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class B {

    Scanner             sc       = new Scanner(getClass().getResourceAsStream(IN));
    static final String FILENAME = "B";
    static final String IN       = FILENAME + ".in";
    static final String OUT      = FILENAME + ".out";
    PrintStream         out      = System.out;

    // 2
    // 2
    // 1 1 0 1
    // 1 1
    // 1
    // 3
    // 1 2 3 2 1 0 1 3
    // 100 150 50 90
    // 500 400
    // 800
    private void solve() {
        int ans = 0;
        int p = sc.nextInt();

        int[] m = new int[1 << p];
        // System.out.println("p = " + p);
        // System.out.println("m.length = " + m.length);
        for (int i = 0; i < m.length; i++) {
            int in = sc.nextInt();
            // System.out.println("in = " + in);
            m[i] = p - in;
        }
        // System.out.println();
        for (int element : m) {
            // System.out.print(element + " ");
        }
        sc.nextLine();
        for (int i = 0; i < p; i++) {
            sc.nextLine();
        }
        ans = process(m);
        out.println(ans);
    }

    private int process(int[] m) {
        boolean b = false;
        for (int i : m) {
            if (i > 0) {
                b = true;
                break;
            }
        }
        // System.out.println(b);
        if (b) {
            // sub 1 from all m, call on sub
            for (int i = 0; i < m.length; i++) {
                m[i]--;
            }
            return 1 + process(Arrays.copyOfRange(m, 0, m.length / 2))
                    + process(Arrays.copyOfRange(m, m.length / 2, m.length));
        } else {
            return 0;
        }
    }

    private void run() throws Exception {
        out = new PrintStream(new FileOutputStream(OUT));
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
