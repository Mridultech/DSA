public class StaticKeyword {

    /*
     * general meaning of static : constant over time
     * 
     * static keyword in java is used to share the same variable or method of a given class.
     * 
     * ex : manlo ek class hai student to uske jitne bhi object banenge unki sari properties alag hongi name rollno marks etc pr sabka school property to same hogi to use sabme same rkhne ke liye ham static keyword ka use krte hai.
     * 
     * ham kin chizo ko static bana skte hai 
     * 
     * properties : variables of any types
     * 
     * functions
     * 
     * blocks
     * 
     * ex of blocks : 
     * 
     * main(){
     * this is a block 
     * {
     * int a = b + c;
     * syso(a);
     * }
     * till here
     * }
     * 
     * nested class
     * 
     * class A{
     * class B {
     * }
     * class C{
     * }
     * }
     * 
     * main function static kyu hota hai ? 
     * kyuki ham chahte hai ki ek class mein keval ek hi main function ho.
     * 
     * static variables ko directly class se access kiya jaa skta hai 
     */
    public static void main(String[] args){
        Student s1 = new Student();
        s1.schoolName = "XYZ School";
        System.out.println(s1.schoolName);

        Student s2 = new Student();
        System.out.println(s2.schoolName); // yaha pe bina s2 ka school name define kare hue bhi print ho raha hai kyuki schoolName static hai jab ek baar define ho jata hai to sabke liye wohi rehta hai
    }
}

class Student {
    static int returnPercentage(int math, int phy , int chem){
        return(math + phy + chem)/3;
    }

    String name;
    int roll;

    static String schoolName;// schoolName is a static property
    //static object memory mein keval ek baar hi banti hai. : aisa kyu kyuki jo chiz hamne static banadi use hame constant rkhana hai sabhi instances ke liye ab usko alag memory spaces dke kya fayda to uski memory ek hi bar allocate hoti hai heap mein then sare instances mein vo variable us ek single memory ki taraf hi point karenge.

    void setName(String name){
        this.name = name;
    }
    String getName(){
        return this.name;
    }
}
