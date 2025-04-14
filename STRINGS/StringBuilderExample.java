import java.util.*;
public class StringBuilderExample{
    public static void main(String[] args) {
        
        /*
         * mehthodology : 
         * 
         * why its needed : 
         * kyuki jab hame strings mein kuch minor changes krne hote hai on long loops then we should use StringBuilder
         * kyuki normal string ko use karne se se problem of interning samne aati hai 
         * 
         * problem of interning 
         * 
         * jab ham ek hi string ko 2 variables ko lagatar dete hai toh uska memory address same hota hai kyuki pehle wala variable usko refer kr rha hota hai heap memory mein and stack mein redundant variable ban jate hai 
         *     
         *  lekin jab nayi string banegi to uske liye naye variable banenge ya fir new method use krne se nayi memory allocate hogi   
         * 
         * iski wajah se string immutable bhi rehti hai 
         * 
         * ex : String str = "tony";
         * for((char = 'a'; char <= 'z'; char++){
         *      str = str + char;
         * }
         * ab aise codes mein manke chalo ki agar string 1000 bar change ho rhi hai to wo 1000 new strings create karega or let har string ka size hai m or n time string create ho rhi hai toh uska time complexity ho jayega O(m*n) jo ki bhot zyada hai
         * 
         * iss wajah se hamne string builder ka concept introduce kiya
         * */


        //1. toString method : kisi bhi object ko string mein convert kar deta hai .(only object ko)

        /*
         * ex : int a = 10;
         * a.toString(); : ye galat hai kyuki a object nahi hai 
         * 
         * lekin 
         * 
         * Integer a = 10;
         * a.toString(); ab sahi hai kyuki is baar a object bana hai 
         * 
         * same hi difference char and Character mein hai char mein kaam nahi krega jabki Character mein krega 
         */

        // kaise banega string builder
        StringBuilder sb = new StringBuilder(""); //intialized with empty string
        for(char ch = 'a'; ch <= 'z'; ch++){
            sb.append(ch); //append method se string builder mein string add hoti hai rehti hai given string ke end mein
        }
        // for this the time complexity will be O(26) only

        // lekin agar ham sp.append(ch) ki jagah sp += ch karte toh uska time complexity O(26^2) ho jayega kyuki string immutable hai toh usmein nayi string create hogi har baar
        
        System.out.println(sb);

        
    }


}