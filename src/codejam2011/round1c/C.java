package codejam2011.round1c;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class C {

    Scanner             sc       = new Scanner(getClass().getResourceAsStream(IN));
    static final String FILENAME = "C";
    static final String IN       = FILENAME + ".in";
    static final String OUT      = FILENAME + ".out";
    PrintStream         out      = System.out;
    boolean writeToFile = false;

//    2
//    3 2 100
//    3 5 7
//    4 8 16
//    1 20 5 2
    private void solve() {
        int n = sc.nextInt();
        long l = sc.nextLong();
        long h = sc.nextLong();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }
        long result = -1;
        while (true) {
            long mid = (l+h)/2;
            boolean r = test(mid, n, nums);
            if (r) {
                h = mid;
                result = h;
            } else {
                l = mid;
            }
            if (l >= h) {
                break;
            }
        }
        if (result == -1) {
            out.println("NO");
        } else {
            out.println(result);
        }
    }

    private boolean test(long i, int n, long[] nums) {
        for (int j = 0; j < n; j++) {
            long k = nums[j];
            long larger = Math.max(i, k);
            long smaller = Math.min(i, k);
            if (larger / smaller * smaller != larger) {
                return false;
            }
        }
        return true;
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
