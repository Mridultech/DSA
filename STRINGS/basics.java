import java.util.*;
public class basics{
    public static void main(String[] args){
        System.out.println("Basics of strings ");

        // how to write strings 

        String name = "mridul"; // strings ko hamesha double quotes mein likho
        String anothername = new String("monika");

        //Note : Strings in java is immutable 

        // how to take string as input

        Scanner sc = new Scanner(System.in);
        String nametest;
        //nametest = sc.next(); // ye keval ek word lega fir spaces aaye to uske bad nahi lega
        nametest = sc.nextLine(); // ye puri line lega
        // note : strings mein hame special chars such as @#!$ ye sab bhi le skte hai jo java mein valid chars hai wo sab

        // strings is class so there are some methods related to it too.

        // 1. length() : ye method string ki length return karta hai
        System.out.println(name.length()); // yaha pe length ke aage () lagana jaruri hai kyuki ye method hai lekin array mein nahi wha pe keval .length likhna hota hai kyuki wha length array ki property hoti hai

        // 2. charAt() : ye method ek specific index pe jo char hai usko return karta hai

        System.out.println(name.charAt(2)); // ye 2nd index pe jo char hai usko return karega


        //string concatenation
        String s1 = "mridul";
        String s2 = "gupta";
        System.out.println(s1+s2); // ye dono strings ko concatenate kar dega

    }
} 