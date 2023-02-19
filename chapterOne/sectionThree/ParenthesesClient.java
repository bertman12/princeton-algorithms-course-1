package chapterOne.sectionThree;

import edu.princeton.cs.algs4.Stack;

/**
 * Write a stack client Parentheses.java
 * reads in sequence of left and right parentheses, braces, and brackets from standard input and uses a stack to determine whether the sequence is properly balanced. 
 * For example, your program should print true for [()]{}{[()()]()} and false for [(]).
 */
public class ParenthesesClient {
    //LIFO
    // private static Stack<Character> input = new Stack<Character>();

    //Test cases
    public static void main(String[] args) {
        validateSequence("[()]");
        validateSequence("[1(2)3]4");
        validateSequence("[({})]");
        validateSequence("[{]}]({})");
        validateSequence("[[]({})");
        validateSequence("[]({}))))))");
        validateSequence("[[[]]]");
        validateSequence("123456");
        validateSequence("[[[[[[[[[[[[[[]]]");
    }

    //O(N) time
    //Space Worst case - O(2N) for the stack and char array ; Best Case: O(0) no closing/opening symbols;
    private static boolean validateSequence(String sequence) {
        //Whichever is the most recent group type should always be the only valid closing group type otherwise the sequence is invalid
        //[)] -- invalid
        //[()] -- valid
        boolean isValid = true;
        
        Stack<Character> input = new Stack<Character>();
        
        char[] chars = sequence.toCharArray();
        System.out.println(chars);
        
        for(int i = 0; i < chars.length; i++) {
            char c = chars[i];

            //Add opening symbols to the stack
            if(c == '[' || c == '{' || c == '(' ){
                input.push(c);
            }
            //Pop and compare the element against the opening symbols when reading a closing symbol
            else if(!input.isEmpty()){
                switch (c) {
                    case ']':
                        if(input.pop() != '[') isValid = false;
                        break;
                    case '}':
                        if(input.pop() != '{') isValid = false;
                        break;
                    case ')':
                        if(input.pop() != '(') isValid = false;
                        break;
                    default:
                        //Do nothing
                        break;
                }
            }
            //Handle any excess closing symbols
            else if(input.isEmpty() && (c == ']' || c == '}' || c == ')' )) {
                System.out.println("Unpaired closing symbol(s).");
                isValid = false;
            }
            
            //Discontinue loop immediately when isValid is false.
            if(isValid == false){
                break;
            } 
            
        }

        //There should remain no items in the stack if each opening brace was closed.
        if(input.size() > 0){
            System.out.println("Unpaired open symbol(s).");
            isValid = false;
        } 

        System.out.println("Sequence Validity: " + isValid + "\n");

        return isValid;
    }

}
