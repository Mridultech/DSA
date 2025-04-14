import java.util.*; //importing * means importing all the classes present in the package
public class Input {
    public static void main(String[] args) {
    //Input in Java 
    //Scanner class is used to take input from the user
    //Scanner class is present in java.util package
    //To use Scanner class, we need to import it using import java.util.Scanner;

    //Syntax to create an object of Scanner class
    //Scanner object_name = new Scanner(System.in);

     Scanner sc = new Scanner(System.in);
     System.out.println("Enter your name: ");
     String name = sc.next();
     System.out.println(name);

        //To take input of integer
        int a = sc.nextInt();
        System.out.println("Enter a number: ");
        System.out.println(a);

        //To take input of float
        float b = sc.nextFloat();
        System.out.println("Enter a float number: ");
        System.out.println(b);

        //To take input of double
        double c = sc.nextDouble();
        System.out.println("Enter a double number: ");
        System.out.println(c);
        
        //To take input of long
        long d = sc.nextLong();
        System.out.println("Enter a long number: ");
        System.out.println(d);

        //To take input of byte
        byte e = sc.nextByte();
        System.out.println("Enter a byte number: ");
        System.out.println(e);

        //To take input of short
        short f = sc.nextShort();
        System.out.println("Enter a short number: ");
        System.out.println(f);

        //To take input of boolean
        boolean g = sc.nextBoolean();
        System.out.println("Enter a boolean value: ");
        System.out.println(g);

        //To take input of character
        char h = sc.next().charAt(0);//charAt(0) is used to take the first character of the string
        System.out.println("Enter a character: ");
        System.out.println(h);

        //To take input of string
        String i = sc.nextLine();
        System.out.println("Enter a string: ");
        System.out.println(i);

}
}