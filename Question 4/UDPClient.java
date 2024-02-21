import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient{
    public static void main(String[] args) {
        try{
            DatagramSocket ds = new DatagramSocket();
            InetAddress hostName = InetAddress.getByName("localhost");
            int portNo = 1111;

                Scanner sc  = new Scanner(System.in);
                System.out.println("Enter  comma(,) seperated numbers");
                String dataSet = sc.nextLine();

            byte[] dataToSend = dataSet.getBytes();

            DatagramPacket sendData = new DatagramPacket(dataToSend ,dataSet.length() , hostName , portNo);
            ds.send(sendData);

            
            byte[] arrForReceive  = new byte[1024];
            DatagramPacket receivePackets = new DatagramPacket(arrForReceive, arrForReceive.length);
            ds.receive(receivePackets);

            String Quartiles = new String(receivePackets.getData() ,  0 , receivePackets.getLength());
            System.out.println("Received from the Server " + Quartiles);

        }
        catch(Exception e){

        }
    }
}