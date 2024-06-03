import java.io.*;
import java.net.*;

public class SimpleTCPClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8000);
            System.out.println("Connected to the server");

            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            PrintWriter writer = new PrintWriter(output, true);
            writer.println("Hello from client");

            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String response = reader.readLine();
            System.out.println("Received from server: " + response);

            socket.close();
            System.out.println("Connection closed");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
