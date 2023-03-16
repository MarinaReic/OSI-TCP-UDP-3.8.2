import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final int PORT = 8989;

    public static void main(String[] args) {

        String city1 = "???";

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                    System.out.println("Подключён игрок " + socket.getPort());

                    out.println(city1);
                    String city2 = in.readLine();

                    System.out.println("Игрок ввёл город - " + city2);

                    if (city2.charAt(0) == city1.charAt(city1.length() - 1) || city1.equals("???")) {
                        out.println("OK");
                        city1 = city2;
                    } else {
                        out.println("NOT OK");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}
