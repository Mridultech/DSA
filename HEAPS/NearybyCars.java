import java.util.*;
public class NearybyCars {

    /*
     * problem statement : We are given N points in a 2D plane which are locations of N cars. if we are at origin . print the nearest k
     * or k nearest points or k nearest restaurants from the origin. or k nearest points from the given point.
     * 
     * appraoch : 
     * step 0 : ek point class banalenge jisme sabhi points ki sari information store hogi.
     * step 1 : pehle ham sabhi points ka origin se distance nikal lenge.
     * step 2 : fir sabhi points ko unke reference ke sath priority queue me daal denge.
     * step 3 : priority queue se k baar pop karenge aur unhe print kar denge.
     */

     static class Point implements Comparable<Point>{ 
        int x ;
        int y ;
        int distanceSquare;
        int index;
        
        public Point(int x , int y , int distanceSquare , int index){
            this.x = x;
            this.y = y;
            this.distanceSquare = distanceSquare;
            this.index = index;
        }

        @Override
        public int compareTo(Point p2){
            return this.distanceSquare - p2.distanceSquare; // ascending order
        }
    }
       
    public static void main(String[] args){
        int pts[][] = {{1,2},{3,4},{4,5},{5,6},{2,3}};
        int k = 3;

        PriorityQueue<Point> pq = new PriorityQueue<>(); // min heap
        for(int i = 0 ; i < pts.length ; i++){
        int distanceSquare = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1]; // distance square from origin
        pq.add(new Point(pts[i][0],pts[i][1], distanceSquare,i));
        }

        //nearest k cars 
        for(int i = 0; i < k ; i++){
            System.out.println(pq.remove().index); 
        }
    }
}
