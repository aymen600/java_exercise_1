import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Launcher {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    public static void main(String[] args) {
        System.out.println("Bienvenue dans le programme !");
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while(!input.equals("quit")) {
            System.out.print("> ");
            input = scanner.nextLine();

            if(!input.equals("quit") && !input.equals("fibo") && !input.equals("freq")) {
                System.out.println("Unknown command");
            }
            else if (input.equals("fibo")) {
                System.out.print("Entrez un nombre : ");
                int n = scanner.nextInt();
                scanner.nextLine(); // consommer le caractère \n
                int fibo = fibonacci(n);
                System.out.println("Fibonacci(" + n + ") = " + fibo);
            }
            else if (input.equals("freq")) {
                System.out.println("Please enter the path to the file: ");
                String filePath = scanner.nextLine();

                try {
                    String content = Files.readString(Paths.get(filePath));
                    content = content.replaceAll("\\p{Punct}", " ").toLowerCase();
                    String[] words = content.split("\\s+");

                    Map<String, Long> wordCount = Arrays.stream(words)
                            .filter(s -> !s.isBlank())
                            .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

                    String topThreeWords = wordCount.entrySet().stream()
                            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                            .limit(3)
                            .map(Map.Entry::getKey)
                            .collect(Collectors.joining(" "));

                    System.out.println("Top 3 most frequent words: " + topThreeWords);
                } catch (IOException e) {
                    System.out.println("Unreadable file: " + e.getClass().getName() + " " + e.getMessage());
                }
            }

        }
    }
}
