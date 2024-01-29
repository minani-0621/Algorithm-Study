import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<Integer> array = new ArrayList<>();
	static int n, k;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st1.nextToken());
		k = Integer.parseInt(st1.nextToken());
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			array.add(Integer.parseInt(st2.nextToken()));
		}
		
		Collections.sort(array);
		
		System.out.println(array.get(k - 1));
	}
}
