import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class Form extends JFrame {
    public Form(String title) {
        setTitle(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(0, 0, 600, 500);


        JPanel chatPanel = new JPanel(new BorderLayout());
        JTextArea charTextArea = new JTextArea();
        charTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(charTextArea);
        chatPanel.add(scrollPane);

        add(chatPanel);

        JPanel controlPanel = new JPanel(new BorderLayout());
        JTextField inputField = new JTextField();
        inputField.addActionListener(new ActionListener() {
            private StringBuilder sb = new StringBuilder(charTextArea.getText());

            @Override
            public void actionPerformed(ActionEvent e) {
                if (inputField.getText().isBlank()) {
                    return;
                }

                sb.append("\n")
                        .append(inputField.getText());
                charTextArea.setText(sb.toString());
                inputField.setText("");
                System.out.println(sb.toString());
            }
        });

        controlPanel.add(inputField);

        JButton submitBtn = new JButton("Отправить");
        submitBtn.addActionListener(new SubmitButtonListener(inputField, charTextArea));
        controlPanel.add(submitBtn, BorderLayout.EAST);

        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
