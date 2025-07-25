import java.util.*;

public class GameMenu {

    private static final Scanner SCANNER = new Scanner(System.in);

    String[] gallowStages = new String[]{" —————————\n |/      |\n |\n |\n |\n |\n |\n |\n—|—————————\n|         |",
            " —————————\n |/      |\n |      (_)\n |\n |\n |\n |\n |\n—|—————————\n|         |",
            " —————————\n |/      |\n |      (_)\n |       |\n |       |\n |\n |\n |\n—|—————————\n|         |",
            " —————————\n |/      |\n |      (_)\n |      /|\n |       |\n |\n |\n |\n—|—————————\n|         |",
            " —————————\n |/      |\n |      (_)\n |      /|\\\n |       |\n |\n |\n |\n—|—————————\n|         |",
            " —————————\n |/      |\n |      (_)\n |      /|\\\n |       |\n |      /\n |\n |\n—|—————————\n|         |",
            " —————————\n |/      |\n |      (_)\n |      /|\\\n |       |\n |      / \\\n |\n |\n—|—————————\n|         |"};


    public void start(WordManager wordManager) {
        while (true) {
            System.out.println("==============\n   ВИСЕЛИЦА\n==============");
            System.out.println("\n[1] Начать игру\n[2] Выйти из игры");
            System.out.println("\nВведите ваш выбор: ");

            String input = SCANNER.next();

            if (input.equals("1")) {
                beginGameLogic(wordManager);
            } else if (input.equals("2")) {
                System.out.println("\n\n\n\n");
                System.out.println("[Спасибо за игру!]");
                break;
            } else
                System.out.println("Неверное значение\n");
        }
    }

    public void beginGameLogic(WordManager wordManager) {
        String originalWord = wordManager.getRandomWord();

        String hiddenWord = wordManager.hideWord(originalWord);

        Set<String> guessedLetters = new HashSet<>();

        int mistakeCounter = 0;

        while (mistakeCounter < gallowStages.length - 1) {

            System.out.println(gallowStages[mistakeCounter]);
            System.out.println("Использованные буквы: " + guessedLetters);
            System.out.println("Количество ошибок: " + mistakeCounter + '/' + (gallowStages.length - 1) + '\n');

            System.out.println(hiddenWord);

            System.out.println('\n');
            String input = SCANNER.next().toLowerCase();
            if (!input.matches("[а-яА-Я]") || (input.length() != 1)) {
                System.out.println("Введена латинская буква,число или спецсимвол, повторите ввод\n");
                continue;
            }

            hiddenWord = wordManager.guessLetter(hiddenWord, originalWord, input.charAt(0));

            if (!originalWord.contains(input) && !guessedLetters.contains(input)) {
                mistakeCounter++;
            }

            guessedLetters.add(input);
        }
        System.out.println("Вы проиграли! Загаданное слово - " + originalWord);
    }
}
