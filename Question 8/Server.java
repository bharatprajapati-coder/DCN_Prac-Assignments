import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server{
    public static void main(String[] args) {
        try {
            DatagramSocket ss = new DatagramSocket(1111);
           byte[] arr = new byte[1024];

           while(true){

                DatagramPacket receivedPacket = new DatagramPacket(arr , arr.length);
                ss.receive(receivedPacket);

                String message = new String(receivedPacket.getData() ,   0 , receivedPacket.getLength());

                String str1 = convertToToggle(message);
                byte[] dataToSend  = String.valueOf(str1).getBytes();
                DatagramPacket sendPacket = new DatagramPacket(dataToSend , dataToSend.length, receivedPacket.getAddress() , receivedPacket.getPort());
            ss.send(sendPacket);


            }
        } catch (Exception e) {
            e.printStackTrace();
            
            // TODO: handle exception
        }
    }
    public static String convertToToggle(String sentence) {
        StringBuilder toggleCase = new StringBuilder();
        String[] words = sentence.split("\\s+");
        
        
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                if (Character.isUpperCase(c)) {
                    toggleCase.append(Character.toLowerCase(c));
                } else if (Character.isLowerCase(c)) {
                    toggleCase.append(Character.toUpperCase(c));
                } else {
                    toggleCase.append(c);
                }
            }
            toggleCase.append(" ");
        }
        return toggleCase.toString();
    }
}
