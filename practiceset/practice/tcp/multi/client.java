
import java.io.*;
import java.net.*;
import java.util.*;

class clienthread extends Thread{
    public void run(){
        try {
            Socket sc=new Socket("localhost",8989);
            Scanner scanner=new Scanner(System.in);
            
            DataInputStream dis=new DataInputStream(sc.getInputStream());
            DataOutputStream dos=new DataOutputStream(sc.getOutputStream());

            while (true) {
                System.out.println("Client:");
                String msg=scanner.nextLine();
                dos.writeUTF(msg);

                String recived=dis.readUTF();
                System.out.println("server:"+recived);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}

public class client {
    public static void main(String[] args) {
       clienthread t1=new clienthread();
       t1.start();

    }
}
 