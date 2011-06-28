//package codejam2011.round1b;
//
//import java.io.FileOutputStream;
//import java.io.PrintStream;
//import java.math.BigInteger;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class B {
//
//    Scanner             sc       = new Scanner(getClass().getResourceAsStream(IN));
//    static final String FILENAME = "B";
//    static final String IN       = FILENAME + ".in";
//    static final String OUT      = FILENAME + ".out";
//    PrintStream         out      = System.out;
//    boolean writeToFile = false;
//
////    2
////    3 2
////    0 1
////    3 2
////    6 1
////    2 2
////    0 3
////    1 1
//    private void solve() {
//        int n = sc.nextInt();
//        int s = sc.nextInt();
//        List<Integer> l = new ArrayList<Integer>();
//        for (int i = 0; i < n; i++) {
//            int num = sc.nextInt();
//            int time = sc.nextInt();
//            for (int j = 0; j < time; j++) {
//                l.add(num);
//            }
//        }
//        double max = l.size()*(s)-s;
//        double saved = max;
//        double result = max;
//        while(max > saved*-1 ) {
//            double[] t = new double[l.size()];
//            boolean done = false;
//            for (int i = 0; i < l.size(); i++) {
//                t[i] = l.get(0) - max + i*s;
//                double diff = Math.abs(l.get(0) - t[i]);
////                out.println(diff);
//                if (diff > max) {
//                    done = true;
//                    break;
//                }
//            }
//            if (done) {
//                continue;
//            }
//            if (result < )
//            max -= 0.5;
//        }
//        out.println(max);
//    }
//
//    private void run() throws Exception {
//        if (writeToFile) {
//            out = new PrintStream(new FileOutputStream(OUT));
//        }
//        int t = sc.nextInt();
//        for (int i = 1; i <= t; i++) {
//            out.print("Case #" + i + ": ");
//            solve();
//        }
//        sc.close();
//        out.close();
//    }
//
//    public static void main(String args[]) throws Exception {
//        new B().run();
//    }
//}
