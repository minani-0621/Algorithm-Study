import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        long sum = 0;
        long a, b, c;
        a = scanner.nextLong();
        b = scanner.nextLong();
        c = scanner.nextLong();

        sum += a;
        sum += b;
        sum += c;

        System.out.print(sum);
    }
}