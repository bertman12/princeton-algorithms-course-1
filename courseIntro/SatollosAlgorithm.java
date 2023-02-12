package courseIntro;

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

        durstenFieldShuffle(num);

        String[] items = {"A", "B", "C", "D"};
    
        satollos(items);
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


    public static void satollos(String[] items) {
        // for()
        
    }

}

