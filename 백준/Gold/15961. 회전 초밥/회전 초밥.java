import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, d, k, c;
	
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		d = Integer.parseInt(input[1]);
		k = Integer.parseInt(input[2]);
		c = Integer.parseInt(input[3]);
		
		int[] belt = new int[N];
		
		for(int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}
		/*
		 *  HashSet를 활용하여 슬라이딩 윈도우 내에 있는 초밥 종류 수를 구하면, 가장 왼쪽에 있는 사라지는 초밥이
		 *  다음 슬라이딩 윈도우에도 존재할 경우, set에서 사라져버리기 때문에 HashMap를 활용하여 각 초밥에 대한
		 *  갯수를 통해 초밥 종류의 수를 구한다.
		 */
		HashMap<Integer, Integer> map = new HashMap<>();
		int maxSushi = 0;
		
		for(int i = 0; i < k; i++) {
			if(!map.containsKey(belt[i])) {
				map.put(belt[i], 1);
			}else {
				map.put(belt[i], map.get(belt[i]) + 1);
			}
		}
		
		if(!map.containsKey(c)) {
			maxSushi = map.size() + 1;
		}else {
			maxSushi = map.size();
		}
		
		for(int i = 1; i < N; i++) {
			if(map.get(belt[i - 1]) == 1) {
				map.remove(belt[i - 1]);
			}else {
				map.put(belt[i - 1], map.get(belt[i - 1]) - 1);
			}
			
			if(!map.containsKey(belt[(i + k - 1) % N])) {
				map.put(belt[(i + k - 1) % N], 1);
			}else {
				map.put(belt[(i + k - 1) % N], map.get(belt[(i + k - 1) % N]) + 1);
			}
			
			int currentSize = map.size();
			
			if(!map.containsKey(c)) {
				currentSize++;
			}
			
			maxSushi = Math.max(maxSushi, currentSize);
		}
		
		System.out.println(maxSushi);
	}
}
