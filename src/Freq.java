import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Freq implements Command {

    @Override
    public String name() {
        return "freq";
    }

    @Override
    public boolean run(Scanner scanner) {
        System.out.println("Veuillez entrer le chemin du fichier :");
        String filePath = scanner.nextLine();

        Path path = Paths.get(filePath);

        try {
            String text = Files.readString(path);
            String[] words = text.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");
            Map<String, Long> frequencyMap = Arrays.stream(words)
                    .filter(word -> !word.isBlank())
                    .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

            String topThreeWords = frequencyMap.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(3)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.joining(" "));

            System.out.println(topThreeWords);

        } catch (IOException e) {
            System.out.println("Unreadable file: " + e.getClass().getName() + " " + e.getMessage());
        }
        return false;
    }
}
