public class ShallowAndDeepCopy {
    public static void main(String[] args){
        System.out.println("Program to illustrate concept of shallow and deep copy");

        Student s1 = new Student();
        s1.name = "mridul";
        s1.marks[0] = 100;
        s1.marks[1] = 100;
    }
}

class Student{
    String name;
    int marks[];

    Student(){
        System.out.println("Non-parameterized constructor!");
    }

    Student(Student s1){
        this.name = s1.name;
        System.out.println("Enter marks :");
        for(int i =  0 ; i < marks.length ; i++){
        this.marks[i] = s1.marks[i];
        }
    }
}
