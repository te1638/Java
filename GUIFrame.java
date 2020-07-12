import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUIFrame extends JFrame {
    public GUIFrame() {
        setTitle("My first Java GUI");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 500);

        setBackground(new Color(202, 114, 14));


        GridLayout gridLayout = new GridLayout(6, 3);
        setLayout(gridLayout);

        JTextField textField = new JTextField();
        textField.setBackground(new Color(0xA2E44C));
        add(textField);


        ButtonListener buttonListener = new ButtonListener(textField);

        for (int i = 0; i <= 9; i++) {
            JButton jButton = new JButton(String.valueOf(i));
            jButton.addActionListener(buttonListener);
            add(jButton);
        }

        JButton сButton = new JButton("С");
        сButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();

                textField.setText("0");
            }
        });

        JButton pushButton = new JButton("Push");
        pushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                String[] splitted = text.split(" \\W ");
                int val;
                for (int i = 0; i < splitted.length; i++) {
                    int digit = Integer.parseInt(splitted[i]);
                    val = digit;
                    textField.setText(String.valueOf(val));
                }
            }
        });


        JButton plusButton = new JButton(" + ");
        plusButton.addActionListener(buttonListener);
        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                String[] splitted = text.split(" \\+ ");
                int val = 0;

                for (int i = 0; i < splitted.length; i++) {
                    int digit = Integer.parseInt(splitted[i]);
                    val += digit;
                }

                textField.setText(String.valueOf(val));
            }
        });

        JButton minusButton = new JButton(" - ");
        minusButton.addActionListener(buttonListener);

        minusButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                String[] splitted = text.split(" \\- ");
                int val = 0;

                for (int i = 0; i < splitted.length; i++) {
                    int digit = Integer.parseInt(splitted[i]);
                    if (Integer.parseInt(splitted[0]) == 0) {
                        val = 0;
                        val = val - digit;
                    } else if (val == 0) {
                        val = (digit);
                    } else
                        val = val - digit;

                }
                textField.setText(String.valueOf(val));
            }
        });

        JButton multButton = new JButton(" * ");
        multButton.addActionListener(buttonListener);
        multButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                String[] splitted = text.split(" \\* ");
                int val = 1;
                for (int i = 0; i < splitted.length; i++) {
                    int digit = Integer.parseInt(splitted[i]);
                    val *= digit;
                }

                textField.setText(String.valueOf(val));
            }
        });

        JButton splitButton = new JButton(" / ");
        splitButton.addActionListener(buttonListener);
        splitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String text = textField.getText();
                String[] splitted = text.split(" \\/ ");
                int qVal;
                int val = 0;

                for (int i = 0; i < splitted.length; i++) {
                    int digit = Integer.parseInt(splitted[i]);
                    if (i != 0) {
                        int qDigit = Integer.parseInt(splitted[i]);
                        qVal = qDigit;


                        val /= qVal;
                        textField.setText(String.valueOf(val));
                    } else {
                        val = digit;
                    }


                }


            }
        });


        add(plusButton);
        add(minusButton);
        add(multButton);
        add(splitButton);
        add(pushButton);
        add(сButton);
        setVisible(true);
    }
}
