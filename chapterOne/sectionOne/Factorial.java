package chapterOne.sectionOne;

public class Factorial {
    
    public static int evaluate(int N) {
        int result = 1;

        for(int i = 1; i <= N; i++) {
            // System.out.println(i);
            result = result * i;
        }

        // System.out.println("Result: " + result);

        return result;
    }

    public static void main(String[] args) {
        evaluate(8);
    }
}
