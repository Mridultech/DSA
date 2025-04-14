import java.util.Scanner;

public class StringCompression {

    public static String stringCompress(String str){
    // note : string compression is a technique to compress the string by removing the repeated characters and replacing them with the character followed by the count of that character
    // for example : aaabbccdee will be compressed to a3b2c2d1e2
    // for ex : aabbdddlafaa will be compressed to a2b2d3l1a1f1a2
    //aisa zaruri nahi hai ki last wale a or starting wale a combine ho kar a3 ban jaye , a2b2d3l1a1f1a2 bhi sahi hai
    //less optimized approach through string 


    //     String newStr = "";
        
    //     for(int i=0 ; i < str.length() ; i++){ // string ke ek ek char ko traverse karega
    //     Integer count = 1;
    //     while(i < str.length() - 1 && str.charAt(i) == str.charAt(i+1)){ // jab tak string ke char same hai tab tak count badhate jayega or jab tak i ki value string ke length se ek choti hai tab tak loop chalega
    //         count++; // count badhate jayega
    //         i++;
    //     }
    //     newStr += str.charAt(i); // newStr mein character ko add karenge
    //     if(count > 1){ // agar count 1 se bada hai toh usko bhi add karenge
    //         newStr += count.toString(); // count ko string mein convert karke add karenge kyuki newStr string hai or count integer hai
    //     }
    // }

    // optimized approach using stringbuilder

        StringBuilder newStr = new StringBuilder(""); // stringbuilder bana diya newStr ke liye

        for(int i = 0 ; i < str.length() ; i++){// string ke ek ek char ko traverse karega
        Integer count = 1;// count ko 1 se initialize kiya
          
                while(i < str.length()-1 && str.charAt(i) == str.charAt(i+1)){// jab tak i ki value string ke length se ek choti hai tab tak loop chalega or jab tak string ke char same hai tab tak count badhate jayega
                    count++;
                    i++;
                }
            
                //append character to newStr

                newStr.append(str.charAt(i));

                //append count to newStr if count > 1

                if(count > 1){
                    newStr.append(count/* .toString()*/);// count ko string mein convert karne ki jarurat nahi hai kyuki stringbuilder hai or yeh khud convert kar leta hai
                }
            }
                
    return newStr.toString();
        }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string to compress it : ");
        String str = sc.nextLine();
        System.out.println(stringCompress(str)); 
        sc.close();
    }
    

}
