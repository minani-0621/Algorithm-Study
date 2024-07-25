import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        int b = scanner.nextInt();
        int tmp = b / 11;
        int a = b - tmp;
        System.out.print(a);
    }
}
