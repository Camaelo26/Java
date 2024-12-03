//Macarthur Diby 
//Lab Lab23B
//program that will use the Insertion Sort technique to sort an array for students Datas





import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;



class Student {

    private String first_name;
    private String last_name;
    private double grade_points_average;

    public Student(String first_name,String last_name,double grade_points_average) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.grade_points_average = grade_points_average;
    }

    public double getpoints() {
        return grade_points_average;
    }

    @Override
    public String toString() {
        return  "FIRST NAME:" + first_name + "\nLAST NAME :" + last_name + '\n' + "GPA: " + grade_points_average + ".\n";
    }
}


class Main{

    public static void insertionSort(Student datas[]) {
        int n = datas.length;
        for (int i = 1; i < n; ++i) {
            Student key = datas[i];
            int j = i - 1;
            
            while (j >= 0 && datas[j].getpoints() > key.getpoints()) {
                datas[j + 1] = datas[j];
                j = j - 1;
            }
            datas[j + 1] = key;

        }
    }

    public static void main(String[] args) {

        String readfile = "Lab23B.txt";
        try {
            Scanner fileinput= new Scanner(new File(readfile));
            Student[] datas = new Student[12];
            int count=0;
            while (count<datas.length && fileinput.hasNext()){
                String first_name = fileinput.next();
                String last_name = fileinput.next();
                double grade_points_average = fileinput.nextDouble();
                datas[count++] = new Student(first_name,last_name,grade_points_average);
            }
            fileinput.close();

            insertionSort(datas);
            for(Student data : datas) System.out.println(data);


        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND.");
        }

    }
}