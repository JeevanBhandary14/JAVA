import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class client {

    public static void main(String[] args) {
       
        try { 
            DatagramSocket sc=new DatagramSocket();
            InetAddress address= InetAddress.getByName("localhost");
            Scanner scanner=new Scanner(System.in);
            while(true){
                System.out.print("You");
                String msg=scanner.nextLine();
                byte[] sendData=msg.getBytes();

                DatagramPacket sendpacket=new DatagramPacket(sendData, sendData.length,address,8989);
                sc.send(sendpacket); 


                byte[] receiveData=new byte[1024];
                DatagramPacket receivPacket=new DatagramPacket(receiveData, receiveData.length);
                sc.receive(receivPacket);
                String res=new String(receivPacket.getData(),0, receivPacket.getLength());
                System.out.println("Server:"+res);
            } 

            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
