import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int coef; // 계수
	static int expo; // 지수
	static int total = 0; // 10진수 합계
	public static void main(String[] args) {
		String input = scanner.next();
		int length = input.length();
		
		for(int i = 0; i < length; i++) {
			char token = input.charAt(i);
			if(token == 'A') {
				coef = 10;
				expo = length - 1 - i;
				double term = calcTerm(coef, expo);
				total = calcTotal(term);
			}else if(token == 'B') {
				coef = 11;
				expo = length - 1 - i;
				double term = calcTerm(coef, expo);
				total = calcTotal(term);
			}else if(token == 'C') {
				coef = 12;
				expo = length - 1 - i;
				double term = calcTerm(coef, expo);
				total = calcTotal(term);
			}else if(token == 'D') {
				coef = 13;
				expo = length - 1 - i;
				double term = calcTerm(coef, expo);
				total = calcTotal(term);
			}else if(token == 'E') {
				coef = 14;
				expo = length - 1 - i;
				double term = calcTerm(coef, expo);
				total = calcTotal(term);
			}else if(token == 'F') {
				coef = 15;
				expo = length - 1 - i;
				double term = calcTerm(coef, expo);
				total = calcTotal(term);
			}
			else {
				coef = Character.getNumericValue(token);
				expo = length - 1 - i;
				double term = calcTerm(coef, expo);
				total = calcTotal(term);
			}
		}
		System.out.printf("%d", total);
	}
	
	static double calcTerm(int coef, int expo) {
		double term;
		term = coef * Math.pow(16, expo);
		
		return term;
	}
	
	static int calcTotal(double term) {
		total += (int)term; // total = total + term
		return total;
	}
	
}
