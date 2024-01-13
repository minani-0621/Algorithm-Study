import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n;
	static String age, name;
	static String member[][];

	public static void main(String[] args) {
		n = scanner.nextInt();
		member = new String[n][2];
		
		for(int i = 0; i < n; i++) {
			age = scanner.next();
			name = scanner.next();
			
			member[i][0] = age;
			member[i][1] = name;
		}
		
		Arrays.sort(member, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				if(o1[0] != o2[0]) { // 나이가 다르면
					return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]); // 나이를 기준으로 오름차순
				}
				return 0;
			}
			
		});
		
		for(int i = 0; i < n; i++) {
			System.out.printf("%s %s\n", member[i][0], member[i][1]);
		}
	}
}
