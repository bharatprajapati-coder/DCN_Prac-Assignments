// Request a number from Client-side and server will calculate the Square of the number and
// return it to client in response. Use TCP Protocol implementation.

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) {
        try{
            Socket cs = new Socket("localhost" , 1111);
            DataInputStream ds = new DataInputStream(cs.getInputStream());
            DataOutputStream dos = new DataOutputStream(cs.getOutputStream());
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a Number");
            int number =  sc.nextInt();
            dos.writeInt(number);
            
            int serverMessage = ds.readInt();
            
            System.out.println("Received from server" + serverMessage);
            ds.close();
            dos.close();
            cs.close();



        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
