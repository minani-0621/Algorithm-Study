import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int list[];
	public static void main(String[] args) {
		String input = scanner.next();
		int length = input.length();
		list = new int[length];
		for(int i = 0; i < length; i++) {
			list[i] = Character.getNumericValue(input.charAt(i));
		}
		
		int i, j, most, tmp;
		
		for(i = 0; i < length - 1; i++) {
			most = i;
			for(j = i + 1; j < length; j++) {
				if(list[j] >= list[most]) {
					most = j;
				}
			}
			tmp = list[i];
			list[i] = list[most];
			list[most] = tmp;
		}
		for(i = 0; i < length; i++) {
			System.out.printf("%d", list[i]);
		}
	}
}