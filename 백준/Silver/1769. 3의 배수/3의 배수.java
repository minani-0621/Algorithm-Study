import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		String X = scanner.next();
		int count = 0;
		
		while(X.length() > 1) {
			int sum = 0;
			
			for(int i = 0; i < X.length(); i++) {
				sum += Character.getNumericValue(X.charAt(i));
			}
			
			X = Integer.toString(sum);
			count++;
		}
		
		System.out.println(count);
		
		if(Integer.parseInt(X) % 3 == 0) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
}
