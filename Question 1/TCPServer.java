// Request a number from Client-side and server will calculate the Square of the number and
// return it to client in response. Use TCP Protocol implementation.
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer{
    public static void main(String[] args)  {
        try{
            ServerSocket ss = new ServerSocket(1111);
            Socket cs = ss.accept();
            System.out.println("connection  is established");
           DataInputStream ds = new DataInputStream(cs.getInputStream());
           DataOutputStream dos = new DataOutputStream(cs.getOutputStream());
           int number = ds.readInt();
           int cube = number * number;
           dos.writeInt(cube);

           ds.close();
           dos.close();
           cs.close();
           ss.close();



        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}
