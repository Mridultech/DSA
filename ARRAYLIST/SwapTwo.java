import java.util.*;
public class SwapTwo {
    public static void main(String[] args) {
        //Problem statement : isme hame ek array list di gayi hai or koi bhi 2 index values di gayi hai jinhe swap karna hai.
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        System.out.println("Array list (orignal) before swapping " + numbers);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first and second index :");
        int firstIndex = sc.nextInt();
        int secondIndex = sc.nextInt();
        int temp = numbers.get(firstIndex);
        numbers.set(firstIndex, numbers.get(secondIndex));
        numbers.set(secondIndex,temp);
        System.out.println("Array list (orignal) after swapping " + numbers);
    }
}
