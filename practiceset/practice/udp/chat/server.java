import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class server {
    public static void main(String[] args) {
        try {
            DatagramSocket sc=new DatagramSocket(8989);
            InetAddress address=null;
            int port=0;
            Scanner scanner=new Scanner(System.in) ;
            
            while(true){
                    byte[] receivemsg=new byte[1024];
                    DatagramPacket receivPacket=new DatagramPacket(receivemsg,receivemsg.length);
                    sc.receive(receivPacket);
                    address=receivPacket.getAddress();
                    port=receivPacket.getPort();
                    String msg=new String(receivPacket.getData(),0,receivPacket.getLength());
                    System.out.println("Client:"+msg);

                    System.out.print("Server:");
                    String smsg=scanner.nextLine();
                    byte[] sendMsg=new byte[1024];
                    sendMsg=smsg.getBytes();
                    DatagramPacket sendPacket=new DatagramPacket(sendMsg,sendMsg.length,address, port);
                    sc.send(sendPacket);

                    
                }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
