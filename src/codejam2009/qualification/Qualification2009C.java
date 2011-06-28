package codejam2009.qualification;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;

public class Qualification2009C {

    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("C.in")));
        // PrintWriter out = new PrintWriter(new FileWriter("C.out"));
        PrintStream out = System.out;
        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            String s = in.readLine();
            int count = process(s);
            count %= 10000;
            out.printf("Case #%d: %04d\n", (i + 1), count);
        }
        // out.close();
    }

    private final static String S = "welcome to code jam";
    private static int[][]      m = new int[19][500];

    private static int process(String s) {
        for (int[] element : m) {
            Arrays.fill(element, 0);
        }
        return process(s, 0, 0);
    }

    private static int process(String s, int i, int j) {
        if (i == S.length()) {
            return 1;
        }
        if (m[i][j] != 0) {
            return m[i][j];
        }
        // System.out.println("process with i=" + i + ", j=" + j + ", m[i][j]=" + m[i][j]);
        int count = 0;
        for (int k = j; k < s.length(); k++) {
            if (s.charAt(k) == S.charAt(i)) {
                count += process(s, i + 1, k + 1);
                count %= 10000;
            }
        }
        if (count != 0) {
            // System.out.println("Setting m." + i + ", " + j + ", to " + count);
            m[i][j] = count;
        }
        return count % 10000;
    }
}

// w, found it, find second letter, from current position
// welcome to code jam
// wwwwelcom to code jam
