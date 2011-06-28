package codejam2010.round1a;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//3
//5 5 8 8
//11 11 2 2
//1 6 1 6
public class C {

    private static class Pair {
        int a;
        int b;

        public Pair(int i, int j) {
            super();
            this.a = i;
            this.b = j;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Pair) {
                Pair p = (Pair) obj;
                if (p.a == this.a && p.b == this.b) {
                    return true;
                }
                if (p.a == this.b && p.b == this.a) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public int hashCode() {
            return a + b;
        }
    }

    private static Map<Pair, Boolean> m = new HashMap<Pair, Boolean>();

    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("C-large.in")));
        PrintWriter out = new PrintWriter(new FileWriter("C.out"));
        // PrintStream out = System.out;
        int n = Integer.parseInt(in.readLine());
        System.out.println(n);
        m.put(new Pair(1, 1), false);
        for (int i = 0; i < n; i++) {
            String s = in.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            int b1 = Integer.parseInt(st.nextToken());
            int b2 = Integer.parseInt(st.nextToken());
            int c = 0;
            for (int a = a1; a <= a2; a++) {
                for (int b = b1; b <= b2; b++) {
                    if (check(a, b)) {
                        c++;
                    }
                }
            }
            System.out.printf("Case #%d: %d\n", (i + 1), c);
            out.printf("Case #%d: %d\n", (i + 1), c);
        }
        out.close();
    }

    private static boolean check(int a, int b) {
        // System.out.println("check " + a + ", " + b);
        Boolean aaa = m.get(new Pair(a, b));
        if (aaa != null) {
            return aaa;
        }
        if (a == 1 || b == 1) {
            // System.out.println("putting " + a + ", " + b + " = true");
            m.put(new Pair(a, b), true);
            return true;
        }
        if (a > b) {
            int c = a;
            a = b;
            b = c;
        }
        int o = b;
        while (true) {
            // 7 and 34 ,check 7 27, 7 20, 7 13, 7 6
            b = b - a;
            if (b <= 0) {
                break;
            }

            if (!check(a, b)) {
                // System.out.println("checking " + a + ", " + b + " returned false");
                // System.out.println("putting " + a + ", " + o + " = true");
                m.put(new Pair(a, o), true);
                return true;
            } else {
                // System.out.println("putting " + a + ", " + b + " = true");
                m.put(new Pair(a, b), true);
            }
        }
        // System.out.println("putting " + a + ", " + o + " = false");
        m.put(new Pair(a, o), false);
        return false;
    }
}
