import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    WordGenerator wordGenerator;
    Scanner sc = new Scanner(System.in);
    String[] gallowStages = new String[]{" —————————\n |/      |\n |\n |\n |\n |\n |\n |\n—|—————————\n|         |",
            " —————————\n |/      |\n |      (_)\n |\n |\n |\n |\n |\n—|—————————\n|         |",
            " —————————\n |/      |\n |      (_)\n |       |\n |       |\n |\n |\n |\n—|—————————\n|         |",
            " —————————\n |/      |\n |      (_)\n |      /|\n |       |\n |\n |\n |\n—|—————————\n|         |",
            " —————————\n |/      |\n |      (_)\n |      /|\\\n |       |\n |\n |\n |\n—|—————————\n|         |",
            " —————————\n |/      |\n |      (_)\n |      /|\\\n |       |\n |      /\n |\n |\n—|—————————\n|         |",
            " —————————\n |/      |\n |      (_)\n |      /|\\\n |       |\n |      / \\\n |\n |\n—|—————————\n|         |"};

    Menu() {
        wordGenerator = new WordGenerator();
    }

    public void MenuInterface() {
        String choice;
        try {
            while (true) {
                System.out.println("==============\n   ВИСЕЛИЦА\n==============");
                System.out.println("\n[1] Начать игру\n[2] Выйти из игры");
                System.out.println("\nВведите ваш выбор: ");
                choice = sc.nextLine();
                if (choice.equals("1")) {
                    GameInterface();
                    sc.nextLine();
                } else if (choice.equals("2")) {
                    System.out.println("\n\n\n\n");
                    System.out.println("[Спасибо за игру!]");
                    return;
                } else
                    System.out.println("Неверное значение\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void GameInterface() {
        Game newGame = new Game(wordGenerator.GetRandomWord());
        char[] unknowWord = new char[newGame.getWordSize()];
        Arrays.fill(unknowWord, '_');

        int mistakeCount = 0;
        StringBuilder usedLetters = new StringBuilder();
        try {
            while (mistakeCount < gallowStages.length - 1) {
                System.out.println(gallowStages[mistakeCount]);
                System.out.println("Использованные буквы: " + usedLetters);
                System.out.println("Количество ошибок: " + mistakeCount + '/' + (gallowStages.length - 1) + '\n');
                for (int i = 0; i < unknowWord.length; i++) {
                    System.out.print(unknowWord[i]);
                }
                while (true) {
                    System.out.println('\n');
                    String input = sc.next();
                    if (input.matches("[а-яА-Я]")) {
                        mistakeCount += newGame.SearchForLetter(input.toLowerCase().charAt(0), unknowWord, usedLetters);
                        break;
                    } else {
                        System.out.println("Введена латинская буква,число или спецсимвол, повторите ввод\n");
                    }
                }
                if (newGame.CheckProgress(unknowWord)) {
                    System.out.println("\n\n\n[Победа!]\n");
                    return;
                }
            }
            System.out.println("\n\n\n[Поражение.]\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
