package courseIntro;

import edu.princeton.cs.algs4.StdDraw;

public class BouncingBall {

    private static double xPos = 0.5;
    private static double yPos = 0.5;
    private static double radius = 0.05;
    private static double xDirSpeed = 0.002 + Math.random()*0.004;
    private static double yDirSpeed = 0.002 + Math.random()*0.004;

    public static void main (String[] args) {
        // StdDraw.setPenRadius();
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor();
        StdDraw.filledCircle(xPos, yPos, radius);

        StdDraw.enableDoubleBuffering();


        //Update ball position
        while(true){
            StdDraw.filledCircle(xPos, yPos, radius);
            xPos += xDirSpeed;
            yPos += yDirSpeed;
            StdDraw.text(0.5, 0.5, String.valueOf(xDirSpeed).substring(0, 7) + ", " + String.valueOf(yDirSpeed).substring(0, 7));

            StdDraw.show();
            StdDraw.clear();
        
            if(xPos >= 1 - radius) xDirSpeed = -xDirSpeed;
            if(xPos <= 0 + radius) xDirSpeed = -xDirSpeed;
            if(yPos >= 1 - radius) yDirSpeed = -yDirSpeed;
            if(yPos <= 0 + radius) yDirSpeed = -yDirSpeed;
        }
    
    }
}
