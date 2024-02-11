import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/*
 * HashMap만 사용해서 포켓몬 도감을 구현하게 되면 입력으로 포켓몬 이름이 들어왔을 땐 get()으로 가져오면 되지만
 * 입력이 숫자로 들어왔을 땐 value를 통해서 역으로 key값을 찾아야 하기 때문에 keyset()를 이용해서 모든 keyset의
 * 해당하는 value값과 입력으로 들어온 숫자를 비교해서 찾아내야 하기 때문에 시간복잡도가 높아진다.
 * 여기서 입력이 포켓몬 이름으로 주어졌을 땐 HashMap의 get()를 사용해서 포켓몬의 넘버를 찾아내고, 포켓몬의 번호가
 * 주어졌을 땐 ArrayList를 활용하여 array.get()를 통해서 포켓몬의 이름을 구하면 된다.
*/
public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n, m;
	static HashMap<String, Integer> hashmap = new HashMap<>();
	static ArrayList<String> array = new ArrayList<>();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		n = scanner.nextInt();
		m = scanner.nextInt();
		
		for(int i = 1; i <= n; i++) {
			String input = scanner.next();
			hashmap.put(input, i);
			array.add(input);
		}
		
		for(int i = 0; i < m; i++) {
			// 일단 모든 입력을 문자열로 받고
			String input = scanner.next();
			
			// 입력이 숫자이면
			if(Character.isDigit(input.charAt(0))) {
				// 문자열에서 숫자로 변경
				int num = Integer.parseInt(input);
				// ArrayList에서 인덱스가 num - 1 인 요소가 바로 숫자에 해당하는 포켓몬 이름
				bw.write(array.get(num - 1) + "\n");
			}else { // 입력이 문자이면
				// 그 key의 value값을 출력
				bw.write(hashmap.get(input) + "\n");
			}	
		}
		
		bw.flush();
		bw.close();
	}
}
