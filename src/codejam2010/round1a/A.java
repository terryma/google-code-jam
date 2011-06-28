package codejam2010.round1a;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class A {

    private static final String FILENAME = "A-large";
    private static final String IN       = FILENAME + ".in";

    public void test() throws Exception {
        Scanner sc = new Scanner(getClass().getResourceAsStream(IN));
    }

    public static void main(String args[]) throws Exception {
        new A().test();
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("A-large.in")));
        PrintWriter out = new PrintWriter(new FileWriter("A.out"));
        // PrintStream out = System.out;
        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int l = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            byte[][] m = new byte[l][l];
            for (int ii = 0; ii < l; ii++) {
                String line = in.readLine();
                for (int r = 0; r < line.length(); r++) {
                    char c = line.charAt(r);
                    if (c == 'R') {
                        m[ii][r] = 1;
                    }
                    if (c == 'B') {
                        m[ii][r] = 2;
                    }
                    if (c == '.') {
                        m[ii][r] = 0;
                    }
                }
            }
            rotate(m);
            System.out.println("after rotate");
            print(m);
            drop(m);
            System.out.println("after drop");
            print(m);
            String result = check(m, k);
            out.printf("Case #%d: %s\n", i + 1, result);
        }
        out.close();
    }

    private static void print(byte[][] m) {
        for (byte[] element : m) {
            for (int c = 0; c < m.length; c++) {
                System.out.print(element[c]);
            }
            System.out.println();
        }

    }

    private static String check(byte[][] m, int k) {
        String s = "Neither";
        for (int r = m.length - 1; r >= 0; r--) {
            for (int c = 0; c < m.length; c++) {
                int i = m[r][c];
                if (i == 0) {
                    continue;
                }
                boolean found = true;
                for (int t = 1; t < k; t++) {
                    int z = c + t;
                    if (z >= m.length) {
                        found = false;
                        break;
                    }
                    if (m[r][z] != i) {
                        found = false;
                        break;
                    }
                }
                if (!found) {
                    found = true;
                    for (int t = 1; t < k; t++) {
                        int z = r - t;
                        if (z < 0) {
                            found = false;
                            break;
                        }
                        if (m[z][c] != i) {
                            found = false;
                            break;
                        }
                    }
                }
                if (!found) {
                    found = true;
                    for (int t = 1; t < k; t++) {
                        int z = c + t;
                        int x = r - t;
                        if (z >= m.length || x < 0) {
                            found = false;
                            break;
                        }
                        if (m[x][z] != i) {
                            found = false;
                            break;
                        }
                    }
                }
                if (!found) {
                    found = true;
                    for (int t = 1; t < k; t++) {
                        int z = c - t;
                        int x = r - t;
                        if (z < 0 || x < 0) {
                            found = false;
                            break;
                        }
                        if (m[x][z] != i) {
                            found = false;
                            break;
                        }
                    }
                }
                if (found) {
                    if (s.equals("Neither")) {
                        if (i == 1) {
                            s = "Red";
                        } else {
                            s = "Blue";
                        }
                    } else if (s.equals("Red")) {
                        if (i == 2) {
                            s = "Both";
                            return s;
                        }
                    } else if (s.equals("Blue")) {
                        if (i == 1) {
                            s = "Both";
                            return s;
                        }
                    }
                }
            }
        }
        return s;
    }

    private static void drop(byte[][] m) {
        for (int c = 0; c < m.length; c++) {
            int i = m.length - 1;
            for (int r = m.length - 1; r >= 0; r--) {
                if (m[r][c] == 0) {
                    continue;
                }
                if (i == r) {
                    i--;
                    continue;
                }
                m[i][c] = m[r][c];
                m[r][c] = 0;
                i--;
            }
        }
    }

    private static void rotate(byte[][] m) {
        byte[][] n = new byte[m.length][m.length];
        for (int r = 0; r < m.length; r++) {
            for (int c = 0; c < m.length; c++) {
                n[r][c] = m[r][c];
            }
        }
        for (int r = 0; r < m.length; r++) {
            for (int c = 0; c < m.length; c++) {
                m[r][c] = n[n.length - 1 - c][r];
            }
        }
    }
}

// 4
// 7 3
// .......
// .......
// .......
// ...R...
// ...BB..
// ..BRB..
// .RRBR..
// 6 4
// ......
// ......
// .R...R
// .R..BB
// .R.RBR
// RB.BBB
// 4 4
// R...
// BR..
// BR..
// BR..
// 3 3
// B..
// RB.
// RB.