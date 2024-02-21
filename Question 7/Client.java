import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket  cs = new Socket( "localhost" , 1111);

            BufferedReader in = new BufferedReader( new InputStreamReader(cs.getInputStream()));

            PrintWriter out = new PrintWriter( cs.getOutputStream() , true);

            BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter a Sentence (Don't in Camel case please!)");
            String sentence =    bin.readLine();

            out.println(sentence);

            String camaleCase = in.readLine();
            System.out.println("Camel case from the Server" + camaleCase);
            cs.close();


        } catch (Exception e) {
          e.printStackTrace();
        }
    }
}
