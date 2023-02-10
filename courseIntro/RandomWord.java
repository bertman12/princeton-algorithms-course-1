package courseIntro;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        String champion = "";
        double inCounter = 0;

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();

            inCounter++;

            if (StdRandom.bernoulli(1/inCounter)) {
                champion = s;
            }
        }
        
        StdOut.println(champion);
    }

}
