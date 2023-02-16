package chapterOne.sectionTwo;

public class RationalNumberTestClient {

    public static void main (String[] args ) {
        RationalNumber x = new RationalNumber(5, 2);
        RationalNumber y = new RationalNumber(5, 10);

        testOperations(x,y);

    }   

    private static void testOperations(RationalNumber x, RationalNumber y) {
        x.print(); y.print();

        x = x.multiply(y);
        // x.print();
        x = x.divide(y);
        // x.print();
        x = x.add(y);
        // x.print();
        x = x.subtract(y);
        // x.print();
    }

}
