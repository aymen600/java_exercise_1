import java.util.Scanner;
public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bienvenue dans le programme !");
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while(!input.equals("quit")) {
            System.out.print("> ");
            input = scanner.nextLine();

            if(!input.equals("quit")) {
                System.out.println("Unknown command");
            }
        }
    }
}
