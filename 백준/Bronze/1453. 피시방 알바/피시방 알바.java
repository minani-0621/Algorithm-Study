import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int N = scanner.nextInt();
		boolean[] seat = new boolean[101];
		int rejectPerson = 0;
		
		for(int i = 0; i < N; i++) {
			int seatNum = scanner.nextInt();
			
			if(!seat[seatNum - 1]) {
				seat[seatNum - 1] = true;
			}else {
				rejectPerson++;
			}
		}
		
		System.out.println(rejectPerson);
	}
}
