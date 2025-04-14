public class Constructors {

    /*
     * types of constructors
     * 1. Non-Parameterized constructor
     *  constructor without any parameters 
     *  example : 
     * public Constructors(){
     * }
     * 
     * 
     * 2. Parameterized constructor
     * 
     * constructor with parameters
     * 
     * example :
     * public Constructors(String name){
     * }
     * 
     * 3. Copy constructor
     *  yeh c++ mein by default hota hai but java mein nahi hota hai.
     * 
     * note : ham soche ki first line i.e Student s1 = new Student(); to bina constructor ke chal rhi thi to uske corresponding non-parameterized constructor ko hatade to kaam chalega lekin aisa nahi hoga 
     * call mein constructor jabhi banega jab class ki definition mein constructors define nah ho ek bhi nahi to wo error dega. 
     * 
     * constructor overloading : ye ek polymorphism ka ex bhi ho skta hai polymorphism matalb multiple functions with same name .
     * bahut sare constructors bana dena and then class ki call ke according decide hona ki konsa constructor initalize or work karega .
     * ex : niche jo kara hai wo constructor overloading hi hai.
     * 
     * 
     * copy constructor : jab ham ek object ki sari properties ko dusre object mein copy karte hain to usko copy constructor kehte hain.
     * 
     * problem : jab bhi ham ek copy constructor banate hai to usme jo properties copy kr rhe hai wo khud copy nahi hoti rather naye object ko bas purane ka reference mil jata hai to agar purane mein change hoga to nayi mein bhi ho jayega isiliye 
     * hame shallow copy and deep copy smjhna zaruri hai 
     * 
     */

   
     
    public static void main(String[] args){

        Student s1 = new Student(); // Non-Parameterized constructor
        s1.name = "Rahul";
        s1.Roll = 101;
        s1.marks = 10;

        Student s2 = new Student("Rahul"); // Parameterized constructor
        Student s3 = new Student(101); // Parameterized constructor

        Student s4 = new Student(s1); // Copy constructor

            System.out.println(s4.marks);
        
    }

    
    }
    class Student {
        String name ;
        int Roll;
        int marks;

        Student(Student s1){// constructor ka object usi ke constructor mein as object pass karna.
            this.name = s1.name;
            this.Roll = s1.Roll;
            this.marks = s1.marks;
            System.out.println("Copy constructor");
        }
        Student(){
            System.out.println("Non-Parameterized constructor");
            this.marks = 10; 
        }

        Student(String name){
            this.name = name;
            System.out.println("Parameterized constructor");
            this.marks = 10;
        }

        Student(int Roll){
            this.Roll = Roll;
            System.out.println("Parameterized constructor");
            this.marks = 10;

        }

}
