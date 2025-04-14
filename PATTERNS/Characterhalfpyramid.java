import java.util.*;
public class Characterhalfpyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows you want in pattern:");
        int n = sc.nextInt();
        char ch = 'A';
        for(int line=0;line<=n;line++){
            for(int alpha=1;alpha<=line;alpha++){
                System.out.print(ch);
                ch++;
            }System.out.println();

        }
    
}
}