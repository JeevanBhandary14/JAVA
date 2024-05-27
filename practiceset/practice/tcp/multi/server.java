import java.io.*;
import java.net.*;
import java.util.*;



public class server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8989);
            System.out.println("Server is running");
            Socket sc = ss.accept();
            System.out.println("Client connected");
            DataInputStream dis=new DataInputStream(sc.getInputStream());
            DataOutputStream dos=new DataOutputStream(sc.getOutputStream());
            Scanner scanner=new Scanner(System.in);
            while (true) {
                System.out.println("Client:"+dis.readUTF());
                System.out.println("Server:");
                String msg=scanner.nextLine();
                dos.writeUTF(msg);
                
            }
            

        } catch (Exception e) {
            e.printStackTrace(); // Print the exception stack trace for debugging
        }
    }
}