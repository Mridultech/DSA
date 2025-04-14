public class Interface {

    /*
     * Interface is blueprint of class
     * 
     * ex : interface : car [ wheels ,speed , engine]
     * class : maruti 800[blueprint]
     * objects different models or variants of maruti 800
     * java mein ham multiple inheritance ko interfaces ke madad se karte hai.
     * interfaces is also used to achieve total abstraction.
     * 
     * total abstraction : jisme non-abstract methods ya functions na ho 
     * 
     * interface ko ham interface keyword se define karte hai 
     * 
     * or interface ko inherit karane ke liye implement keyword ka use hota hai.
     * 
     * properties of interface: 
     * interface is used to achieve total abstraction.
     * all methods public , abstract & without implementation(total abstract)
     * variables in interface are final(value jaisi hai waisi hi rhegi) , public(kahi se bhi access kare jaa skte hai) and static(puri class ke liye ek baar hi define honge).
     * 
     * note : interfaces ki naming convenction : pascal naming convention hai 
     * 
     * 
     */
    public static void main(String[] args){

        // Total Abstraction

        Queen q = new Queen();
        q.moves(); // yaha pe abstraction hui kyuki parent interface ChessPlayer ke through Queen class ke object ne to keval idea diya baki sabki individual implementation hai.

        //Multiple Inheritance using Interface

        Bear b = new Bear();
        b.eatGrass();
        b.eatMeat();
        b.walk();
    }
    
}

// Total Abstraction

interface ChessPlayer {
    void moves();
}

class Queen implements ChessPlayer {
    public void moves(){ // by default ye method default type ka ho jata isiliye public likha hai
    System.out.println("up , down ,left , right ,diagonal(in all directions)");
    }
}

class Rook implements ChessPlayer {
    public void moves(){ // by default ye method default type ka ho jata isiliye public likha hai
    System.out.println("up , down ,left , right");
    }
}

class King implements ChessPlayer {
    public void moves(){ // by default ye method default type ka ho jata isiliye public likha hai
    System.out.println("up , down ,left , right ,diagonal(in all directions) by 1 places.");
    }
}

// Multiple Inheritance using Interface

interface Herbivore { 
    void eatGrass();
}

interface Carnivore {
    void eatMeat();
}

class Bear implements Herbivore,Carnivore {
    public void eatGrass(){ // dhyan rkhana by default interface mein jo methods hai wo public define ho rkhe hai or agar ye inherit mein methods ke piche public nahi lagayenge to access modifiers ka clash hoga or compilation error de dega.
        System.out.println("Bear eats grass");
    }
    public void eatMeat(){
        System.out.println("Bear eats meat");
    }
    void walk(){
        System.out.println("Bear walks");
    }
}