

import java.io.*;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Objects;


public class ClientHandler {


    private AuthService.Record record;
    private Server server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public ClientHandler(Server server, Socket socket) {
        try {

            this.server = server;
            this.socket = socket;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        doAuth();
                        readMessage();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            })
                    .start();

        } catch (IOException e) {
           throw new RuntimeException("Client handler was not created");
        }
    }

    public AuthService.Record getRecord() {
        return record;
    }

    public void doAuth() throws Exception {
        while (true) {

            System.out.println("Waiting for auth...");
            String message = in.readUTF();
            System.out.println(message);
            if (message.startsWith("/auth")) {
                String[] credentials = message.split("\\s");
                System.out.println(credentials[1] + credentials[2]);
                BasicAuthService.findByLoginAndPassword(credentials[1],credentials[2]);
                AuthService.Record possibleRecord = BasicAuthService.findByLoginAndPassword(credentials[1], credentials[2]);
                if (possibleRecord != null) {
                    if (!server.isOccupied(possibleRecord)) {
                        record = possibleRecord;
                        sendMessage("/authok " + record.getName());
                        ChatHistory.lastHistory();
                        File recordsFile = new File("E:\\Новая папка\\untitled1\\src\\History.txt"); //для хранения последних 100 строк используется отдельный файл
                        BufferedReader reader = new BufferedReader(new FileReader(recordsFile));
                        String val;
                        while ((val = reader.readLine()) != null) {
                            sendMessage(val);
                        }

                        server.broadcastMessage("Logged-in " + record.getName());
                        server.subscribe(this);
                        break;
                    } else {
                        sendMessage(String.format("Current user [%s] is already occupied", possibleRecord.getName()));
                    }
                } else {
                    sendMessage(String.format("User no found"));
                }
            }

        }
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void readMessage() throws Exception {
        while (true) {
            String message = in.readUTF();
            System.out.println(String.format("Incoming message from %s: %s", record.getName(), message));
            if (message.equals("/end")) {
                return;
            }
            if (message.startsWith("/takeNewName")){

                String[] credentials = message.split("\\s");
                try {
                    System.out.println( credentials[1]);
                    BasicAuthService.newName(credentials[1], record.getId());
                    record.setNewName(credentials[1]);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }
            server.broadcastMessage(String.format("%s: %s", record.getName(), message));
            ChatHistory.doWriteString(record.getName(), message);
        }
    }

    public void closeConnection() {
        server.unsubscribe(this);
        server.broadcastMessage(record.getName() + " left chat");
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientHandler that = (ClientHandler) o;
        return record.equals(that.record) &&
                server.equals(that.server) &&
                socket.equals(that.socket) &&
                in.equals(that.in) &&
                out.equals(that.out);
    }

    @Override
    public int hashCode() {
        return Objects.hash(record, server, socket, in, out);
    }
}
