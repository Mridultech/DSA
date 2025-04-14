public class JavaBasics {
    public static void main(String args[]) {
        System.out.print("Hello World\n");
        System.out.print("Hello World\n");


        // Data Types(Primitive)
        byte b = 8 ;
        System.out.println(b);
        char ch = 'a';
        System.out.println(ch);
        boolean var = true;
        System.out.println(var);
        float price = 10.5f;
        System.out.println(price);
        int a = 10;
        System.out.println(a);
        long l = 100000000000000000L;
        System.out.println(l);
        double d = 10.5;
        System.out.println(d);
        short s = 10;
        System.out.println(s);
        String str = "Hello World";
        System.out.println(str);

        //Size of data types
        //byte - 1 byte[8 bits][-128 to 127]
        //short - 2 bytes[16 bits][-32768 to 32767]
        //int - 4 bytes[32 bits][-2^31 to 2^31-1]
        //long - 8 bytes[64 bits][-2^63 to 2^63-1]
        //float - 4 bytes[32 bits][7 decimal digits]
        //double - 8 bytes[64 bits][15 decimal digits]
        //char - 2 bytes[16 bits][0 to 65535]
        //boolean - 1 byte[true or false]The primitive boolean type is often implemented using 1 bit for storage, but in practice, it is usually stored in a byte (8 bits) due to computer architecture constraints.
/*The Boolean wrapper class in Java also occupies more space than primitive types due to additional object overhead.*/

    }
}