public class SuperKeyword {

    /*
     * super keywor is used to refer to immediate parent class object.
     * 
     * - to access parent's properties.
     * - to invoke parent's methods.
     * - to invoke parent's constructor.
     */
    public static void main(String[] args){
        Horse h = new Horse();
        //h.color; ye galat hai kyuki super se hamne keval Animal class ki color property ko call kiya or baki kuch nahi ho rha hai.
        System.out.println(h.color);
    }
}

class Animal{
    String color;
    Animal(){
        System.out.println("Animal is created");
    }
}

class Horse extends Animal{
    Horse(){
        super.color = "Black"; // accessing parent's properties.
        // lekin agar ham nahi bhi lagte to java super keyword ko call karta hai by default.
        // super(); // calling constructor of Animal class .
        System.out.println("Horse is created");
    }
}