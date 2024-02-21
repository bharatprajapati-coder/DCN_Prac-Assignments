import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{

    public static double area(double r){
        return 3.14 * r * r;
    }
    public static double areas(double r){
        return r  * r;
    }
    public static double area(double h , double l){
        return h * l;
    }
    public static double area(double val1 , double val2 , double val3){
        return val1 * val2 * val3;

    }

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(1111);
            Socket cs = ss.accept();
            System.out.println("client accepted");
            BufferedReader bin = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            PrintWriter bout = new PrintWriter(cs.getOutputStream() , true);
        
            while(true){
               String receiveData = bin.readLine();
               System.out.println("Client says" + receiveData);
               String[] data = receiveData.split(":");
               if(receiveData.equals("E")){
                break;
               } 
               if(data[0].equals("A")){
                    double r  = Double.parseDouble(data[1]);
                    double response = area(r);
                    String sendData = "Area of the Circle is" + response;
                    bout.println(sendData);
                }
                else if(data[0].equals("B")){
                    double length = Double.parseDouble(data[1]);
                    double height = Double.parseDouble(data[2]);
                    double reposne = area(length , height);
                    String sendData = "Area of Rectangel is" + reposne; 
                    bout.println(sendData);
                }
                else if(data[0].equals("C")){
                    double side = Double.parseDouble(data[0]);
                    double response = areas(side);
                    String sendData = "Area of Square is" + response;
                    bout.println(sendData);

                }
                else if(data[0].equals("D")){
                    double b = Double.parseDouble(data[1]);
                    double h = Double.parseDouble(data
                    [2]);
                    double reposne = area(0.5 , b, h);
                    String sendData = "Area of Rectangel is" + reposne;
                    bout.println(sendData);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
}