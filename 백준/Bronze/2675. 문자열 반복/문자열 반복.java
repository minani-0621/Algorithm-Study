import java.util.ArrayList;
import java.util.Scanner;
/* 
 * 각각의 테스트 케이스는 String형의 input 변수로 받고, 반복 횟수를 적용한 결과는 ArrayList output 변수에 저장
*/
public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int t, r;
	static String input;
	static ArrayList<String> output = new ArrayList<>();
	
	public static void main(String[] args) {
		t = scanner.nextInt();
		
		for(int i = 0; i < t; i++) {
			r = scanner.nextInt();
			input = scanner.next();
			
			for(int j = 0; j < input.length(); j++) {
				output.add(String.valueOf(input.charAt(j)).repeat(r)); // 입력으로 주어지는 문자의 한 단어씩 가져와서 반복횟수 r만큼 덧붙혀서 output ArrayList에 추가
			}
			output.add("\n"); // 하나의 테스트 케이스가 다 입력되고 나면 다른 테스트 케이스와 구분하기 위해서 output ArrayList에 개행문자 추가
		}
		
		for(int i = 0; i < output.size(); i++) {
			System.out.printf("%s", output.get(i));
		}
	}
}
