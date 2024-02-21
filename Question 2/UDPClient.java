import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient{
    public static void main(String[] args) {
        try{

            DatagramSocket cs = new DatagramSocket();
            InetAddress address = InetAddress.getByName("localhost");
            int serverPort  = 1111;

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a number");
            String number = sc.nextLine();
            System.out.println("Number taken successfully");
          
            byte[] sendArr = number.getBytes();
            DatagramPacket sendData = new DatagramPacket(sendArr, sendArr.length , address ,serverPort);
            cs.send(sendData);

            //for receiving the data from the server
            byte[] receivPacketArr =  new byte[1024];
            DatagramPacket recivePacket = new DatagramPacket(receivPacketArr , receivPacketArr.length  );
            cs.receive(recivePacket);


            String message = new String(recivePacket.getData() , 0, recivePacket.getLength());
            System.out.println("Received from the server " + message);

            cs.close();

        
        }

        catch(Exception e){
                    e.printStackTrace();
        }
    }
}