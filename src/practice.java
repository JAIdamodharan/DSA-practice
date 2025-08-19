import java.io.*;
import java.util.*;
import java.lang.*;

class Student{
    private String name;
    private int age;
    private double cgpa;

    public Student(String a, int b, double c){
        this.name = a;
        this.age = b;
        this.cgpa = c;
    }

    public Student() {

    }

    public String getName(){
        return name;
    }

    public void setName(String a){
        this.name = a;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age_set){
        this.age = age_set;
    }

    public double getCgpa(){
        return cgpa;
    }

    public void setCgpa(float c){
        this.cgpa = c;
    }
}
public class practice {
    public static void main (String[] args) throws IOException {
//        int[] arr = new int[5];
//        for(int i=0; i<arr.length; i++){
//          arr[i] = i;
//        }
//        String[] arr_fruits = {"Apple", "Banana", "Orange"};
//        for(String name: arr_fruits){
//            System.out.println(name.contains("na"));
//        }
//        for(int num : arr){
//            System.out.print(arr[num] + " ");
//        }
//        int [][] matrix = {{1,2,3},{4,5,6}};
//        System.out.println(matrix[0][1]);

//        Student s1 = new Student("Jaishree", 22, 9.5);
//        System.out.println(s1.getAge());
//        System.out.println(s1.getCgpa());
//        System.out.println(s1.getName());
//
//        Student s2 = new Student();

        //Loop Practice:
        int n=5;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }


    }
}
