public class CommonComplexities {
    /*
     * O(1) - Constant Time - No matter how many elements we're working with, the algorithm/operation will always take the same amount of time.
     * O(log N) - Logarithmic Time - You have this when the algorithm/operation reduces the size of the input data set roughly in half each time through.
     * O(N) - Linear Time - Iterating through all elements in a collection.
     * O(N log N) - Linearithmic Time - You have this when the algorithm/operation is the result of running O(log N) operations N times.
     * O(N^2) - Quadratic Time - Every element in a collection has to be compared to every other element.
     * O(2^N) - Exponential Time - If you add a single element to a collection, the processing power required doubles. 
     * 
     * 
     * //Space Complexity : input space(yeh to sab jagah hoti hai to ise pucha nahi jata interviews mein jada) + auxillary space(jab ham temporary variables banate hai to wo jo occupy krte hai wo space)
     * 
     * ex : merge sort : n input space + n auxillary space : space complexity = O(n)
     * quick sort : n input space + logn auxillary space : space complexity = O(logn)(for average case) , for worst case :(n^2)
     * 
     */
    public static void main(String[] args){
        
        //Simple loop

        // for(int i = 0 ; i < n ; i++){
        //     //constant work
        //     //ex sout(i)
        //     //ex sout("hello")
        //     // yaha pe kitni bhi line likho O(2) = O(1) hi hoga because we avoid constant complexities
        // is loop mein jo andr kaam ho rha hai uski time complexity ko agar k constant man lete hai or loop run karega n times to k kaam n baar hoga to time complexity of this simple loop becomes O(nxk) = O(n).
        // 
        // }

        //Nested loop 1 

        // for(int i = 0 ; i < n ; i++){
        //     for(int j = i+1 ; j < n ; j++){
        //         //constant work
        //         //ex sout(i)
        //         //ex sout("hello")
        //         // yaha pe kitni bhi line likho O(2) = O(1) hi hoga because we avoid constant complexities
        //     }
        //  dry run: 
        //  n = 3
        //  i = 0 , j = 0 for i = 0 , loop is running 2 times i.e n-1 times
        //  i = 0 , j = 1 for i = 0 , loop is running 1 times i.e n-2 times
        //  i = 1 , j = 0
        //  
        //  ab yaha dekha jaye to for sum of complexities : n-1 + n-2 + n-3 + n-4 + .... + 1 = n(n-1)/2 = O(n^2)
        //  isliye is loop ka time complexity O(n^2) hoga.
        // }

        //Nested loop 2
        
        // for(int i = 0 ; i < n ; i++){
        //     for(int j = 0 ; j < i ; j++){
        //         //constant work
        //         //ex sout(i)
        //         }
        // }
        // dry run:
        // n = 3
        // i = 0 , j = 0 for i = 0 , loop is running 0 times
        // i = 1 , j = 0 for i = 1 , loop is running 1 times
        // i = 2 , j = 0,1 for i = 2 , loop is running 2 times
        // ab yaha dekha jaye to for sum of complexities : 0 + 1 + 2 + 3 + .... + n-1 = n(n-1)/2 = O(n^2)
        // isliye is loop ka time complexity O(n^2) hoga.

        //Nested loop 3
         





    }
}
