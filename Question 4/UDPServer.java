import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class UDPServer{
    public static void main(String[] args) {
        try{
            DatagramSocket serverSocket = new DatagramSocket(1111);
            byte[] receiveData = new byte[1024];
            while(true){
                DatagramPacket receivedData = new DatagramPacket(receiveData,receiveData.length );

                serverSocket.receive(receivedData);

                String data = new String(receivedData.getData() , 0 , receivedData.getLength());
                System.out.println("Received from the client" + data);

                String[] values =  data.split(", ");
                int[] dataSet = new int[values.length];
                for(int i = 0; i<values.length;i++){
                    dataSet[i] = Integer.parseInt(values[i].trim());
                }
                    Arrays.sort(dataSet);


                    double q1 = calculateQuartile(dataSet , 0.25);
                    double  q2 = calculateQuartile(dataSet , 0.5);
                    double q3 = calculateQuartile(dataSet  , 0.75);

                    String quartiles = q1 + " , " + q2 + " , " + q3 ;
                    DatagramPacket sendPacket = new DatagramPacket(quartiles.getBytes() , quartiles.length() , receivedData.getAddress(), receivedData.getPort());
serverSocket.send(sendPacket);

                    

            }
        }catch(Exception e){
                e.printStackTrace();
        }
    }

    private static double calculateQuartile(int[] dataSet , double percentage){
        double index = percentage * (dataSet.length + 1);
        if(index %1 == 0){
            return dataSet[(int)(index -1)];

        }
        else{
            int lowerIndex = (int)Math.floor(index)-1;
            int upperIndex = (int)Math.ceil(index) -1;
            double fraction = index - Math.floor(index);
            return  dataSet[lowerIndex] + fraction *( dataSet[upperIndex] - dataSet[lowerIndex]);

        }
      
    }
}