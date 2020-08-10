import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class newClient extends JFrame {
    private JTextArea chatArea;
    private JTextField msgInputField;
    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;

    public newClient() {
        open();
        prepareGUI();
    }

    private void open() {
        try {
            socket = new Socket("localhost", Server.PORT);
            System.out.println("Connected to server: " + socket);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            String message = in.readUTF();
                            if (message.equals("/end")) {
                                System.out.println("Session closed. Cau!");
                                break;
                            }
                            if (message.startsWith("/authok")) {
                                System.out.println("Authorized");

                            }

                            if (message.startsWith("/w " + getName())) {
                                System.out.println();
                            }

                            chatArea.append("\n" + message);


                        } catch (IOException e) {
                            e.printStackTrace();
                            break;
                        }
                    }
                }
            })
                    .start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
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


    public void prepareGUI() {

        setBounds(600, 300, 400, 700);
        setTitle("GUI");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);


        JPanel bottomPanel = new JPanel(new BorderLayout());
        JButton btnSendMsg = new JButton("Отправить");
        bottomPanel.add(btnSendMsg, BorderLayout.EAST);
        msgInputField = new JTextField();
        add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(msgInputField, BorderLayout.CENTER);


        setVisible(true);
    }

    public void sendMessage() {
        if (!msgInputField.getText().trim().isEmpty()) {
            try {
                out.writeUTF(msgInputField.getText());
                msgInputField.setText("");
                msgInputField.grabFocus();
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ошибка отправки сообщения");
            }
        }
    }
}

