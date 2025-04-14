import java.util.*;
public class RemoveDuplicateInStrings {

    /*
     * concept : type conversion in expressions 
     * 
     * ex : chars jab expressions mein aayenge to automatically unka result int mein convert ho jata hai 
     * ex : 'c' - 'a' = int = 3
     * 
     * question kya hai : ek string de rkhi hai , usmein se duplicate characters ko remove krna hai
     * ex : "abac" -> "abc"
     * 
     * approach :
     * 1. ek boolean array banayenge of size 26 (26 alphabets ke liye)
     * 2. ek string banayenge jismein hum duplicate characters ko remove karenge
     * 3. ek loop chalayenge string ke upar
     * 4. agar character pehli baar aaya hai to usko add karenge new string mein
     * 5. agar character pehli baar nahi aaya hai to usko add nahi karenge
     * 6. Base case hoga jab string khatam ho jayegi i.e length of string
     * 
     * call stack analysis : 
     * 
     */

    public static String removeDuplicates(String str , int index , StringBuilder newStr , boolean map[]){
        if(index == str.length()){
            System.out.println(newStr);
            return newStr.toString();
        }

        //kaam 
        char currentCharacter = str.charAt(index);
        if(map[currentCharacter-'a']==true){
            //duplicate
            return removeDuplicates(str, index+1, newStr, map);
        }
        else{
            map[currentCharacter-'a'] = true;
            return removeDuplicates(str, index+1, newStr.append(currentCharacter), map);
        }

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string from which you want to remove duplicates :");
        String str = sc.nextLine();
        System.out.println("String before removing duplicates : " + str);
        System.out.println("String after removing duplicates is : " + removeDuplicates(str,0,new StringBuilder(""),new boolean[26]));
        sc.close();
    }
}
