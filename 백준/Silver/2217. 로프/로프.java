import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		ArrayList<Integer> input = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			input.add(scanner.nextInt());
		}
		
		Collections.sort(input);
		
		ArrayList<Integer> caseList = new ArrayList<>();
		
		/* 이 문제의 핵심. 단순히 (가장 짧은 로프 길이)*(전체 로프의 개수)가 아니라, 임의로 몇 개의 로프만 골라서 사용해도 되기 때문에,
		   가장 작은 로프를 하나씩 제외해가면서 (가장 작은 로프)*(남은 로프의 개수)를 어레이 리스트에 저장하고 이중에서 가장 큰 케이스가 정답! */
		for(int i = 0; i < input.size(); i++) {
			int result = input.get(i) * (input.size() - i);
			caseList.add(result);
		}
		
		Collections.sort(caseList, Collections.reverseOrder());;
		
		System.out.println(caseList.get(0));
	}
}
