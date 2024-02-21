import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            DatagramSocket cs = new DatagramSocket();
            InetAddress hostname =  InetAddress.getByName("localhost");
            int port = 1111;

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the Sentence");
            String sentence = sc.nextLine();
             
            byte[] arrToSend = String.valueOf(sentence).getBytes();
            DatagramPacket sendPacket =new DatagramPacket(arrToSend , arrToSend.length , hostname , port);
            cs.send(sendPacket);
             
        
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            cs.receive(receivePacket);

            String response = new String(receivePacket.getData() , 0 ,receivePacket.getLength() );
                System.out.println("Message from the Server" + response);        
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
