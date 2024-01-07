import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int score;
	static int sumScore = 0;
	static int avgScore = 0;
	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			score = scanner.nextInt();
			if(score >= 40) {
				sumScore += score;
			}else {
				sumScore += 40;
			}
		}
		
		avgScore = sumScore / 5;
		System.out.println(avgScore);
	}
}
