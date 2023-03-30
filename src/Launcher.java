import java.util.Scanner;
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

            if(!input.equals("quit") && !input.equals("fibo")) {
                System.out.println("Unknown command");
            }
            else if (input.equals("fibo")) {
                System.out.print("Entrez un nombre : ");
                int n = scanner.nextInt();
                scanner.nextLine(); // consommer le caractère \n
                int fibo = fibonacci(n);
                System.out.println("Fibonacci(" + n + ") = " + fibo);
            }

        }
    }
}
