import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        new EchoServer();
    }

    public EchoServer(){
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(8888);
            System.out.println("Сервер запущен, порт:"+ server.getLocalPort()+" ожидание клиента...");
            socket = server.accept();
            System.out.println("Клиент подключился");
            new Client(socket, "Сервер");
            while(true){
                if(socket.isClosed()){
                    break;
                }
            }
            server.close();
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Ошибка инициализации сервера");
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}