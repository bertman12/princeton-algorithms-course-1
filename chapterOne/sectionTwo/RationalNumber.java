package chapterOne.sectionTwo;

import edu.princeton.cs.algs4.Vector;

/** 
 * Must be able to be expressed as m/n where  m and n are integers and n != 0
 * Decimal representation must be finite or have a repeating pattern.
 */
public class RationalNumber {
    private long numerator = 0;
    private long denominator = 1;

    public long getDenominator() {
        return denominator;
    }

    public long getNumerator() {
        return numerator;
    }

    public RationalNumber (long numerator, long denominator) {
        //Remove the GCF from numerator and denominators using Euclid's algorithm.
        System.out.println("Before GCF factor");
        this.numerator = numerator;
        this.denominator = denominator;
        this.toString();

        if(denominator == 0){
            throw new RuntimeException("Only non-zero integers allowed for the denominator.");
        }

        long gcf = euclid_GCF(numerator, denominator);
        System.out.println("The GCF: " + gcf);
        System.out.println("After GCF: ");

        this.numerator = numerator/gcf;
        this.denominator = denominator/gcf;
        this.toString();

    }

    /**
     * Before learning Euclid's algorithm
     */
    private long naive_GCF(long numerator, long denominator) {
        //Odd number
        long evenFactorAccumulator = 1;

        //Whilst both the numerator and denominator have 2 as a factor, divide by 2
        while(numerator % 2 == 0 && denominator % 2 == 0) {
            numerator = numerator/2;
            denominator = denominator/2;
            evenFactorAccumulator *= 2;
        }

        long oddFactor = ((numerator - 1)/2) - 1;
        // System.out.println("numerator after factoring 2:  " + numerator);

        //Accommodate when the result is an odd number
        if( oddFactor % 2 == 0) oddFactor--;

        // System.out.println("Temp num initialized : " + oddFactor);
        long oddFactorAccumulator = 1;

        //Can optimize by checking if numerator is greater than denominator
        while(oddFactor >= 3) {
            //Check if it is a factor of the numerator and denominator
            if(numerator % oddFactor == 0 && denominator % oddFactor == 0) {
                numerator = numerator/oddFactor;
                denominator = denominator/oddFactor;
                // System.out.println("Found an odd factor:" + oddFactor);
            
                oddFactorAccumulator *= oddFactor;

                //Reset possible odd factor
                if(numerator % 2 == 0){
                    oddFactor = ((numerator - 2)/2) - 1;
                }
                else { 
                    oddFactor = ((numerator - 1)/2) - 1;
                }

                if(oddFactor % 2 == 0) oddFactor--;
            }
            else{
                oddFactor -= 2;
            }
        }

        System.out.println("The GCF: " + oddFactorAccumulator*evenFactorAccumulator);
        
        return oddFactorAccumulator*evenFactorAccumulator;
    }

    /**
     * Utilizing the remainder theorem.
     */
    private long euclid_GCF(long n, long d) {
        if (n == 0)
        return d;

        return euclid_GCF(d % n, n);
    }

    public static void main (String[] args ) {

    }

    public RationalNumber multiply(RationalNumber b) {
        return new RationalNumber(this.numerator * b.numerator,this.denominator * b.denominator);
    }
    
    public RationalNumber divide(RationalNumber b) { 
        if(this.denominator == 0 || b.denominator == 0){
            throw new RuntimeException("0 denominator");
        }
        
        return new RationalNumber(this.numerator * b.denominator,this.denominator * b.numerator);
    }
    
    public RationalNumber add(RationalNumber b) {
        long _numerator = this.numerator*b.denominator + b.numerator*this.denominator;
        long _denominator = this.denominator*b.denominator;
        
        return new RationalNumber(_numerator, _denominator);
    }
    
    public RationalNumber subtract(RationalNumber b) {
        long _numerator = this.numerator*b.denominator - b.numerator*this.denominator;
        long _denominator = this.denominator*b.denominator;
        
        return new RationalNumber(_numerator, _denominator);
    }

    @Override
    public String toString() {
        System.out.println("\n" + this.numerator);
        System.out.println("--");
        System.out.println(this.denominator + "\n");
        return "\n" + this.numerator + "--\n" + this.denominator + "\n";
    }

    public boolean equals(RationalNumber r) {
        return this.numerator == r.numerator && this.denominator == r.denominator;
    }

}

