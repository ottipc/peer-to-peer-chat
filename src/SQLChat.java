import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SQLChat {
    private static final int PORT = 12345; // Default port number

    public static void main(String[] args) {
        if (args.length == 0) {
            startServer();
        } else if (args.length == 2 && "--other_instance".equals(args[0])) {
            String[] connectionInfo = args[1].split(":");
            startClient(connectionInfo[0], Integer.parseInt(connectionInfo[1]));
        } else {
            System.out.println("Invalid arguments. Usage: sqlchat [--other_instance <IP>:<Port>]");
        }
    }

    private static void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started. Connect on " + InetAddress.getLocalHost().getHostAddress() + ":" + PORT);

            try (Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 Scanner scanner = new Scanner(System.in)) {

                System.out.println("Client connected: " + clientSocket.getInetAddress());
                Thread sender = new Thread(() -> {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if ("EXIT".equalsIgnoreCase(line.trim())) {
                            System.exit(0);
                        }
                        out.println(line);
                    }
                });

                sender.start();

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Client: " + inputLine);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void startClient(String host, int port) {
        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to server: " + host + ":" + port);
            Thread sender = new Thread(() -> {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if ("EXIT".equalsIgnoreCase(line.trim())) {
                        System.exit(0);
                    }
                    out.println(line);
                }
            });

            sender.start();

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Server: " + inputLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
