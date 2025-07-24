import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WordGenerator {
    ArrayList<String> wordsArray;

    WordGenerator() {
        wordsArray = new ArrayList<>();
        try (FileReader reader = new FileReader("words.txt")) {
            while (reader.ready()) {
                String buf = "";
                while (reader.ready()) {
                    int c = reader.read();
                    if (c != (int) ',') {
                        buf += (char) c;
                    } else break;
                }
                wordsArray.add(buf);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String GetRandomWord() {
        int index = (int) (Math.random() * wordsArray.size());
        return wordsArray.get(index);
    }
}