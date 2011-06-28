package codejam2010.round1b;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class A {

    Scanner             sc       = new Scanner(getClass().getResourceAsStream(IN));
    static final String FILENAME = "A-large-practice";
    static final String IN       = FILENAME + ".in";
    static final String OUT      = FILENAME + ".out";
    PrintStream         out      = System.out;

    private void solve() {
        int ans = 0;

        int n = sc.nextInt();
        int m = sc.nextInt();
        Set<String> a = new HashSet<String>();
        Set<String> b = new HashSet<String>();
        for (int i = 0; i < n; i++) {
            add(a, sc.next().substring(1));
        }
        // System.out.println(a);
        for (int i = 0; i < m; i++) {
            add(b, sc.next().substring(1));
        }
        // System.out.println(b);
        b.removeAll(a);
        // /home/abc/def

        out.println(b.size());
    }

    private void add(Set<String> set, String str) {
        set.add(str);
        int i = str.lastIndexOf('/');
        if (i == -1) {
            return;
        }
        add(set, str.substring(0, i));
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
        new A().run();
    }

}
