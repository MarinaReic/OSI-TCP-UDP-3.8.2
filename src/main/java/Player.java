import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Player {

    public static final String LOCALHOST = "127.0.0.1";

    public static void main(String[] args) {

        try (Socket socket = new Socket(LOCALHOST, Server.PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            String city = in.readLine();

            System.out.println(city);

            System.out.print("Введите город: ");
            out.println(scanner.nextLine());

            String answer = in.readLine();
            System.out.println(answer);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
