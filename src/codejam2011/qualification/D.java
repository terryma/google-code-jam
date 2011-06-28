package codejam2011.qualification;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class D {

    Scanner             sc       = new Scanner(getClass().getResourceAsStream(IN));
    static final String FILENAME = "D";
    static final String IN       = FILENAME + ".in";
    static final String OUT      = FILENAME + ".out";
    PrintStream         out      = System.out;
    boolean writeToFile = false;
//    boolean writeToFile = true;

    private void solve() {
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
//            out.println(a[i]);
        }
        int c = 0;
        while (true) {
            int i;
            for (i = 0; i < n; i++) {
                if (a[i] != i+1) {
                    int temp = a[a[i]-1];
                    a[i] = a[a[i]-1];
                    a[a[i]-1] = temp;
                    c += 2;
                    break;
                }
            }
            if (i == n) break;
        }
        out.println(c);
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
