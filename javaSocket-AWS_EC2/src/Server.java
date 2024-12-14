import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {


    public static void main(String[] args) {

        int port = 5000;


        try{
            ServerSocket ss = new ServerSocket(port);

            System.out.println("İstemciler " + port + "portunda  dinleniyor.");

            Socket socket = ss.accept();

            System.out.println("İstemci bağlantısı geldi :" + socket.getInetAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;

            while ((message = in.readLine()) != null) {
                System.out.println("Gelen mesaj: " + message);

                out.println("Sunucudan yanıt: " + message);
            }

            socket.close();
            ss.close();

        }catch(IOException ex){

            System.out.println(ex.getMessage());
        }


    }
}
