package codejam2009.qualification;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Round12009A {

    // 2 -> 45, 435
    // 3 -> 13,3245,
    // static Map<Integer, Map<Integer, Boolean>> map = new HashMap<Integer, Map<Integer, Boolean>>();
    static List<Boolean>[] map = new List[11];
    static {
        for (int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<Boolean>();
            map[i].add(false);
            map[i].add(false);
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("Round12009A.in")));
        // PrintWriter out = new PrintWriter(new FileWriter("Round12009A.out"));
        PrintStream out = System.out;
        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            List<Integer> bases = new ArrayList<Integer>();
            StringTokenizer st = new StringTokenizer(in.readLine());
            while (st.hasMoreTokens()) {
                bases.add(Integer.parseInt(st.nextToken()));
            }
            int m = 2; // start from 2
            while (true) {
                boolean done = true;
                for (int j : bases) {
                    if (map[j].size() > m && map[j].get(m) != null) {
                        if (!map[j].get(m)) {
                            done = false;
                            break;
                        }
                    }

                    // convert m to base j
                    // if m is not happy, break
                    // otherwise, add it to set
                    boolean happy = isHappy(m, j);
                    map[j].add(happy);
                    if (!happy) {
                        done = false;
                        break;
                    }
                }
                if (done) {
                    break;
                }
                m++;
            }
            out.printf("Case #%d: %d\n", (i + 1), m);
        }
        out.close();
    }

    private static boolean isHappy(int n, int base) {
        // System.out.println("Calling isHappy with n=" + n + ", base=" + base);
        String num = Integer.toString(n, base);
        Set<Integer> s = new HashSet<Integer>();
        while (true) {
            int sum = 0;
            for (int i = 0; i < num.length(); i++) {
                int t = num.charAt(i) - '0';
                sum += t * t;
            }
            if (s.contains(sum)) {
                return false;
            }
            s.add(sum);
            if (sum == 1) {
                return true;
            }
            num = Integer.toString(sum, base);
        }
    }

}
