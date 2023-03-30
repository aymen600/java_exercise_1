import java.util.Scanner;

public class Fibo implements Command {

    public String name() {
        return "fibo";
    }

    public boolean run(Scanner scanner) {
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consommer le caractère \n
        int result = fibonacci(n);
        System.out.println("The " + n + "th fibonacci number is " + result);
        return false;
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}
