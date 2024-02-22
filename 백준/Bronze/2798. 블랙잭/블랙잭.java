import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<Integer> array = new ArrayList<>();
	static ArrayList<Integer> answer = new ArrayList<>();
	static int n, m;
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		m = scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			array.add(scanner.nextInt());
		}
		
		for(int i = 0; i <= array.size() - 3; i++) {
			for(int j = i + 1; j <= array.size() - 2; j++) {
				for(int k = j + 1; k <= array.size() - 1; k++) {
					int sum = array.get(i) + array.get(j) + array.get(k);
					if(sum <= m) { // 3개의 카드의 합이 m 이하인 경우에만 answer에 추가
						answer.add(sum);
					}
				}
			}
		}
		
		// n개의 카드중에서 고른 3개의 카드의 합이 m이하인 것들 중에 가장 큰 것부터 나오도록 내림차순 정렬
		Collections.sort(answer, Collections.reverseOrder());
		
		// 첫 번째 요소가 m에 최대한 가까운 카드 3장의 합
		System.out.println(answer.get(0));
	}
}
