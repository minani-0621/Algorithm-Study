import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		String S = scanner.next();
		boolean isPossible = true;
		int index = 0;
		
		while(index < S.length()) {
			if(S.charAt(index) == 'p') {
				if(index + 1 >= S.length() || S.charAt(index + 1) != 'i') {
					isPossible = false;
					break;
				}else {
					index += 2;
				}
			}else if(S.charAt(index) == 'k') {
				if(index + 1 >= S.length() || S.charAt(index + 1) != 'a') {
					isPossible = false;
					break;
				}else {
					index += 2;
				}
			}else if(S.charAt(index) == 'c') {
				if(index + 1 >= S.length() || S.charAt(index + 1) != 'h') {
					isPossible = false;
					break;
				}else {					
					if(index + 2 >= S.length() || S.charAt(index + 2) != 'u') {
						isPossible = false;
						break;
					}else {
						index += 3;
					}
				}
			}else {
				isPossible = false;
				break;
			}
		}
		
		if(isPossible) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
}
