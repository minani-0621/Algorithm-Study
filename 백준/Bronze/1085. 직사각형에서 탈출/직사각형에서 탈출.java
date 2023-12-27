import java.util.Scanner;

public class Main {
	static int x;
	static int y;
	static int w;
	static int h;
	static int calc1;
	static int calc2;
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		x = scanner.nextInt();
		y = scanner.nextInt();
		w = scanner.nextInt();
		h = scanner.nextInt();
		
		while((x < 1) || (x > w-1) || (y < 1) || (y > h-1)) {
			x = scanner.nextInt();
			y = scanner.nextInt();
			w = scanner.nextInt();
			h = scanner.nextInt();
		}
		
		if((w - x) < x) {
			calc1 = w - x;
		}else if((w - x) > x) {
			calc1 = x;
		}else if((w - x) == x) {// w-x, x 둘다 같은 값이어서 둘중에 아무거나 넣어도 됨
			calc1 = w - x;
		}
		
		if((h - y) < y) {
			calc2 = h - y;
		}else if((h - y) > y) {
			calc2 = y;
		}else if((h - y) == y) {// h-y, y 둘다 같은 값이어서 둘중에 아무거나 넣어도 됨
			calc2 = h - y;
		}
		
		if(calc1 < calc2) {
			System.out.printf("%d", calc1);
		}else if(calc1 > calc2) {
			System.out.printf("%d", calc2);
		}else if(calc1 == calc2) {// calc1, calc2 둘다 같은 값이어서 둘중에 아무거나 넣어도 됨
			System.out.printf("%d", calc1);
		}
	}
}