package codejam2010.round2;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class C {

    Scanner             sc       = new Scanner(getClass().getResourceAsStream(IN));
    static final String FILENAME = "C";
    static final String IN       = FILENAME + ".in";
    static final String OUT      = FILENAME + ".out";
    PrintStream         out      = System.out;

    // 1
    // 3
    // 5 1 5 1
    // 2 2 4 2
    // 2 3 2 4
    private void solve() {
        int ans = 0;
        boolean[][] m = new boolean[1000000][1000000];
        int R = sc.nextInt();
        int maxR = 0, maxC = 0;
        for (int i = 0; i < R; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
            for (int r = y1 - 1; r <= y2 - 1; r++) {
                for (int c = x1 - 1; c <= x2 - 1; c++) {
                    m[r][c] = true;
                    // maxR = Math.max(maxR, r);
                    // maxC = Math.max(maxC, c);
                }
            }
        }
        ans = simiulate(m);
        out.println(ans - 1);
    }

    private int simiulate(boolean[][] m) {

        int ret = 0;
        while (true) {
            boolean[][] n = new boolean[m.length][m.length];
            for (int r = 0; r < m.length; r++) {
                for (int c = 0; c < m.length; c++) {
                    n[r][c] = m[r][c];
                }
            }
            // print(n);

            boolean done = true;
            for (int r = 0; r < m.length; r++) {
                for (int c = 0; c < m.length; c++) {
                    if (m[r][c]) {
                        done = false;
                    }
                    if (r > 0 && m[r - 1][c] && c > 0 && m[r][c - 1] && !m[r][c]) {
                        n[r][c] = true;
                        continue;
                    }
                    if (m[r][c] && (r == 0 || !m[r - 1][c]) && (c == 0 || !m[r][c - 1])) {
                        n[r][c] = false;
                        continue;
                    }
                }
            }
            ret++;
            if (done) {
                break;
            }
            m = n;
        }
        return ret;
    }

    private void print(boolean[][] n) {
        System.out.println("Printing:");
        for (boolean[] element : n) {
            for (int c = 0; c < n.length; c++) {
                System.out.print(element[c] ? "1 " : "0 ");
            }
            System.out.println();
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
        new C().run();
    }

}
