import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		String input = scanner.nextLine();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) >= 65 && input.charAt(i) <= 90) { // 대문자
				if(input.charAt(i) + 13 > 90) {
					sb.append((char)(input.charAt(i) - 13));
				}else {
					sb.append((char)(input.charAt(i) + 13));
				}
			}else if(input.charAt(i) >= 97 && input.charAt(i) <= 122) { // 소문자
				if(input.charAt(i) + 13 > 122) {
					sb.append((char)(input.charAt(i) - 13));
				}else {
					sb.append((char)(input.charAt(i) + 13));
				}
			}else { // 그 외 문자
				sb.append((char)(input.charAt(i)));
			}
		}
		
		System.out.println(sb);
	}
}
