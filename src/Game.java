import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    private String word;

    Game(String word) {
        this.word = word;
    }

    public int getWordSize() {
        return word.length();
    }

    public int SearchForLetter(char letter, char[] unknownWord, StringBuilder usedLetters) {
        boolean found = false;
        if (usedLetters.indexOf(String.valueOf(letter)) == -1) {
            usedLetters.append(letter);
        }
        for (int i = 0; i < word.length(); i++) {

            if (word.charAt(i) == letter || word.toUpperCase().charAt(i) == letter) {
                unknownWord[i] = word.charAt(i);
                found = true;
            }
        }
        if (found) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean CheckProgress(char[] unknownWord) {
        String buffer = new String(unknownWord);
        return buffer.equals(word);
    }
}
