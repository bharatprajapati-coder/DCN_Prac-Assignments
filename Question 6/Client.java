import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Client{
    public static void main(String[] args) {
        try {
            Socket cs = new Socket("localhost" , 1111);
            BufferedReader bin  = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            PrintWriter pw = new PrintWriter(cs.getOutputStream() , true);
            BufferedReader inputData = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                System.out.println("Options");
                System.out.println("A .Circle");
                System.out.println("B .Rectangle");
                System.out.println("C .Square");
                System.out.println("D .Triangel");
                System.out.println("E .Exit");
                System.out.println("Enter your choice");

                String option = inputData.readLine();
                if(option.equals('e')){
                    pw.println(option);
                    break;
                }
                if(option.equals("A")){
                    System.out.println("Enter Radius of Circle");
                    String r = inputData.readLine();
                    String s = option + ":" + r;
                    pw.println(s);

                }
                else if(option.equals("B")){
                    System.out.println("Enter Value of Height For Rectangle");
                    String height = inputData.readLine();
                    System.out.println("Enter Value of Width For Rectangle");
                    String width = inputData.readLine();
                    String s  = option + ":"+ height + " " + width;
                    pw.println(s);
                }
                else if(option.equals("C")){
                    System.out.println("Enter Value of Side For Square");
                    String side = inputData.readLine();
                    String s = option + " :" + side;
                    pw.println(s);
                }

                else if(option.equals("D")){
                    System.out.println("Enter Value of Base For Triangle");
                    String b = inputData.readLine();
                    System.out.println("Enter Value of Height For Triangle");
                    String h = inputData.readLine();
                    String s = option + ": " + b + ":" + h;
                    pw.println(s);
                    
                    
                }
                String response = bin.readLine();
                System.out.println("Server says :" + response);
                
            }




        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
}