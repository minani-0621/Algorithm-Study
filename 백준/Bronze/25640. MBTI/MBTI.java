import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		String jinhoMbti = scanner.next();
		int memberCount = scanner.nextInt();
		int sameMbti = 0;
		
		for(int i = 0; i < memberCount; i++) {
			String inputMbti = scanner.next();
			
			if(inputMbti.equals(jinhoMbti)) {
				sameMbti++;
			}
		}
		
		System.out.println(sameMbti);
	}
}
