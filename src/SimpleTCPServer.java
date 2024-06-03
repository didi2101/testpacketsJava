import java.io.*;
import java.net.*;

public class SimpleTCPServer {

    public static void main(String[] args) {
        try {

            ServerSocket serverSocket = new ServerSocket(8000);


            while(true) {

                System.out.println("Server is listening on port 8000");

                Socket socket = serverSocket.accept();
                System.out.println("Client connected");


                InputStream input = socket.getInputStream();
                OutputStream output = socket.getOutputStream();


                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String message = reader.readLine();
                System.out.println("Received from client: " + message);


                PrintWriter writer = new PrintWriter(output, true);
                writer.println("Hello from server");


                socket.close();
                System.out.println("Client connection closed");


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
