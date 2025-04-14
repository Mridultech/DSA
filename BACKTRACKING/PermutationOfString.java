public class PermutationOfString {

    /*
     * 
     * Type of backtracking : enumeration
     * Note : For a string of n characters , total permutations = n!
     * yaha pe ham do string banayenge ek orignal jo hai plus dusri jo ans hogi 
     * har baar ek character ko ans me add karenge or uske baad us character ko remove kar denge or uske baad uss string ke saath recursion call karenge
     * at final stage jab string ka length 0 ho jayega toh ans print kar denge.
     * 
     */

    public static void permutations(String str , String ans){

        //Base case : 

        if(str.equals("")){
            System.out.println(ans);
            return;
        }
        
        //kaam

        for(int i = 0 ; i < str.length() ; i++){
            //Choice - yes 
            String newStr = str.substring(0,i) + str.substring(i+1);
            permutations(newStr, ans + str.charAt(i));

        } 
    }
    public static void main(String[] args) { //Time complexity : (n*n!) : because we have n! permutations and to process a single permutation we need n time , Space complexity : 
        String str = "abc";
        permutations(str,"");
        
    }
}
