import java.util.HashMap;
import java.util.Scanner;
/*
기계를 한 번씩 실행할 때마다 A->B로, B->BA로 치환해줘야 한다. 근데 k가 45일때 처럼 기계의 실행 횟수가
많아지면 많아질수록, 문자열의 모든 데이터를 매 실행횟수마다 한 단어씩 치환과정을 거치고 전체길이의 문자열을 
저장하려면 매우 많은 저장공간도 필요하게 되고, 처리 시간도 길어지게 된다. 그래서 다이나믹 프로그래밍을 사용하여야
하는데, 문자열의 전체 데이터를 저장해두고 처리하는 것이 아니라 문자열에서 A의 갯수, B의 갯수를 저장해두고 
A의 갯수가 a개라면 A->B의 치환과정을 거쳐야 하므로 A의 갯수를 a개만큼 줄이고, B의 갯수를 a개 만큼 늘린다.
B의 갯수가 b개라면 B->BA의 치환과정을 거쳐야 하므로 A의 갯수를 b개만큼 늘리고, A의 갯수는 그대로 유지한다.
*/
public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int k;
	static HashMap<String, Integer> hashmap = new HashMap<>();
	
	public static void main(String[] args) {
		k = scanner.nextInt();
		
		hashmap.put("A", 1);
		hashmap.put("B", 0);
		
		for(int i = 0; i < k; i++) {
			int a = hashmap.get("A");
			int b = hashmap.get("B");
			hashmap.replace("A", hashmap.get("A") - a + b);
			hashmap.replace("B", hashmap.get("B") + a);
		}
		
		System.out.printf("%d %d", hashmap.get("A"), hashmap.get("B"));
	}
}
