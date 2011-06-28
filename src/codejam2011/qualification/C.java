package codejam2011.qualification;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class C {

    Scanner             sc       = new Scanner(getClass().getResourceAsStream(IN));
    static final String FILENAME = "C-large";
    static final String IN       = FILENAME + ".in";
    static final String OUT      = FILENAME + ".out";
    PrintStream         out      = System.out;
    boolean writeToFile = true;

    private void solve() {
        long min = Long.MAX_VALUE;
        long sum = 0;
        long xor = 0;
        for (int i = 0, n = sc.nextInt(); i < n; i++) {
            long x = sc.nextLong();
            sum += x;
            if (x < min) min = x;
            xor ^= x;
        }
        if (xor != 0) {
            out.println("NO");
        } else {
            out.println(sum - min);
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
        new C().run();
    }

}
