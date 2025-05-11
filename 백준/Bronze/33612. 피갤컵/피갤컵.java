import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
        int year = 2024;
        int month = 8;
        int temp = (n - 1) * 7;
        year += temp / 12;
        month += temp % 12;
        
        if(month > 12) {
            year++;
            month -= 12;
        }
        
        System.out.print(year + " " + month);
	}
}
