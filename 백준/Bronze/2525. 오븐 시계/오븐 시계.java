import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int a; // 현재의 시
	static int b; // 현재의 분
	static int makingTime; // 조리 소요 시간
	
	public static void main(String[] args) {
		a = scanner.nextInt();
		b = scanner.nextInt();
		makingTime = scanner.nextInt();
		
		int h, m;
		h = makingTime / 60;
		m = makingTime % 60;
		
		
		b += m;
		if(b >= 60) {
			b -= 60;
			a += 1;
		}
		
		a += h;
		if(a >= 24) {
			a -= 24;
		}
		
		System.out.printf("%d %d", a, b);
	}
}