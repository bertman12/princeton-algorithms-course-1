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
        // System.out.println("Before GCF factor");
        // this.numerator = numerator;
        // this.denominator = denominator;
        // this.print();

        if(denominator == 0){
            throw new RuntimeException("Only non-zero integers allowed for the denominator.");
        }

        //recursively divide numerator and denominator until the result is not an integer
        //Find the factors of any integer, excluding 1 and itself.
        //divide by 2 until you get a decimal number
        //then diving by primes?

        //Odd number

        //Whilst both the numerator and denominator have 2 as a factor, divide by 2
        while(numerator % 2 == 0 && denominator % 2 == 0) {
            numerator = numerator/2;
        }
        
        //Remaining factors must be at most 1 less than half the numerator
        //If you do find a common factor and divide, then reset temp num again to this line.

        /**
         * An odd number
         */
        long tempNum = -1 + (numerator - 1)/2;

        int count = 0;
        /**
         * First find an odd factor for the numerator
         * If you found one, then check if the denominator has that factor as well
         */

        //If a common odd numbered factor is found in the numerator and denominator, then remove.
        //Remove all odd numbered factors
        //If temp num is 3 then there are no more factors to check for
        // while(numerator % tempNum != 0 && denominator % tempNum != 0 && tempNum >= 3) {
        

        //Can optimize by checking if numerator is greater than denominator
        //Exhaust all options
        while(tempNum >= 3) {
            //The only remaining factors are prime numbers

            //Check if safe to divide
            if(numerator % tempNum == 0 && denominator % tempNum == 0) {
                numerator = numerator/tempNum;
                denominator = denominator/tempNum;
                System.out.println("Found a factor:" + tempNum);
                
                //Reset temp num
                tempNum = -1 + (numerator - 1)/2;
            }

            //Subtract multiples of 2 to avoid any even numbers since they are no longer a factor of the numerator. 
            tempNum = tempNum - 2*count;
            count++;
        }

        System.out.println("AFTER GCF factor");
        this.numerator = numerator;
        this.denominator = denominator;
        this.print();

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

    public void print() {
        System.out.println("\n" + this.numerator);
        System.out.println("--");
        System.out.println(this.denominator + "\n");
    }

}

