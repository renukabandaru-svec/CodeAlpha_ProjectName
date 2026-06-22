import javax.swing.*;
import java.awt.*;

public class ChatBotGUI extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    private ChatBotLogic bot;

    public ChatBotGUI() {

        bot = new ChatBotLogic();

        setTitle("AI Chatbot");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 16));

        JScrollPane scrollPane = new JScrollPane(chatArea);

        inputField = new JTextField();

        sendButton = new JButton("Send");

        JPanel bottomPanel = new JPanel(new BorderLayout());

        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        chatArea.append("Bot: Hello! I am your AI Chatbot.\n");
        chatArea.append("Bot: Ask me anything.\n\n");

        sendButton.addActionListener(e -> sendMessage());

        inputField.addActionListener(e -> sendMessage());

        setVisible(true);
    }

    private void sendMessage() {

        String userInput = inputField.getText().trim();

        if (userInput.isEmpty()) {
            return;
        }

        chatArea.append("You: " + userInput + "\n");

        String response = bot.getResponse(userInput);

        chatArea.append("Bot: " + response + "\n\n");

        inputField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ChatBotGUI());
    }
}