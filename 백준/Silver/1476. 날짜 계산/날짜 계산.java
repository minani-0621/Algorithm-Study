import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int e = 0;
	static int s = 0;
	static int m = 0;
	static int year = 0;
	
	public static void main(String[] args) {
		int inputE = scanner.nextInt();
		int inputS = scanner.nextInt();
		int inputM = scanner.nextInt();
		
		while(e != inputE || s != inputS || m != inputM) {
			e++;
			s++;
			m++;
			
			if(e > 15) {
				e = 1;
			}
			
			if(s > 28) {
				s = 1;
			}
			
			if(m > 19) {
				m = 1;
			}
			
			year++;
		}
		
		System.out.println(year);
	}
}
