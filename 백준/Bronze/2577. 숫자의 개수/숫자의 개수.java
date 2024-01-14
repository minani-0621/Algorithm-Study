import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int a, b, c, result;
	static String strResult;
	static int list[][] = new int[10][2];
	
	public static void main(String[] args) {
		a = scanner.nextInt();
		b = scanner.nextInt();
		c = scanner.nextInt();
		
		result = a * b * c;
		strResult = String.valueOf(result);
		
		for(int i = 0; i < 10; i++) {
			list[i][0] = i;
			list[i][1] = 0;
		}
		
		for(int i = 0 ; i < strResult.length(); i++) {
			for(int j = 0; j < 10; j++) {
				if(Character.getNumericValue(strResult.charAt(i)) == list[j][0]) {
					list[j][1]++;
				}
			}	
		}
		
		for(int i = 0; i < 10; i++) {
			System.out.println(list[i][1]);
		}
	}
}
