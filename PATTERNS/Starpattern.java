package PATTERNS;  
public class Starpattern {
    public static void main(String[] args) {
        
        for(int line = 1; line <= 5; line++) {
            for(int star = 1; star <= line; star++) {
                System.out.print('*');
            }
            System.out.println(); // Move to the next line after printing stars for the current line
        }
    }
}
