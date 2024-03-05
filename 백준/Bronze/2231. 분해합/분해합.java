import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		
		if(n == 1) {
			System.out.printf("0");
		}else {
			for(int i = 1; i < n; i++) { // 1부터 n - 1까지 브루트포스로 생성자 찾기
				int sum = i; // sum에 탐색중인 수 i 대입
				String num = Integer.toString(i); // i를 String으로
				
				for(int j = 0; j < num.length(); j++) { // 탐색중인 수 i를 각 자리 별로 sum에 더하기
					sum += Integer.parseInt(Character.toString(num.charAt(j)));
				}
				
				if(sum == n) {
					System.out.printf("%d", i);
					break;
				}
				
				if(i == n - 1) { // 1부터 n - 1까지 입력으로 들어온 n을 구현하는 생성자가 하나도 존재하지 않으면 0 출력
					System.out.printf("0");
				}
			}
		}
		
	}
}
