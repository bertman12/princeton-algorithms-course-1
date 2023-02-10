package unionFind;

public class UF {
    /**
     * Goal : Design efficient data structure for union-find
     * Number of objects N can be huge
     * Number of operations M can be huge
     * Find queries of union commands may be intermixed. 
     */

    public static int count = 5;
    public static int[] id = new int[count];
    
    /**
     * Memory wasteful.
     * N^2 space complexity lol
     * 
     * However, when combining based on component ids, you will simply add the elements from one array to the other.
     */
    private static int[] set0 = new int[10];
    private static int[] set1= new int[10];
    private static int[] set2 = new int[10];
    private static int[] set3 = new int[10];
    private static int[] set4 = new int[10];
    private static int[] set5 = new int[10];
    private static int[] set6 = new int[10];
    private static int[] set7 = new int[10];
    private static int[] set8 = new int[10];


    public static UF constrUf(int N){
        return constrUf(5);
    }

    public static void main(String[] args) {
        
    } 

    /**
     * Add a connection between p and q
     * 
     * Instead of iterating through the entire id array, give every connected component it's own array.
     * Then when combining p and q, add set Q to set P and make set Q null or empty.
     * 
     * @param p
     * @param q
     */
    public static void union(int p, int q) {
        /**
         * To merge components then all elements that are affected by the combine, must have their id's changed to be the same  
         * 
         */

    }

    //are p and q in the same component?
    public static boolean connected(UF P, UF Q){
        //We have an array of all possible elements. Each element belongs to a set. If 2 elements share the same set id then they are connected.
        /**
         * If p and q are connected then inside our ID
         * Check if p and q have the same id
         */

        return true;
    }

    public static boolean quickFind() {


        return false;
    }



}
