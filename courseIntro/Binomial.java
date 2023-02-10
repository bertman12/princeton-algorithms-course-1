package courseIntro;

// import edu.princeton.cs.algs4.StdOut;

// import edu.princeton.cs.algs4.StdOut;

/******************************************************************************
 *  Compilation:  javac Binomial.java
 *  Execution:    java Binomial N k p
 *  Dependencies: StdOut.java
 *
 *  Reads in N, k, and p as command-line arguments and prints out
 *  (N choose k) p^k (1-p)^N-k.
 *
 *  % java Binomial 5 2 .25
 *  0.263671875
 *  0.263671875
 *
 *  % java Binomial 5 3 .25
 *  0.087890625
 *  0.087890625
 *
 *  % java Binomial 5 0 .25
 *  0.2373046875
 *  0.2373046875
 *
 *  % java Binomial 5 5 .25
 *  9.765625E-4
 *  9.765625E-4
 *
 ******************************************************************************/

 public class Binomial {
    private int count = 0;

    // slow

    /**
     * Max time this would run. 
     * Min 1 loop
     * Max: N if N > k || k if k > N
     * Param p has no effect on number of method calls. 
     * 
     * If N === k, then max runtime is N - 1
     * If N > k runtime is (k) , k would approach one of the 2nd base case before N
     * if k > N then you run k times.
     * 
     * 
     * 
     */
    public static double binomial1(int N, int k, double p) {
        //Base case 1
        if (N == 0 && k == 0) return 1.0;
        //Base case 2
        if (N < 0 || k < 0) return 0.0;
        //Recursive case
        return (1.0 - p) *binomial1(N-1, k, p) + p*binomial1(N-1, k-1, p);
        // (1.0 - p)^N + p*(1.0 - p)^N + k
        //  0 , whenever k is less than N
    }

    // memoization
    public static double binomial2(int N, int k, double p) {
        double[][] b = new double[N+1][k+1];

        // base cases
        for (int i = 0; i <= N; i++)
            b[i][0] = Math.pow(1.0 - p, i);
        b[0][0] = 1.0;

        // recursive formula
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= k; j++) {
                b[i][j] = p * b[i-1][j-1] + (1.0 - p) *b[i-1][j];
            }
        }
        
        return b[N][k];
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        double p = Double.parseDouble(args[2]);
        System.out.println(binomial1(N, k, p));
        System.out.println(binomial2(N, k, p));
    }

}