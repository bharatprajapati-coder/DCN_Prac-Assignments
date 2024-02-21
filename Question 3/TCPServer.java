// // Enter a set of numeric values at client-side and send it to server-side. Server will fetch the
// // values and return all Prime numbers from the series received. If the set of values does not have
// // any prime number return 0. Use TCP Protocol implementation.

// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.InputStreamReader;
// import java.io.OutputStreamWriter;
// import java.io.PrintWriter;
// import java.net.ServerSocket;
// import java.net.Socket;
// import java.util.ArrayList;

// public class TCPServer{
//     public static void main(String[] args) {
//         try {
//             ServerSocket ss = new ServerSocket(1111);
//             while(true){
//                 Socket cs =  ss.accept();
//                     System.out.println("Connection established");
//                     BufferedReader bin = new BufferedReader(new InputStreamReader(cs.getInputStream()));
//                     PrintWriter  bout = new PrintWriter(new OutputStreamWriter(cs.getOutputStream()) );

//                     String data = bin.readLine();
// System.out.println("reached");
//                     ArrayList<Integer> ListData = new ArrayList<>();
//                     String[] parst = data.split(",");
//                     for(String part: parst){
//                         ListData.add( Integer.parseInt(part.trim()));
//                     }


//                     ArrayList<Integer> primes  = new ArrayList<>();
//                     for(int num : ListData){
//                             if(isPrime(num)){
//                                 primes.add(num);
//                             }
//                     }

//                     for(String n : parst){
//                         System.out.println(Integer.parseInt(n.trim()));

//                     }
//                     //Send the response to the client
//                     if(!primes.isEmpty()){
//                         bout.write(primes.toString());
//                     }
//                     else{
//                         bout.write("No prime numbers found");
//                     }
//             }


//         } catch (Exception e) {
//             // TODO: handle exception
//             e.printStackTrace();
//         }
//     }


//     public static boolean isPrime(int n){
//         if(n < 2){
//             return false;
//         }
//         else{
//             for(int i = 2 ;i <Math.sqrt(n);i++){
//                 if(n%i == 0){
//                     return false;
//                 }
//             }
//         }
//         return true;

//     }
// }


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TCPServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1111);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected.");

                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true);

                // Read data from client
                String data = reader.readLine();

                // Process data
                List<Integer> numbers = new ArrayList<>();
                String[] parts = data.split(",");
                for (String part : parts) {
                    numbers.add(Integer.parseInt(part.trim()));
                }

                List<Integer> primes = new ArrayList<>();
                for (int num : numbers) {
                    if (isPrime(num)) {
                        primes.add(num);
                    }
                }

                // Send response to client
                if (!primes.isEmpty()) {
                    writer.println(primes.toString());
                } else {
                    writer.println("0");
                }

                // Close connections
                writer.close();
                reader.close();
                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
