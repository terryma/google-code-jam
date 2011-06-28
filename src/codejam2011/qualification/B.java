package codejam2011.qualification;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B {

    Scanner             sc       = new Scanner(getClass().getResourceAsStream(IN));
    static final String FILENAME = "B-large";
    static final String IN       = FILENAME + ".in";
    static final String OUT      = FILENAME + ".out";
    PrintStream         out      = System.out;
    boolean writeToFile = true;

    private void solve() {
        List<String> combines = new ArrayList<String>(), opposes = new ArrayList<String>();
        for (int i = 0, n = sc.nextInt(); i < n; i++) {
            combines.add(sc.next());
        }
        for (int i = 0, n = sc.nextInt(); i < n; i++) {
            opposes.add(sc.next());
        }
        sc.nextInt();
        String s = sc.next();
        String output = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            output += c;
            output = invoke(output, combines, opposes);
//            out.println("output = " + output);
        }
        
        out.print("[");
        int i = 0;
        for (char c : output.toCharArray()) {
            out.print(c);
            if (i++ < output.length()-1) out.print(", ");
        }
        out.println("]");
    }

    private String invoke(String output, List<String> combines, List<String> opposes) {
        if (output.length() < 2) return output;
//        out.println("output=" + output);
        String lastTwo = output.substring(output.length() - 2);
        for (String combine : combines) {
//            out.println("lastTwo=" + lastTwo + ", combine=" + combine.substring(0, 2));
            if (equals(lastTwo, combine.substring(0, 2))) {
                output = output.substring(0, output.length() - 2) + combine.charAt(2);
                return invoke(output, combines, opposes);
            }
        }
        char c = output.charAt(output.length()-1);
        for (String oppose: opposes) {
            if (oppose.charAt(0) == c) {
                if (output.indexOf(oppose.charAt(1)) >= 0) {
                    return "";
                }
            } else if (oppose.charAt(1) == c) {
                if (output.indexOf(oppose.charAt(0)) >= 0) {
                    return "";
                }
            }
        }
        return output;
    }

    private boolean equals(String l, String r) {
        if (l.equals(r)) return true;
        if (l.charAt(0) == r.charAt(1) && l.charAt(1) == r.charAt(0)) return true;
        return false;
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
