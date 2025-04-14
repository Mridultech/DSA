import java.util.*;
public class DuplicateValues {

    public static boolean isDuplicate(int numbers[]){
        boolean flag = false;
        for(int num : numbers){
            for(int j = num+1 ; j < numbers.length ; j++){
                if(num == numbers[j]){
                    flag = true;
                    num = numbers[j];
                    break;
                }
            }

        }
        System.out.println("Duplicate value is : " + num);
        return flag;
    }

    public static void main(String[] args) {
        
    Scanner sc = new Scanner(System.in);
        
    System.out.println("Enter the size of array :");
    int size = sc.nextInt();
    int numbers[] = new int[size];

    System.out.println("Enter the elements within the array:");
    for(int i = 0 ; i < numbers.length ; i++){
        numbers[i] = sc.nextInt();
    }
    if(isDuplicate(numbers) == true){
        System.out.println("Duplicate values are present in the array");
    }else{  
        System.out.println("No duplicate values are present in the array");
    }
    sc.close();
    }

    }

