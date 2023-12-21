import java.io.*;
import java.util.*;
public class CollocationsFinder {
    public static void main(String[] args) {
        // Read the training data, I always liked to use Moby Dick in my CL projects.  : )
        String fileName = "c:\\mobydick.txt";
        List<String> tokens = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(fileName));
            // Tokenize the text, remove case and punctuation.
            scanner.useDelimiter("\\s+|\\p{Punct}");
            while (scanner.hasNext()) {
                tokens.add(scanner.next().toLowerCase());
            }
            scanner.close();
        } catch (fileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            return;
        }
    }
}
