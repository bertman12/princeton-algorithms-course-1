package courseIntro;

import edu.princeton.cs.algs4.StdDraw;

public class BouncingBall {

    private static double xPos = 0.5;
    private static double yPos = 0.5;
    private static double radius = 0.05;
    //Add some controlled random variation for the speed on every run.
    private static double xDirSpeed = 0.002 + Math.random()*0.004;
    private static double yDirSpeed = 0.002 + Math.random()*0.004;

    public static void main (String[] args) {
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor();
        StdDraw.filledCircle(xPos, yPos, radius);

        //Smoothen out the animation
        StdDraw.enableDoubleBuffering();

        while(true){
            //Update ball position
            StdDraw.filledCircle(xPos, yPos, radius);
            xPos += xDirSpeed;
            yPos += yDirSpeed;

            //Display speed info
            StdDraw.text(0.5, 0.5, "x:" + String.valueOf(xDirSpeed).substring(0, 7) + ", y:" + String.valueOf(yDirSpeed).substring(0, 7));

            //Required when using double buffering
            StdDraw.show();

            //Remove previous drawn circles
            StdDraw.clear();
        
            //Reverse speed when ball leaves bounds of the window
            if(xPos >= 1 - radius) xDirSpeed = -xDirSpeed;
            if(xPos <= 0 + radius) xDirSpeed = -xDirSpeed;
            if(yPos >= 1 - radius) yDirSpeed = -yDirSpeed;
            if(yPos <= 0 + radius) yDirSpeed = -yDirSpeed;
        }
    
    }
}
