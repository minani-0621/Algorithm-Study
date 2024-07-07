import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int money = n * 100;

        if(money >= m) {
            System.out.print("Yes");
        }else {
            System.out.print("No");
        }
    }
}