package chapterOne.sectionOne;

import java.io.FileWriter;
import java.io.IOException;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Reads in a CSV from a url and prints it to another file
 */
public class Wget {
    public static void main (String[] args) {
        String url = "http://introcs.cs.princeton.edu/data/codes.csv";
       
        String data = new In(url).readAll();
        
        try {
            var fWriter = new FileWriter("chapterOne/sectionOne/data.html");
            fWriter.write(data);
            fWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        StdOut.println(data);
    }

}
