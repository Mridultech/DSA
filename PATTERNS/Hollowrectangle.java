public class Hollowrectangle {
    public static void HollowRectangle(int totalrows,int totalcols){
        //outer loop
        for(int i=1;i<=totalrows;i++){
            //inner loop
            for(int j=1;j<=totalcols;j++){
                //cell-(i,j)
                if(i==1 || i==totalrows || j==1 || j==totalcols){
                    System.out.print("*");
                }
                else
                    System.out.print(" ");
            }System.out.println();
        }
    }

    public static void main(String[] args) {
        HollowRectangle(4,5);
    }
}