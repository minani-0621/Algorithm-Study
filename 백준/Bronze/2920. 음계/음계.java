import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int[] array = new int[8];
	
	public static void main(String[] args) {
		for(int i = 0; i < 8; i++) {
			array[i] = scanner.nextInt();
		}
		
		if(array[0] < array[1]) { // ascending 시작
			for(int i = 1; i < 7; i++) {
				if(array[i] > array[i + 1]) {
					System.out.println("mixed");
					break;
				}else if(array[i] < array[i + 1] && i == 6) {
					System.out.println("ascending");
				}
			}
		}else if(array[0] > array[1]) { // descending 시작
			for(int i = 1; i < 7; i++) {
				if(array[i] < array[i + 1]) {
					System.out.println("mixed");
					break;
				}else if(array[i] > array[i + 1] && i == 6) {
					System.out.println("descending");
				}
			}
		}
	}
}
