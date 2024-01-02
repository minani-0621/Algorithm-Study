import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static StringBuilder binary = new StringBuilder("");
	// 이 문제에서는 입력된 하나의 8진수를 2진수로 변환하고 차례로 뒤에 이어서 붙여햐 하는데, 이를 다룰 때 int나 long 타입은 처리과정에서 시간복잡도가 너무 커져서 시간초과가 발생하고,
	// String 객체로 처리하면 String 객체는 한 번 생성되면 그 값을 변경할 수 없고, concat(), append() 함수를 사용하거나, str1 = str2 + str3; 처럼 2진수로 변형된 8진수의 String 값을 이어 붙일 때 마다
	// 매번 새로운 String 참조변수에 값을 할당해줘야 해서 시간 초과가 발생한다. 이를 해결하기 위해 값을 변경할 수 있는 StringBuilder를 사용해서 처리시간을 단축시킬 수 있다. 
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
