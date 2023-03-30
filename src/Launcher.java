import java.util.Scanner;
public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bienvenue dans le programme !");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        if (userInput.equals("quit")) {
            return;
        }
        System.out.println("Unknown command");
        return;
    }
}
