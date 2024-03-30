import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		int cycle = 1;
		
		int next = plusCycle(n);
		if(n == next) {
			System.out.println(cycle);
		}else {
			while(true) {
				if(n == next) {
					break;
				}else {
					cycle++;
					next = plusCycle(next);
				}
			}
			System.out.println(cycle);
		}
		
	}
	
	static int plusCycle(int n) {
		int nextNum = 0;
		if(n < 10) {
			String str = Integer.toString(n).concat(Integer.toString(n));
			nextNum = Integer.parseInt(str);
		}else {
			String num = Integer.toString(n);
			int sumNum = Character.getNumericValue(num.charAt(0)) + Character.getNumericValue(num.charAt(1));
			if(sumNum < 10) {
				String str = Integer.toString(Character.getNumericValue(num.charAt(1))).concat(Integer.toString(sumNum));
				nextNum = Integer.parseInt(str);
			}else {
				String str = Character.toString(Integer.toString(n).charAt(1)).concat(Character.toString(Integer.toString(sumNum).charAt(1)));
				nextNum = Integer.parseInt(str);
			}
		}
		return nextNum;
	}
}
