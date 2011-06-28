package codejam2011.round2;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class A {

    Scanner             sc       = new Scanner(getClass().getResourceAsStream(IN));
    static final String FILENAME = "A";
    static final String IN       = FILENAME + ".in";
    static final String OUT      = FILENAME + ".out";
    PrintStream         out      = System.out;
    boolean writeToFile = true;

//    3
//    10 1 4 1 2
//    4 6 1
//    6 9 2
//    12 1 2 4 1
//    6 12 1
//    20 1 3 20 5
//    0 4 5
//    4 8 4
//    8 12 3
//    12 16 2
//    16 20 1
    
    private static class Walkway implements Comparable<Walkway>{
        public int speed;
        public double length;
        @Override
        public int compareTo(Walkway o) {
            return this.speed - o.speed;
        }
        
    }
    private void solve() {
        int L = sc.nextInt();
        int S = sc.nextInt();
        int R = sc.nextInt();
        int t = sc.nextInt();
        int n = sc.nextInt();
//        out.println(L + " " + S + " " + R + " " + t + " " + n);
        Walkway[] ws = new Walkway[n+1];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            ws[i] = new Walkway();
            int begin = sc.nextInt();
            int end = sc.nextInt();
            ws[i].length = end - begin;
            sum += ws[i].length;
            ws[i].speed = sc.nextInt();
        }
        ws[n] = new Walkway();
        ws[n].length = L - sum;
        ws[n].speed = 0;
        
        Arrays.sort(ws);
        
        double totalT = 0;
        double remain = t;
        boolean run = true;
        for (Walkway w : ws) {
//            out.println("length=" + w.length + ", speed=" + w.speed);
            double time;
            if (run) {
                time = w.length / (w.speed + R);
                if (time < remain) {
                    remain -= time;
                    totalT += time;
                } else {
                    run = false;
                    totalT += remain;
                    totalT += (w.length - remain*(w.speed + R)) / (S + w.speed); 
                }
            } else {
                time = w.length / (S + w.speed);
                totalT += time;
            }
        }
        DecimalFormat f = new DecimalFormat("#.######");
        out.println(f.format(totalT));
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
        new A().run();
    }
}
