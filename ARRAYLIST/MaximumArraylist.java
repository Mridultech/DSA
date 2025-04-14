import java.util.ArrayList;
public class MaximumArraylist {
    public static void main(String[] args){
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6); // ans is 6.

        for(int i = 0 ; i < numbers.size() ; i++){
            int num = numbers.get(i);
            if(num > max){
                max = num;
            }
            else{
                continue;
            }
        }
        System.out.println("Maxiumum value is : " + max);
    }
}
