import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int[] mingook = new int[4];
		int[] mansae = new int[4];
		
		for(int i = 0; i < 4; i++) {
			mingook[i] = scanner.nextInt();
		}
		
		for(int i = 0; i < 4; i++) {
			mansae[i] = scanner.nextInt();
		}
		
		int mingookSum = 0;
		int mansaeSum = 0;
		
		for(int i = 0; i < 4; i++) {
			mingookSum += mingook[i];
			mansaeSum += mansae[i];
		}
		
		if(mingookSum >= mansaeSum) {
			System.out.println(mingookSum);
		}else {
			System.out.println(mansaeSum);
		}
	}
}
