public class Polymorphism {
    /*
     * Polymorphism is formed by two words "poly" and "morphs".
     * Poly means many and morphs means forms.
     * General meaning of polymorphism is the ability to appear in many forms.
     * or to acheive same thing through multiple different forms.
     * 
     * ex : creating constructor with different parameters is polymorphism.
     * 
     * In Java, polymorphism is mainly divided into two types:
     * 
     * 1. Compile time polymorphism also known as static polymorphism. : Method overloading
     * 
     * mehtod overloading : just like constructor overloading same naam ke multiple methods banadena with diffrent parameters or of diffrent return types
     * 
     * 2. Run time polymorphism also known as dynamic polymorphism. : Method overriding
     * 
     * mehtod overriding : jaisa iska naam hai ki jab ham same function banaye dono base class and derived class mein to dono ka same function individually jaise designed hai waise hi chalega. 
     * 
     * lekin manlo ki hamne parent class ke variable mein derived class ka object store kra or then us object se call kra same naam ke function ko to derived class ka function kaam krega.
     */
    public static void main(String[] args) {
       Operations op = new Operations();
       int a = op.sum(5,5);
       float c = op.sum((float) 6, (float) 5);
       int b = op.sum(5,5,6);
       System.out.println(a);
       System.out.println(b);
       System.out.println(c);
    
       LivingBeings lb = new LivingBeings();
       Humans h = new Humans();

    //    System.out.println(lb.eats()); println jo hai wo void methods ko nahi accept karta
    //    System.out.println(h.eats());
        lb.eats();
        h.eats();
    }
}

// Method overloading

class Operations{

    int sum(int a , int b){
        return a + b;
    }

    float sum(float a , float b){
        return a + b;
    }

    int sum(int a , int b , int c){
        return a + b + c;
    }

}

class LivingBeings{
    void eats(){
        System.out.println("all living being eats !");
    }
}

class Humans extends LivingBeings{
    void eats(){
        System.out.println("all Humans being eats !");
    }
}