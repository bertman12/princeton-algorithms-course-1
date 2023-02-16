package chapterOne.sectionTwo;

import java.sql.Timestamp;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;

public class PointTestClient {
    public static void main (String[] args) {
        //For testing purposes.
        args = new String[1];
        args[0] = "50";

        // Timestamp
        StdDraw.setCanvasSize(800, 800);
        // StdDraw.setXscale(0, 100);
        // StdDraw.setYscale(0, 100);
        StdDraw.setPenRadius(0.008);
        
        int numPoints = Integer.parseInt(args[0]);
        System.out.println("Number of points: " + numPoints);

        Point2D[] points = new Point2D[numPoints];

        //Create N points.
        for(int i = 0; i < numPoints; i++) {
            points[i] =  new Point2D(Math.random(), Math.random());
            points[i].draw();
        }
        "a".concat(null).indexOf("null");
        /**
         * Track the smallest distance, save it. any distance shorter than that. disregard it
         * 
         * Check a circular region around a point. Select point with shortest distance of the centered point 
         * 
         * If you cut the screen into rectangular regions, and found the points with the shortest distance in that region. store that. then compare the point in the previous region with the lowest Y value.
         * consider that point as part of the next region. repeat the step of finding the points with the smallest distance, store it. if the previously stored distance is larger then get rid of it.
         * 
         * If the absolute value of the difference of x^2 + y^2 is not smaller than the previous absolute value, then discard the point.
         * 
         */
        double currentShortestDistance = Double.MAX_VALUE;
        Point2D[] closestPair = new Point2D[2];
        
        //O(n^2) - brute force method.
        //Compares distance of point i to point j
        for(int i = 0; i < numPoints; i++) {

            //Loop the remaining indexes, excluding i and previous i indexes
            for(int j = i + 1; j < numPoints; j++) {
                //Ignore comparing point i with itself
                double dist = points[i].distanceSquaredTo(points[j]);
                if(dist < currentShortestDistance) {
                    //Track new shortest distance 
                    currentShortestDistance = dist;

                    //Save the new closest points
                    closestPair[0] = points[i];
                    closestPair[1] = points[j];
                }
            }
            
        }

        System.out.println("Closest pair: " + closestPair[0].x() + "," + closestPair[0].y() + " - " + closestPair[1].x() + "," + closestPair[1].y());
        System.out.println("Shortest distance: " + Math.sqrt(currentShortestDistance));
        closestPair[0].drawTo(closestPair[1]);

    }
}


