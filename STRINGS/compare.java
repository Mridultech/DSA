public class compare {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = "World";
        String s4 = new String("Hello");
        
        if(s1 == s2) {
            System.out.println("s1 and s2 are equal");
        } else {
            System.out.println("s1 and s2 are not equal");
        }

        if(s1 == s4) {
            System.out.println("s1 and s4 are equal");
        } else {
            System.out.println("s1 and s4 are not equal");
        }

        //note : s1 ans s2 are equal because they are pointing to the same memory location
        /*jab bhi ham normal tarike se string banate hai to wo same location ko refer kr rhe hai 
        lekin jab ham new se string banate hai to dono strings alag alag location pe ban rhi hai 
        or == operator location ke base pe strings ko compare krta hai isliye s1 and s4 are not equal
        is concept ko ham concept of interning kehte hai

        agar ham string ko compare krna chahte hai to .equals() method ka use krna chahiye
        */ 

        if(s1.equals(s4)) {
            System.out.println("s1 and s4 are equal");
        } else {
            System.out.println("s1 and s4 are not equal");
        }
}
}
