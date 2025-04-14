public class BitwiseOperators {
    public static void main(String[] args) {
        /*
         * Bitwise Operators in Java : used to perform operations on bits in computers
         * 
         * 1. Bitwise AND Operator (&) : keval all true pe true nahi to false
         * 
         * symbol : & 
         * 0 & 0 = 0
         * 0 & 1 = 0
         * 1 & 0 = 0
         * 1 & 1 = 1
         * 
         * ex : 5 & 6 = 4
         * 5 = 101
         * 6 = 110 we have done & operation on 5 and 6
         * 4 = 100
         * 
         * 2. Bitwise OR Operator (|) keval all false pe false nahi to true
         * 
         * symbol : |(Pipe)
         * 
         * 0 | 0 = 0
         * 0 | 1 = 1
         * 1 | 0 = 1
         * 1 | 1 = 1
         * 
         * ex : 5 | 6 = 7
         * 5 = 101
         * 6 = 110 we have done | operation on 5 and 6
         * 7 = 111
         * 
         * 3. Bitwise XOR Operator (^) : same hone pe false nahi to true
         * KAISE YAAD RKHE : same paper hona matlab cheating to milega 0 nahi to 1
         * symbol : ^
         * 
         * 0 ^ 0 = 0
         * 0 ^ 1 = 1
         * 1 ^ 0 = 1
         * 1 ^ 1 = 0
         * 
         * ex : 5 ^ 6 = 3
         * 5 = 101
         * 6 = 110 we have done ^ operation on 5 and 6
         * 3 = 011
         * 
         * 
         * 4. Bitwise One's Complement or simply Binary Complement or Not Operator (~) : diye gaye ka just ulta kar dega
         * 
         * symbol : ~(tilde)
         * 
         * ~0 = 1
         * ~1 = 0
         * 
         * ex : ~5 = -6
         * 5 = 101
         * ~5 = 010 = 6 // hame lag rha hai 2 aana chaiye tha lekin -6 kaise aaya ?
         * -6
         * 
         * let's see how -6 came
         * 
         * concept of msb and lsb : msb matalb most significant bit (i.e leftmost bit) and lsb matalb least significant bit (i.e rightmost bit)
         * msb decides the sign of the number during 1's complement and 2's complement
         * 
         * and 5 jo hai wo simple keval 101 represent nahi ho rha hai balki 32 bit me represent ho rha hai or uske piche bahut 0 hai 
         * 5 = 00000000 00000000 00000000 00000101
         * 
         * ~5 = 11111111 11111111 11111111 11111010 // 1's complement kara to msb 1 ho gaya to ye negative number hai jo ki -6 hai
         * 
         * ab ~5 jo hame mila ye iski real value nahi hai lekin hame nikalni padegi 
         * 
         * ab hame kisi negative number ki real value nikalni hai to uske liye 2's complement ka concept use hota hai
         * 
         * ab ~5 ko 2's complement me convert karte hai jisse hame ~5 ka real value mile
         * 
         * 1's complement me jo number aaya tha usme 1 add karna hai
         * 
         * ~5 ka 1's complement = 00000000 00000000 00000000 00000101 // ye hame number ka magnitude batata hai
         * ~5 ka 2's complement = ~5 ka 1's complement + 1 =  00000000 00000000 00000000 00000110 // ye hame number ka real value batata hai
         * ab observe kare to ~5 ka 2's complement 6 hai jo ki 5 ka ulta hai
         * hence ~5 = -6
         * 
         * 5. Binary Left Shift Operator (<<)
         * 
         * rules : 
         * a << b(2) : iska mtalb a jo binary number hai usme msb ki side se pehle 2 bit hataiye and then pura number left shift kare (har ek binary ko ek place left khiskaye) then lsb ke side jo 2 bit khali hai unpe 0 add kare
         * 
         * ex : 5 << 2 = 20
         * 5 = 000101
         * 5 << 2 = 10100 = 20
         * 
         * formula for left shift 
         * a << b = a * 2^b
         * 
         * 
         * 
         * 6. Right Shift Operator (>>)
         * 
         * RULES : 
         * a >> b(2) : iska mtalb a jo binary number hai usme lsb ki side se pehle 2 bit hataiye and then pura number right shift kare (har ek binary ko ek place right khiskaye) then msb ke side jo 2 bit khali hai unpe 0 add kare
         * a >> b : a ko right shift karo by b
         * ex : 6 >> 1 = 3
         * 
         * 6 : 000110
         * 6 >> 1 : 000011 = 3
         * 
         * forula for right shift
         * a >> b = a / 2^b
         */

        System.out.println(5 & 6); // 4
        System.out.println(5 | 6); // 7
        System.out.println(5 ^ 6); // 3
        System.out.println(~5); // -6
        System.out.println(5 << 2); // 20
        System.out.println(6 >> 1); // 3

    }   
}
