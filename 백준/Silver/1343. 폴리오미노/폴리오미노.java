import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		String input = scanner.next();
		int len = input.length();
		input = input.concat("    "); // 문자열을 AAAA나 BB로 치환하는 과정에서 substring()를 사용할 때 StringIndexOutOfBoundException 오류를 방지하기 위한 과정
		int index = 0;
		
		while(index < input.length()) {
			
			if(input.substring(index, index + 1).equals(".")) {
				index++;
			}else if(input.substring(index, index + 4).equals("XXXX")) {
				input = input.replaceFirst("XXXX", "AAAA");
				index += 4;
			}else if(input.substring(index, index + 2).equals("XX")) {
				input = input.replaceFirst("XX", "BB");
				index += 2;
			}else {
				break;
			}
		}
		
		if(index < len) {
			System.out.println("-1");
		}else {
			System.out.println(input);
		}		
	}
	
}
