import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		String target = scanner.next();
		int N = scanner.nextInt();
		int ringCount = 0;
		
		for(int i = 0; i < N; i++) {
			String str = scanner.next();
			String circulateStr = str.concat(str);
			
			if(circulateStr.contains(target)) {
				ringCount++;
			}
		}
		
		System.out.println(ringCount);
	}
}
