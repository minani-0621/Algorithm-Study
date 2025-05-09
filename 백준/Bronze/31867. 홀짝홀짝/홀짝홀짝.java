import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int N = scanner.nextInt();
		String K = scanner.next();
		int oddCount = 0;
		int evenCount = 0;
		
		for(int i = 0; i < K.length(); i++) {
			if(Character.getNumericValue(K.charAt(i)) % 2 == 0) {
				evenCount++;
			}else {
				oddCount++;
			}
		}
		
		if(evenCount > oddCount) {
			System.out.println(0);
		}else if(oddCount > evenCount) {
			System.out.println(1);
		}else {
			System.out.println(-1);
		}
	}
}
