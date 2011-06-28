package codejam2011.round1a;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B {

    Scanner             sc       = new Scanner(getClass().getResourceAsStream(IN));
    static final String FILENAME = "B";
    static final String IN       = FILENAME + ".in";
    static final String OUT      = FILENAME + ".out";
    PrintStream         out      = System.out;
    boolean writeToFile = false;

//    2
//    3 2
//    banana
//    caravan
//    pajamas
//    abcdefghijklmnopqrstuvwxyz
//    etaoisnhrdlcumwfgypbvkjxqz
//    4 1
//    potato
//    tomato
//    garlic
//    pepper
//    zyxwvutsrqponmlkjihgfedcba
    private void solve() {
        int numWords = sc.nextInt();
        int numGames = sc.nextInt();
        List<String> dict = new ArrayList<String>(numWords);
        for (int i = 0; i < numWords; i++) {
            dict.add(sc.next());
        }
        List<String> seqs = new ArrayList<String>(numGames);
        for (int i = 0; i < numGames; i++) {
            seqs.add(sc.next());
        }
        for (String seq : seqs) {
            int[] result = new int[dict.size()];
            for (int i = 0; i < dict.size(); i++) {
                String word = dict.get(i);
                // populate result vector
                int length = word.length();
                List<String> newList = new ArrayList<String>();
                for (String s : dict) {
                    if (s.length() == length) {
                        newList.add(s);
                    }
                }
//                System.out.println(newList);
                // newList contains all words with the same length as current word
                // if there's only 1 or 0 choice, then the game is solved
                if (newList.size() <= 1) {
                    result[i] = 0;
                } else {
                    for (char c : seq.toCharArray()) {
                        out.println("current char:" + c);
                        boolean found = false;
                        for (String s : newList) {
                            if (s.indexOf(c) >= 0) {
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            continue;
                        }
                        
                        List<String> newnewList = new ArrayList<String>();
//                        boolean found = false;
                        boolean removed = false;
                        for (String curWord : newList) {
//                            out.println(curWord);
                            if (curWord.indexOf(c) >= 0) {
                                // found the word
                                found = true;
                                String newString = removeAll(curWord, c);
                                if (word.indexOf(c) >=0) {
                                    removed = true;
                                }
                                out.println(newString);
                                if (!newString.equals("")) {
                                    newnewList.add(newString);
                                }
                            } else {
                                newnewList.add(curWord);
                            }
                        }
                        newList = newnewList;
                        if (!found) {
                            continue;
                        }
                        if (!removed) {
                            result[i]++;
                        }
                        if (newnewList.size() <= 1) {
                            break;
                        }
                    }
                }

            }
            int max = Integer.MIN_VALUE;
            int maxIndex = -1;
            for (int z = 0; z < result.length; z++) {
                out.println(result[z]);
                if (result[z] > max) {
                    max = result[z];
                    maxIndex = z;
                }
            }
            out.print(dict.get(maxIndex));
            out.print(" ");
        }
        out.println();
    }

    private String removeAll(String w, char c) {
        String s = "";
        for (char ch : w.toCharArray()) {
            if (ch != c) {
                s += ch;
            }
        }
        return s;
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
