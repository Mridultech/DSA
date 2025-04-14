public class Basics{

    /*
     * note : Important for better understanding of java and sometimes questions can be asked from this portion too in interviews.
     * 
     * Basics of oops : 
     * 
     * class : group of collection of objects 
     * class : blueprint of an object
     * 
     * class ke pass 2 chize hai  
     * 1. attributes (properties) 
     * 2. functions(behaviour)
     * 
     * ex : class pen 
     * attributes - color
     * functions - changecolor()
     * 
     * by default class ka naam Pascal case mein likhte hai .
     * 
     * note : jo bhi ham classes bnaayenge unhe public class ke niche likhenge to acha hoga or usse unke objects bnanae mein dikkat nahi hogi .
     * 
     * note : by convenction main function public and static dono hona zaruri hai .
     * 
     * //access modifiers/Specifiers
     * 
     * ye decide karte hai level of access external systems may have on given class 
     * 
     * hamare pass chaar types ke access modifiers hote hai
     * 
     * 1. public : sab kuch access kr sakte hai
     * 2. private : sirf class ke andar access kr sakte hai
     * 3. protected : class ke andar and subclass ke andar access kr sakte hai
     * 4. default : sirf usi package ke andar access kr sakte hai
     * 
     * Access Modifier : |   within class  |  within package | outside package by subclass only  |  outside package
     * -----------------------------------------------------------------------------------------------------------
     * private           |      Y          |   N             |      N                            |   N  
     * default           |      Y          |   Y             |      N                            |   N
     * protected         |      Y          |   Y             |      Y                            |   N
     * public            |      Y          |   Y             |      Y                            |   Y
     * 
     * 
     * Getters and Setters 
     * 
     * manlo koi hamne class bnaayi hai aur usme kuch properties hai jo private hai to usko access krne ke liye hame getters and setters bnaane hote hai
     * geter : property ko access krke value return ke liye
     * setter : property ko set krne ke liye
     * 
     * this keyword : manlo ek function hai jisme hame class ke object ka reference lena hai lekin hamne object ko class ke parameters mein nahi liya to this keyword us object ke reference ki tarah kaam karega.
     * 
     * contructor : special method which is invoked automatically when object is created
     * 
     * properties of constructor :
     * 1. name of constructor is same as name of class
     * 2. constructor does not have return type(not even void)
     * 3. constructor is invoked automatically when object is created
     * 4 contructors are only called once ,at object creation time
     * 5. memory allocation is done by constructor
     * 
     * ex : Pen p1 = new Pen(); constructor call ho gaya pehli or akhri bar
     * p1.pen(); // constructor call nahi hoga ab kyuki ek baar ho gaya hai to ye galat hai 
     * 
     * java mein koi bhi class private ya protected nahi ho skti kyuki wo unusable classes ban jayengi kyuki unka objects to ban hi nahi skte 
     * 
     * objects          |  private |  default  |  protected  |   public
     * -----------------------------------------------------------------------------------------------------------
     * Class            |  N       |  Y        |  N          |   Y
     * Nested class     |  Y       |  Y        |  Y          |   Y
     * Constructor      |  Y       |  Y        |  Y          |   Y
     * Methods          |  Y       |  Y        |  Y          |   Y
     * Field            |  Y       |  Y        |  Y          |   Y
     * to fir private and protected use kaha hote hai ?
     * 
     * note : ham derived class ke object ka reference parent class ke object se de sakte hai 
     * 
     * ex : class Veichle{}
     * class Car extends Veichle{}
     * 
     * Veichle v1 = new Car(); // valid
     * Car c1 = new Veichle(); // invalid
     * 
     * why?
     * kyuki jab ham veichle ka variable car ke object ko point kr rahe hai to car ke object ke pass veichle ke properties bhi hongi lekin veichle ke object ke pass car ke properties nahi hongi
     * lekin agar ham car ke variable ko veichle ka object assign kare to car ke properties veichle ke object ke pass nahi hongi to ye galat hoga or runtime error dega
     * 
     * compontents of oops :
     * 1. Inheritance
     * 2. Polymorphism
     * 3. Abstraction
     * 4. Encapsulation
     * 
     * aggregation : jab ek object dusre object ko contain krta hai to usko aggregation kehte hai
     * 
     * ex : class Engine{}
     * class Car{
     * Engine e = new Engine();
     * }
     * ek tarike se guth bana lena 
     */


     
    public static void main(String[] args){
        Pen pen1 = new Pen();// pen1 ek object hai pen class ka
        pen1.setColor("red");// pen1 ke color ko red kr diya & . operator se object ke properties ko access kr sakte hai
        pen1.setTip(10);// pen1 ke tip ko 10 kr diya


        /*  System.out.println(pen1.color); pen1 ke color ko print kiya*/
        /*  System.out.println(pen1.tip); pen1 ke tip ko print kiya ( ab inhe direct color or tip nahi le skte kyuki variables priavte kr diye hai )*/

        System.out.println(pen1.getColor());// pen1 ke color ko print kiya
        System.out.println(pen1.getTip());// pen1 ke tip ko print kiya 

        BankAccount account = new BankAccount();
        account.username = "John";// username ko set kiya
        // account.password = "1234"; // password ko set kiya but error aayega kyuki password private hai
        account.setPassword("1234");// password ko set kiya

        Student s1 = new Student("Mridul"/*aise intialization bhi kr skte hai constructor mein */);// constructor call hoga
    }
}

class Pen{
    // ye dono pen ki properties hai 
    private String color;
    private int tip; 

    //getters 

    String getColor(){
        return this.color; // yaha pe this ki jagah wo object lelega jisne getcolor() ko call kiya hai
    }

    int getTip(){
        return this.tip;
    }

    // ab isme functions bnaayenge 
    void setColor(String newColor){
        this.color = newColor;
    }
    void setTip(int newTip){
        this.tip = newTip;
    }
 }

class BankAccount {
    public String username;// username ko public kr diya
    private String password;// password ko private kr diya
    public void setPassword(String newPassword){
        password = newPassword;
    }
}

class Student {
    String name ;
    int roll ;

    // constructor
    Student(String name){
        this.name = name;
        System.out.println("Constructor called");
    }
}