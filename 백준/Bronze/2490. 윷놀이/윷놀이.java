import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int state; // 0이면 배, 1이면 등
	static String array[] = new String[3];
	
	public static void main(String[] args) {
		for(int i = 0; i < 3; i++) {
			int count = 0;
			
			for(int j = 0; j < 4; j++) {
				state = scanner.nextInt();
				if(state == 0) {
					count++;
				}
			}
			
			if(count == 0) {
				array[i] = "E";
			}else if(count == 1) {
				array[i] = "A";
			}else if(count == 2) {
				array[i] = "B";
			}else if(count == 3) {
				array[i] = "C";
			}else if(count == 4) {
				array[i] = "D";
			}
		}
		
		for(String str: array) {
			System.out.println(str);
		}
	}
}
