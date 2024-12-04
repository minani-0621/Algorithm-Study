import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		String id = scanner.next();
		
		for(int i = 0; i < 3; i++) {
			if(i == 1) {
				for(int j = 0; j < 3; j++) {
					if(j == 1) {
						System.out.print(":" + id + ":");
					}else {
						System.out.print(":fan:");
					}
				}
			}else {
				for(int j = 0; j < 3; j++) {
					System.out.print(":fan:");
				}
			}
			
			System.out.println();
		}
	}
}
