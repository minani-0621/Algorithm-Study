import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static StringBuilder binary = new StringBuilder("");
	
	public static void main(String[] args) {
		String octal = scanner.next();
		int length = octal.length();
		
		for(int i = 0; i < length; i++) {
			char num = octal.charAt(i);
			
			if(num == '0') {
				String tmp = new String("000");
				binary.append(tmp);
			}else if(num == '1') {
				String tmp = new String("001");
				binary.append(tmp);
			}else if(num == '2') {
				String tmp = new String("010");
				binary.append(tmp);
			}else if(num == '3') {
				String tmp = new String("011");
				binary.append(tmp);
			}else if(num == '4') {
				String tmp = new String("100");
				binary.append(tmp);
			}else if(num == '5') {
				String tmp = new String("101");
				binary.append(tmp);
			}else if(num == '6') {
				String tmp = new String("110");
				binary.append(tmp);
			}else if(num == '7') {
				String tmp = new String("111");
				binary.append(tmp);
			}
		}
		
		if(binary.toString().equals("000")) {
			System.out.printf("%s", "0");
		}else {
			int i = 0;
			while(binary.charAt(i) == '0') {
				i++;
			}
			String answer = binary.substring(i);
			
			System.out.printf("%s", answer);
		}
	}
}