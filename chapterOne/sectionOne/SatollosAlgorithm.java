package chapterOne.sectionOne;

/**
 * A cycle of length n contains n vertices and n edges.
 * 
 * A cycle is when a path ends where it starts
 * 0-1-2-3-0
 * 
 * A cycle is unique amongst other cycles when at least one member is not included in other cycles?
 * 
 * {@link} https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#Sattolo.27s_algorithm
 */
public class SatollosAlgorithm {

    public static void main(String[] args) {
        int num = (int) (Math.random()*15);
        // durstenFieldShuffle(num);

        System.out.println("\nThe Durstenfield Shuffle");
        
        durstenFieldShuffle(4);
        
        System.out.println();
        
        String[] items = {"A", "B", "C", "D"};
        int max = Factorial.evaluate(items.length);
        
        System.out.print("\nThe max unique cycles for items: "+ max);

        //Attempt to create all unique cycles from items
        for(int i = 0; i < Factorial.evaluate(items.length); i ++){
            satollos(items);
        }
    }

    public static int[] durstenFieldShuffle(int N){
        int[] set = new int[N];

        //Initialize array
        for(int i = 0; i < N; i++) {
            set[i] = i;
        }
        
        for(int i = (N - 1); i >= 1; i--) {
            //Add 1 since (int) always rounds down and Math.random is not inclusive for its upper bound           
            //0 <= j <= i 
            int j = (int) (Math.random()*(i + 1));
            
            if(j > i) {
                System.out.println("j was greater than i, algorithm incorrect.");
                return new int[0];
            } 

            //Swap j with i
            int temp = set[j];
            set[j] = set[i];
            set[i] = temp;
        }

        for(int i = 0; i < set.length; i++) System.out.print(" : " + set[i] + " : ");

        return set;
    }

    /**
     * Create a uniformly distributed cycle of length N
     * 
     * Possible permutations is (N - 1)!
     * why?
     * 
     * @param items
     */
    public static void satollos(String[] items) {

        for(int i = (items.length - 1); i >= 1; i--) {
            //Add 1 since (int) always rounds down and Math.random is not inclusive for its upper bound           
            //0 <= j <= i - 1 
            int j = (int) (Math.random()*(i));

            //Swap j with i
            String temp = items[j];
            items[j] = items[i];
            items[i] = temp;
        }
        
        System.out.print("\nUniformly distributed cycle: " );

        for(int x = 0; x < items.length; x++) System.out.print(" : " + items[x] + " : ");
    }

}

