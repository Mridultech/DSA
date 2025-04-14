import java.util.*;
public class Chocola{ // other name : minimum cost to cut board into squares., chessboard n = 8 because 8*8 chessboard

    /*
     * Problem statement : We are given a chocolate bar of size m x n. We need to break it into 1 x 1 or single square pieces.
     * Each break of a part of the chocolate bar is charged a cost expressed by a positive integer.
     * This cost does not depend on the size of the part of the chocolate bar that is broken but only depends on the line the break goes along . 
     * Let us denote the costs of breaking along consecutive vertical lines with x1 , x2 ,.... , xm1 and along horizontal lines with y1 , y2 ,.... , yn-1 .
     * Compute the minimal cost of breaking the whole chocolate into single squares.
     * 
     * 
     * is problem mein hame sare cuts ek baar to use krne hi pdenge ye dekhna hai ki kis order mein lagenge
     * ek cut lagane pe chocolate ke hisse bhad jaa rhe hai to hame har hisse ke liye individually cost deni pdegi isiliye hame pehle mehangi cost wale hisse pehle cut karne honge.
     * cost of vertical = number of horizontal pieces * cost of vertical cut
     * cost of horizontal = number of vertical pieces * cost of horizontal cut
     * 
     * Next, we will implement the logic to calculate the minimum cost based on the given costs of cuts.
     */
public static void main(String[] args) {
    int n = 4 , m = 6; // size of chocolate bar
    Integer costVertical[] = {2,1,3,1,4};
    Integer costHorizontal[] = {4,1,2,}; // cost of cuts

    Arrays.sort(costVertical, Collections.reverseOrder()); // sort in descending order
    Arrays.sort(costHorizontal, Collections.reverseOrder()); // sort in descending order

    int h = 0 , v = 0; // konsa horizontal or vertical cut hai
    int hp = 0 , vp = 0;// horizontal and vertical pieces
    int cost = 0; // total cost

    while(h < costHorizontal.length && v < costVertical.length) {
        //vertical cut is more expensive
        if(costVertical[v] < costHorizontal[h]) {
            //horizontal cut 
            cost += (costHorizontal[h] * vp);
            hp++;
            h++;
        } else {
            //vertical cut
            cost += (costVertical[v] * hp);
            vp++;
            v++;
        }
    }

    while(h < costHorizontal.length){
        cost += (costHorizontal[h] * vp);
        hp++;
        h++;
    }

    while(v < costVertical.length){
        
        cost += (costVertical[v] * hp);
        vp++;
        v++;
    }
    

    System.out.println("Minimum cost to cut the chocolate: " + cost);
}
}