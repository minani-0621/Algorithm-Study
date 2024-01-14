import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static Integer score[] = new Integer[8];
	static Integer copyScore[] = new Integer[8];
	static int sum = 0;
	
	public static void main(String[] args) {
		for(int i = 0; i < 8; i++) {
			score[i] = scanner.nextInt();
			copyScore[i] = score[i];
		}
		
		Arrays.sort(score, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});		
		
		for(int i = 0; i < 5; i++) {
			sum += score[i];
		}
		
		System.out.println(sum);
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 5; j++) {
				if(copyScore[i] == score[j]) {
					System.out.printf("%d ", i + 1);
				}
			}
		}
	}
}
