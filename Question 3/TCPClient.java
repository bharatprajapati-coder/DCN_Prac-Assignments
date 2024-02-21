import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) {
        try {
            Socket cs  = new Socket("localhost" , 1111);

            BufferedReader bin = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            PrintWriter bout  = new PrintWriter(new OutputStreamWriter(cs.getOutputStream()) , true);

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter values seperated by commas(,)");
            String values = sc.nextLine();

           bout.println(values);

           String response = bin.readLine();
           System.out.println("Received from the server" + response);

           bin.close();
           bout.close();
           cs.close();


            
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}



