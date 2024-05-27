import java.sql.*;
import java.util.*;

public class student {
    Connection con;

    public void connectJD() throws Exception {
        try {
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
            System.out.println("Connected to DB");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    public void insertStudent(int rno, String name, int m1, int m2, int m3) throws Exception {
        String sql = "insert into student (rno,name,m1,m2,m3)values(?,?,?,?,?)";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, rno);
            ps.setString(2, name);
            ps.setInt(3, m1);
            ps.setInt(4, m2);
            ps.setInt(5, m3);
            ps.executeUpdate();
            System.out.println("Student inserted");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void displayS() throws Exception {
        ResultSet r;
        String sql = "select * from student";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            r = ps.executeQuery();
            while (r.next()) {
                int id = r.getInt("rno");
                String name = r.getString("name");
                int m1 = r.getInt("m1");
                int m2 = r.getInt("m2");
                int m3 = r.getInt("m3");

                System.out.println("Student Name:" + name + " ID:" + id);
                System.out.println("The marks are M1:" + m1 + " M2:" + m2 + " M3:" + m3);
                System.out.println("Total:" + (m1 + m2 + m3) + "And average is:" + ((m1 + m2 + m3) / 3));

                float avg = (m1 + m2 + m3) / 3;
                if (avg > 75) {
                    System.out.println("Grade A");
                } else if (avg <= 75 && avg >= 50) {
                    System.out.println("Grade B");
                } else {
                    System.out.println("Grade C");
                }

            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    public static void main(String[] args) {
        student s = new student();
        try {
            
            s.connectJD();
        } catch (Exception e) {
            // TODO: handle exception
        System.out.println(e);
        }
        int rno, m1, m2, m3;
        String name;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the student regno:");
        rno = sc.nextInt();
        System.out.println("Enter the student Name:");
        name = sc.next();
        System.out.println("Enter the student m1:");
        m1 = sc.nextInt();
        System.out.println("Enter the student m2:");
        m2 = sc.nextInt();
        System.out.println("Enter the student m3:");
        m3 = sc.nextInt();

        try {
            s.insertStudent(rno, name, m1, m2, m3);
            s.displayS();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
