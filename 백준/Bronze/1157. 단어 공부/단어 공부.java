import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		HashMap<Character, Integer> dict = new HashMap<>();
		
		String word = br.readLine();
		
		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) >= 97) { // 소문자면 대문자로 변환
				char tmp = (char)(word.charAt(i) - 32);
				if(!dict.containsKey(tmp)) {
					dict.put(tmp, 1);
				}else {
					dict.replace(tmp, dict.get(tmp) + 1);
				}
			}else { // 대문자이면
				if(!dict.containsKey(word.charAt(i))) {
					dict.put(word.charAt(i), 1);
				}else {
					dict.replace(word.charAt(i), dict.get(word.charAt(i)) + 1);
				}
			}
		}
			
		ArrayList<Integer> freq = new ArrayList<>(dict.values());
		Collections.sort(freq, Collections.reverseOrder());
		
		if(freq.size() == 1 || (freq.size() >= 2 && !freq.get(0).equals(freq.get(1)))) {
			for(Character ch: dict.keySet()) {
				if(dict.get(ch).equals(freq.get(0))) {
					System.out.println(ch);
					break;
				}
			}
		}else if(freq.get(0).equals(freq.get(1)) || word.isEmpty()){
			System.out.println("?");
		}
	}
}
