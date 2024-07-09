import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int sum = 0;
        for(int i = 0; i < 5; i++){
            int input = scanner.nextInt();
            sum += input;
        }

        System.out.print(sum);
    }
}