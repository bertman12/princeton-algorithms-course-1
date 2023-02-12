package courseIntro;

import edu.princeton.cs.algs4.StdDraw;

public class RightTriangle {

    private static double circleOriginX;
    private static double circleOriginY;
    private static double circleRadius;
    
    public static void main (String[] args) {
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.BLUE);

        circleOriginX = 0.5;
        circleOriginY = 0.5;
        circleRadius = 0.1;

        StdDraw.circle(circleOriginX, circleOriginY, circleRadius);
        StdDraw.setPenColor(StdDraw.RED);
        
        //Bisecting line
        double topLeft = (3*Math.PI)/4;
        double bottomLeft = (5*Math.PI)/4;
        double bottomRight = (-Math.PI)/4;
        
        inscribeLine(topLeft, bottomRight);
        inscribeLine(bottomLeft, topLeft);
        inscribeLine(bottomLeft, bottomRight);
    }

    private static double getXOnCircle(double radian) {
        return circleOriginX + Math.cos(radian)*circleRadius;
    }

    private static double getYOnCircle(double radian) {
        return circleOriginY + Math.sin(radian)*circleRadius;
    }

    private static void inscribeLine(double radianStart, double radianEnd) {
        StdDraw.line(getXOnCircle(radianStart), getYOnCircle(radianStart), getXOnCircle(radianEnd), getYOnCircle(radianEnd));
    }

}
