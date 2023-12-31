import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int h;
		int m;
		
		h = scanner.nextInt();
		m = scanner.nextInt();
		
		if(m - 45 < 0) {
			if(h == 0) {
				h = 23;
				m = m + 60 - 45;
			}else {
				h = h - 1;
			m = m + 60 - 45;
			}
		}
		else if(m - 45 >= 0) {
			m = m - 45;
		}
		
		System.out.printf("%d ", h);
		System.out.printf("%d", m);
	}
}