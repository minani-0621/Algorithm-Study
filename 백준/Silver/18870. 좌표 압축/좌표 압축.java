import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
/*
 * 처음에는 기존 ArrayList에서 하나의 요소를 선택하고, 중복이 제거된 리스트를 순차탐색하면서 선택된 하나의 요소와
 * 비교하여 기준이 되는 요소보다 작은 요소의 개수를 카운팅하는 이중 for문 방식으로 구현하였는데, 이렇게 구현하게 되면
 * n이 1,000,000일 때 최악의 시간복잡도는 1,000,000 * 1,000,000번의 연산이 수행되게 되서 시간초과가 발생한다.
 * 시간복잡도를 줄이기 위해서는 일일이 ArrayList를 통해서 해당 대상의 요소보다 작은 수의 개수를 세는 방법이 아니라
 * HashMap을 이용해서 어떤 수보다 작은 수의 개수를 저장하는 방식으로 구현하면 된다. 기존의 beforeCompression
 * ArrayList를 HashSet에 저장하고 다시 ArrayList로 변환하는 과정을 통해서 중복된 수들을 제거해주고 오름차순으로
 * 정렬시켜 준다. 그리고 여기서 오름차순으로 정렬된 중복이 제거된 어레이리스트에서 인덱스는 해당 수보다 작은 수의 개수와
 * 같다. 이 점을 이용하여 HashMap에 저장한 후 출력할 때 beforeCompression의 요소를 key로 사용해서 값을 가져오면
 * 그 요소보다 작은 요소의 개수를 가져오게 된다. 이로써 1번의 for문을 사용한 출력이 가능해진다.
*/
public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int n = scanner.nextInt();
		
		ArrayList<Integer> beforeCompression = new ArrayList<>(); // 압축 전 ArrayList
		HashSet<Integer> hashset = new HashSet<>(); // 중복 제거를 위한 HashSet
		
		for(int i = 0; i < n; i++) {
			int input = scanner.nextInt();
			
			beforeCompression.add(input);
			hashset.add(input);
		}
		
		ArrayList<Integer> distinctArray = new ArrayList<>(hashset); // 중복 제거 후 ArrayList
		Collections.sort(distinctArray); // 오름차순 정렬
		
		HashMap<Integer, Integer> hashmap = new HashMap<>();
		
		for(int i = 0; i < distinctArray.size(); i++) {
			hashmap.put(distinctArray.get(i), i); // distinctArray에서 인덱스는 그 수보다 작은 수의 개수와 동일
		}
		
		for(int i = 0; i < beforeCompression.size(); i++) {
			bw.write(hashmap.get(beforeCompression.get(i)) + " ");
		}
		
		bw.flush();
		bw.close();
	}
}
