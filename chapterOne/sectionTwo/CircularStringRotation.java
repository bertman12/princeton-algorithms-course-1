package chapterOne.sectionTwo;

public class CircularStringRotation {
    public static void main (String[] args) { 
        String s = "Fred";
        String t = "edFr";

        // FredFred 
        //   edFr -> Fr + ed -> Fred
        //Confirmed circular rotation
        if(s.length() == t.length() && s.concat(s).indexOf(t) >= 0){
            System.out.println("String " + t + " is a circular cycle of " + s + ".");
        }

    }
}



