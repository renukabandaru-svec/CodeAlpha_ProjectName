import java.io.*;
import java.util.*;

public class ChatBotLogic {

    private HashMap<String, String> faq;

    public ChatBotLogic() {
        faq = new HashMap<>();
        loadFAQs();
    }

    private void loadFAQs() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("FAQs.txt"));

            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("=");

                if (parts.length == 2) {
                    faq.put(parts[0].toLowerCase().trim(),
                            parts[1].trim());
                }
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error loading FAQs.");
        }
    }

    public String getResponse(String input) {

        input = input.toLowerCase().trim();

        if (faq.containsKey(input)) {
            return faq.get(input);
        }

        if (input.contains("java")) {
            return "Java is a powerful object-oriented programming language.";
        }

        if (input.contains("ai")) {
            return "Artificial Intelligence enables machines to think and learn.";
        }

        if (input.contains("machine learning")) {
            return "Machine Learning is a branch of Artificial Intelligence.";
        }

        if (input.contains("how are you")) {
            return "I am fine. Thank you for asking!";
        }

        if (input.contains("thank")) {
            return "You're welcome!";
        }

        if (input.contains("college")) {
            return "Please tell me which college you are asking about.";
        }

        return "Sorry, I don't understand. Please ask another question.";
    }
}