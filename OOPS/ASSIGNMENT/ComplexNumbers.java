public class ComplexNumbers{

    public static class Complex{
        int real;
        int imaginary;

        void complex(int r , int i){
            this.real = r;
            this.imaginary = i;
            System.out.println("Complex number is: " + this.real + " + " + this.imaginary + "i");
        }

        void sum(complex r , int i){
            Complex n1 = 
            int sumImaginary = this.imaginary + i;
            System.out.println("Sum of complex numbers is: " + sumReal + " + " + sumImaginary + "i");
        }
    }
    public static void main(String[] args){
        Complex num = new Complex();
        num.complex(2, 3);
        num.sum(4, 5);
    }
}