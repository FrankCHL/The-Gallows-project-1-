import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class WordManager {

    public String getRandomWord() {
        try {
            List<String> words = Files.readAllLines(Paths.get("words.txt"));
            Random random = new Random();
            return words.get(random.nextInt(words.size()));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String hideWord(String word) {
        return "_".repeat(word.length());
    }

    public String guessLetter(String hiddenWord, String originalWord, char guessedLetter) {
        char[] hiddenChars = hiddenWord.toCharArray();
        for (int i = 0; i < originalWord.length(); i++) {
            if (originalWord.charAt(i) == guessedLetter) {
                hiddenChars[i] = guessedLetter;
            }
        }
        return new String(hiddenChars);
    }
}