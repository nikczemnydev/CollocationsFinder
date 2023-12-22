import java.io.*;
import java.util.*;
public class CollocationsFinder {
    public static void main(String[] args) {
        // Read the training data, I always liked to use Moby Dick for my CL projects.  : )
        String fileName = "c:\\book.txt";
        List<String> tokens = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(fileName));
            // Tokenize the text, remove case and punctuation.
            scanner.useDelimiter("\\s+|\\p{Punct}");
            while (scanner.hasNext()) {
                tokens.add(scanner.next().toLowerCase());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            return;
        }

        // Compute the probabilities of any two words that appear next to each other.
        Map<String, Double> probabilities = new HashMap<>();
        // Store unique words in set.
        Set<String> words = new HashSet<>(tokens);
        // Loop through all tokens.
        for (int i = 0; i < tokens.size() - 1; i++) {
            // Get current and next token. **/
            String word1 = tokens.get(i);
            String word2 = tokens.get(i + 1);
            // Concatenate two tokens with space. **/
            String pair = word1 + " " + word2;
            // Increment count of pair in map. **/
            probabilities.put(pair, probabilities.getOrDefault(pair, 0.0) + 1.0);
        }

        // Divide counts by total number of pairs to get probabilities.
        int total = tokens.size() - 1;
        probabilities.replaceAll((p, v) -> probabilities.get(p) / total);

        // Ask user for 2 words to check if they are collocation.
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 2 words separated by space or .stop to terminate the program:");
        String line = input.nextLine();

        // Loop until stopped, so multiple searches can be conducted without restarting
        // and re-training the program - which can take long depending on size of corpus.
        while (!line.equals(".stop")) {
            // Split the input into 2 words using space as separator.
            String[] wordss = line.split("\\s+");
            // Check if the input is valid, i.e. is indeed 2 words as asked.
            if (wordss.length != 2) {
                System.out.println("Invalid input. Enter 2 words separated by space or .stop to terminate:");
            } else {
                // Get 2 words, at this stage the case is removed (actually everything is made lowercase).
                String word1 = wordss[0].toLowerCase();
                String word2 = wordss[1].toLowerCase();
                // Concatenate 2 words with space. **/
                String pair = word1 + " " + word2;
                // Get probability of pair. **/
                double probability = probabilities.getOrDefault(pair, 0.0);
                // Get individual probabilities of words. **/
                double probability1 = (double) Collections.frequency(tokens, word1) / tokens.size();
                double probability2 = (double) Collections.frequency(tokens, word2) / tokens.size();
                // Check if pair is collocation - a pair is collocation if its probability is greater than
                // product of individual probabilities.
                if (probability > probability1 * probability2) {
                    System.out.println("The pair " + pair + " is a collocation.");
                } else {
                    System.out.println("The pair " + pair + " is not a collocation.");
                }
            }
            // Ask for another pair of words
            System.out.println("Enter another pair of words or .stop to terminate:");
            line = input.nextLine();
        }
    }
}
