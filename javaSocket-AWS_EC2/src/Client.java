import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    private JFrame frame;
    private JTextArea textArea;
    private JTextField textField;
    private JButton sendButton;


    public void start() {

        frame = new JFrame("Socket İstemcisi");
        textArea = new JTextArea(20, 40);
        textArea.setEditable(false);
        textField = new JTextField(40);
        sendButton = new JButton("Gönder");

        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.add(textField, BorderLayout.SOUTH);
        frame.add(sendButton, BorderLayout.EAST);

        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        try {
            socket = new Socket("3.254.65.170", 5000);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = in.readLine()) != null) {
                        textArea.append("Sunucudan: " + serverMessage + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
            textArea.append("Bağlantı hatası: " + e.getMessage() + "\n");
        }

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        textField.addActionListener(e -> sendMessage());
    }

    private void sendMessage() {
        String message = textField.getText();
        if (!message.isEmpty()) {
            out.println(message);
            textArea.append("İstemciden: " + message + "\n");
            textField.setText("");
        }
    }
}
