public class Abstraction{

    /*
     * Hiding all the unnecesary details and showing only important parts to the user.
     * abstract : general meaning is (khayal) jo dimag mein hai but physical form mein nahi.
     * generally abstract class idea de deti implementation nahi deti .
     * to make a abstract class : use abstract keyword before class keyword.
     * then class inherit properties of abstract class.
     * 
     * to make abstract methods : use abstract keyword before method keyword.
     * 
     * properties : -
     * Cannot create and instance or object of abstract class.
     * abstract classes can have abstract/non-abstract methods.
     * can also have constructors.
     * 
     * note : 
     * ex ek parent class hai a and then uski dervided class hai b to agar ham b ka object banake bhi call kre to pehle a ka matlab parent class ka constructor hi call hoga hamesha.
     * or aise hi hiearchial way mein constructor call hote hai upar se niche ki direction mein parent to dervided classes.
     */

    public static void main(String[] args){
        Horse h = new Horse();

        h.eat();
        h.walk();
        System.out.println(h.color);
        h.changeColor();
        System.out.println(h.color);

        Chicken c = new Chicken();
        c.eat();
        c.walk();
        c.changeColor();

        // Animal a = new Animal(); yaha pe animal ka instance nahi banega kyuki abstract classes ke instances nahi bana skte hai .
    }
}

abstract class Animal{
    String color;

    Animal() {
        color = "brown";
    }
    void eat(){
        System.out.println("Animal is eating");
    }

    abstract void walk(); // yaha pe idea de dia hai ki jo bhi derived classes hongi animal class se unme ye method banana compulsory hai baki us method ki interpretation derived class ke according apne aap karlo.
}

class Horse extends Animal {
    void changeColor(){
        color = "Dark Brown";
    }
    void walk() {
        System.out.println("Walk on 4 legs");
    }
}

class Chicken extends Animal{
    void changeColor(){
        color = "yellow";
    }
    void walk(){
        System.out.println("Walk on 2 legs");
    }
} 