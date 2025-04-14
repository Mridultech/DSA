import java.util.*;
public class PascalCase {

    public static String pascalCase(String str){
        StringBuilder sb = new StringBuilder(""); // string builder bana diya

        //pehle character ko corner case ki tarah handle karna pdega 

        char ch = Character.toUpperCase(str.charAt(0)); // toUpperCase() method se pehla character ko upper case mein convert kar diya & toUpperCase() method character ko upper case mein convert kar deta hai
        sb.append(ch); // append jo hai wo given character ko add kar dega empty string mein jo hamne stringbuilder mein intialize kiya hai

        for(int i = 1 ; i < str.length() ; i++){
            //pehle check karenge ki jo character hai wo space hai ya nahi and jo character hai wo string ki length se chota hai ya nahi
            if(str.charAt(i) == ' ' && i < str.length() - 1){
                //agar character space hai toh uske baad wale character ko upper case mein convert kar denge
                i++; // space aaya mtlab next word aaya so i ko increment kar denge

                sb.append(Character.toUpperCase(str.charAt(i))); // next character ko upper case mein convert karke stringbuilder mein add kar denge
            }
            else{
                //agar character space nahi hai toh usko stringbuilder mein add kar denge
                sb.append(str.charAt(i));
            }
        }
        return sb.toString(); // stringbuilder ko string mein convert karke return kar denge
    }
    public static void main(String[] args) { //time complexity of this code is O(n) where n is the length of the string
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string to covert it to pascal case : ");
        String str = sc.nextLine();
        System.out.println(pascalCase(str)); 
        sc.close();
    }
}
