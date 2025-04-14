public class SubsetsOfStrings {

    /*
     * Problem statement : Given a string, we have to print all the subsets of the given string.
     * Example :
     * Input : "abc"
     * Output : "","a","b","c","ab","ac","bc","abc"
     */

    public static void subsetsStr(String str , String ans , int i){ //Time complexity : O(n*2^n) : total subsets for string of n characters is 2^n and to find a single subset we used n time , Space complexity : O(2^n) : because every character of whole string have 2 choices of yes or no so for n characters there are 2^n memory locations have to be used.
        //base case 

        if(i == str.length()){

            if(ans.equals("")){
                System.out.println("NULL");
                return;
            }

            else{
                System.out.println(ans);
                return; 
            }

        }

        //kaam
        //Do choices hongi 

        //yes 

        subsetsStr(str , ans + str.charAt(i) , i+1);

        //No

        subsetsStr(str , ans , i+1);

    }

    public static void main(String[] args){
        String str = "abc";
        subsetsStr(str,"",0);
    }

}
