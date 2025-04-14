public class substring {

    public static String subString(String str, int startIndex , int endIndex){
        String substr ="";
        for(int i = startIndex; i < endIndex; i++){
            substr += str.charAt(i);
        }
        return substr;
    }
    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println(subString(str, 2, 5)); 

        // lekin hamare paas java me substring method hai jo ki ye kaam karta hai directly 

        System.out.println(str.substring(2, 5));
    }
}
