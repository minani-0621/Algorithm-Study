import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static double scores[];
	static int N;
	
	public static void main(String[] args) {
		inputCount();
		readScores();
		double bigNum = findBigger();
		manipulate(bigNum);
		double avg = calcNewAvg();
		
		System.out.printf("%f", avg);
	}
	
	public static void inputCount() {
		N = scanner.nextInt();
		scores = new double[N];
	}
	
	public static void readScores() {
		for(int i = 0; i < N; i++) {
			scores[i] = (double)scanner.nextInt();
		}
	}
	
	public static double findBigger() {
		double bigger;
		bigger = scores[0];
		for(int i = 0; i < N - 1; i++) {
			if(bigger <= scores[i + 1]) {
				bigger = scores[i + 1];
			}
		}
		return bigger;
	}
	
	public static void manipulate(double bigNum) {
		for(int i = 0; i < N; i++) {
			scores[i] = scores[i] / bigNum * 100;
		}
	}
	
	public static double calcNewAvg() {
		double avg;
		double tmp = 0;
		for(int i = 0; i < N; i++) {
			tmp += scores[i];
		}
		avg = tmp / N;
		return avg;
	}
	
}