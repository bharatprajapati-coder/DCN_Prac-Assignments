import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer{
    public static void main(String[] args) {
        try {
            DatagramSocket ServerSocket = new DatagramSocket( 1111);
            byte[] arr = new byte[1024];
            while (true) {
                DatagramPacket receivPacket = new DatagramPacket(arr, arr.length);
                ServerSocket.receive(receivPacket);
                String message = new String(receivPacket.getData() , 0 , receivPacket.getLength());
                System.out.println("Received from the client" + message);
                
                int number  = Integer.parseInt(message);
                int cube = number *number *number;
                byte[]  DataToSend =  String.valueOf(cube).getBytes();


                DatagramPacket sendPackets = new DatagramPacket(DataToSend,DataToSend.length , receivPacket.getAddress() , receivPacket.getPort() );

                ServerSocket.send(sendPackets);
                System.out.println("Data send successfully" );

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}