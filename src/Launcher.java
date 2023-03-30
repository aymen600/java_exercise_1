import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bienvenue dans le programme !");
        Scanner scanner = new Scanner(System.in);
        String input = "";

            List<Command> commands = new ArrayList<>();
            commands.add(new Quit());
            commands.add(new Fibo());
            commands.add(new Freq());

            do {
                System.out.print("> ");
                input = scanner.nextLine();

                boolean found = false;
                for(Command command : commands) {
                    if(command.name().equals(input)) {
                        found = true;
                        boolean stop = command.run(scanner);
                        if(stop) {
                            scanner.close();
                            return;
                        }
                        break;
                    }
                }

                if(!found) {
                    System.out.println("Unknown command");
                }
            } while(true);
        }
}
