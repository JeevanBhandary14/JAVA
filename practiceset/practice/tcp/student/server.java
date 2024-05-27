import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

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

public class server {
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(9299)) { 
            System.out.println("Server started");
            while (true) {
                try (Socket sc = ss.accept();
                     ObjectInputStream dis = new ObjectInputStream(sc.getInputStream());
                     ObjectOutputStream dos = new ObjectOutputStream(sc.getOutputStream())) {

                    System.out.println("Client connected");
                     student s = (student) dis.readObject();
                    
                    s.calculate();
                    dos.writeObject(s);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
