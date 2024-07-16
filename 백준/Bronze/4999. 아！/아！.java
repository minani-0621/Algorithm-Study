import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        String input = scanner.next();
        String wantInput = scanner.next();

        if(input.length() < wantInput.length()){
            System.out.print("no");
        }else{
            System.out.print("go");
        }
    }
}
