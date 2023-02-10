package courseIntro;

public class HelloGoodbye {
    
    public static void main(String[] args) {
        String personOne = args[0];
        String personTwo = args[1];
        var text = "Hello "+personOne + " and "+personTwo+".";
        System.out.println(text);
        text = "Goodbye "+personOne + " and "+personTwo+".";
        System.out.println(text);
    }
}
