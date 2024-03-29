import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		
		ArrayList<Integer> packageArray = new ArrayList<>();
		ArrayList<Integer> singleArray = new ArrayList<>();
		
		for(int i = 0; i < m; i++) {
			packageArray.add(scanner.nextInt());
			singleArray.add(scanner.nextInt());
		}
		
		Collections.sort(packageArray);
		Collections.sort(singleArray);
		
		if(packageArray.get(0) > singleArray.get(0) * 6) {
			System.out.println(n * singleArray.get(0));
		}else {
			int case1 = (n / 6) * packageArray.get(0) + (n % 6) * singleArray.get(0);
			int case2 = ((n / 6) + 1) * packageArray.get(0);
			
			if(case1 < case2) {
				System.out.println(case1);
			}else {
				System.out.println(case2);
			}
		}
	}
}
