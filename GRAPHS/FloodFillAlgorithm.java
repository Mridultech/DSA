public class FloodFillAlgorithm {

    /*
     * Problem statement : Given a mxn grid image where image[i][j] represents the pixel value of the image, we're also given three integers as sr, sc,and color.We should perform a flood fill till on image starting from the pixel image[sr][sc].
     * The flood fill algorithm should replace the color of the pixel with the new color and all adjacent pixels with the same color should also be replaced with the new color.
     * We can move up,down,right,left.
     * sr = source row,sc = source column.
     * let sr = 1 and sc = 1 and color = 2.
     * ex : image = [[1,1,1],
     *               [1,1,0],
     *               [1,0,1]
     * ]
     * 
     * ans = [[2,2,2],
     *        [2,2,0],
     *        [2,0,1]]
     * 
     * approach : 
     * recursively : 
     * left(sr , sc-1)
     * right(sr, sc + 1)
     * down(sr + 1, sc)
     * up(sr -1 , sc)
     * 
     * invalid condition : yaha to boundary se bahar jaa rhe hai
     * base condition : yaha to color change ho gaya hai to phirse nahi krenge.
     * image[sr][sc] != orignalColor;
     */

     public void helper(int[][] image, int sr, int sc , int color, boolean visited[][], int orignalColor){ // time complexity : O(m*n)
        //base case 
        if(sr < 0 || sc < 0 || sr>=image.length ||sc >= image[0].length ||visited[sr][sc] || image[sr][sc] != orignalColor){
            return ;
        }
        //left
        helper(image, sr, sc-1, color, visited, orignalColor);
        //right
        helper(image, sr, sc+1, color, visited, orignalColor);
        //up
        helper(image, sr-1, sc, color, visited, orignalColor);
        //down
        helper(image, sr+1, sc, color, visited, orignalColor);
    }

     public int[][] floodfill(int[][] image, int sr, int sc , int color){
        boolean visited[][] = new boolean[image.length][image[0].length];
        helper(image,sr,sc,color,visited,image[sr][sc]);
        return image;
     }
    public static void main(String[] args){

    }
}
