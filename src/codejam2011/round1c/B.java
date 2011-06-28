package codejam2011.round1c;

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
    boolean writeToFile = true;

//    2
//    2 20 8 2 3 5
//    1 4 2 2 10 4
    private void solve() {
        int L = sc.nextInt();
        long t = sc.nextLong();
        int n = sc.nextInt();
        int C = sc.nextInt();
        int[] dist = new int[C];
        for (int i = 0; i < C; i++) {
            dist[i] = sc.nextInt();
        }
        long[] D = new long[n];
        int k = 0;
        boolean done = false;
        while (!done) {
            for (int i = 0; i < C; i++) {
                if (k*C+i == n) { 
                    done = true;
                    break;
                }
                D[k*C+i] = dist[i];
            }
            k++;
        }
        long sum = 0;
        done = false;
        long saved[] = new long[n];
        for (int i = 0; i < D.length; i++) {
            sum += D[i]*2;
            if (sum > t) {
                if (!done) {
                    saved[i] = (sum-t)/2;
                    done = true;
                } else {
                    saved[i] = D[i];
                }
            } else {
                saved[i] = 0;
            }
        }
        Arrays.sort(saved);
//        print(saved);
        long s = 0;
        for (int i = 0; i < L; i++) {
            s += saved[saved.length-i-1];
        }
        long totalS = 0;
        for (int i = 0; i < n; i++) {
            totalS += D[i];
        }
        totalS *= 2;
        out.println(totalS - s);
    }

    private void print(long[] a) {
      for (int i = 0; i < a.length; i++) {
      out.print(a[i] + " " );
          }
          out.println();
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
