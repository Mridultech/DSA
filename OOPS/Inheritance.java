public class Inheritance {
    public static void main(String[] args) {
       
        /*
         * Inheritance : Inheritance is a mechanism in which derived or child class inherits properties(attributes) and behaviour(functions) of base or parent class.
         * 
         * //syntax : class derived_class extends base_class{
         * 
         * }
         * jo class property inherit kar rahi hai usse kehte hai derived or child class
         * or jis class se kr rhi hai us class ko kehte hai parent class or base class
         * 
         * ab inhertiace ke types hote hai as follows :
         * single inheritance : ek class ek hi class se inherit kr rahi hai
         * multilevel inheritance : ek class dusri class se inherit kr rahi hai jo kisi or class se inherit kr rahi hai
         * Hieararchical inheritance : ek class se do ya zyada classes inherit kr rahi hai
         * Hybrid inheritance : ek class se do ya zyada classes inherit kr rahi hai jo multilevel inheritance or hieararchical inheritance dono ho
         * Multiple inheritance : ek class do ya zyada classes se inherit kr rahi hai jo java mein nahi hota
         * java mein multiple inheritance nahi hota kyuki agar ek class do class se inherit karegi to agar dono class mein same function hai to ambiguity ho jayegi ki konsi class ka function call kare
         */

        
        
         //Hybrid Inheritance


        // Single-level Inheritance

        Mammal dog1 = new Mammal();
        dog1.walks();

        // Multilevel Inheritance
        
        Dog dog2 = new Dog();
        dog2.eats();

        // Hieararchical Inheritance
        Dog dog3 = new Dog();
        Cat cat1 = new Cat();
        dog3.legs();
        cat1.legs();

         

    }
}

// Multi-level Inheritance

class Animal{ // ye ban gayi hamari parent or base class
    String walk;
    String eat;
    int teeth;
    void walks(){
        System.out.println("Animal walks");
    }
    void eats(){
        System.out.println("Animal eats");
    }
}

// Single-level Inheritance

class Mammal extends Animal{ // ye banai hai derived class from parent class animal
    String legs;
    void legs(){
        System.out.println("Mammal has 4 legs");
    }

}

// Hieararchical Inheritance

class Dog extends Mammal{ // ye ban gayi hamari child ya fir derived class
    String legs;
    void legs(){
        System.out.println("Dog has 4 legs");
    }
}

class Cat extends Mammal{ // ye bhi ban gayi hamari child ya fir derived class
    String legs;
    void legs(){
        System.out.println("Cat has 4 legs");
    }
}