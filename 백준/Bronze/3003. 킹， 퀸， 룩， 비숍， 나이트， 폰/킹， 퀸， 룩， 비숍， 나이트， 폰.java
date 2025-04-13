import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int[] initState = new int[6];
		int[] editState = new int[6];
		int[] standardState = {1, 1, 2, 2, 2, 8};
		
		for(int i = 0; i < 6; i++) {
			initState[i] = scanner.nextInt();
		}
		
		for(int i = 0; i < 6; i++) {
			editState[i] = standardState[i] - initState[i];
		}
		
		for(int num: editState) {
			System.out.print(num + " ");
		}
	}
}
