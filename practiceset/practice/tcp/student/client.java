import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.io.*;

class student implements Serializable {
    int studno;
    String sname;
    int marks1;
    int marks2;
    int marks3;
    int total;
    double percentage;

    public void getStudent(int studno, String sname, int marks1, int marks2, int marks3) {
        this.studno = studno;
        this.sname = sname;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
    }

    public void calculate() {
        total = marks1 + marks2 + marks3;
        percentage = ((double) total / 300) * 100;
    }

    public void dispStudent() {
        System.out.println("Student Number: " + studno);
        System.out.println("Student Name: " + sname);
        System.out.println("Marks 1: " + marks1);
        System.out.println("Marks 2: " + marks2);
        System.out.println("Marks 3: " + marks3);
        System.out.println("Total: " + total);
        System.out.println("Percentage: " + percentage);
    }
}

public class client { 
    public static void main(String[] args) {
        try {
            Socket sc = new Socket("localhost", 9299);
            ObjectOutputStream dos = new ObjectOutputStream(sc.getOutputStream());
            ObjectInputStream dis = new ObjectInputStream(sc.getInputStream());

            Scanner scanner = new Scanner(System.in);
            int sno, m1, m2, m3;
            String name;
            System.out.println("Enter sno:");
            sno = scanner.nextInt(); 
            System.out.println("Enter name");
            name = scanner.next();
            System.out.println("Marks m1:");
            m1 = scanner.nextInt();
            System.out.println("Marks m2:");
            m2 = scanner.nextInt();
            System.out.println("Marks m3:");
            m3 = scanner.nextInt();

            student s = new student();
            s.getStudent(sno, name, m1, m2, m3);
            dos.writeObject(s);

            s = (student) dis.readObject();
            
            s.dispStudent();

            // Close resources
            dos.close();
            dis.close();
            sc.close();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
