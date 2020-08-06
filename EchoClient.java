import java.io.IOException;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) {
        new EchoClient();
    }
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8888;

    public EchoClient() {
        try {
            Socket socket = new Socket(SERVER_ADDR, SERVER_PORT);
            new Client(socket, "Клиент");
            while(true){
                if(socket.isClosed()){
                    break;
                }
            }
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}