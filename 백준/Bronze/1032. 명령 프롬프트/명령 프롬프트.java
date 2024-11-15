import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		ArrayList<String> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			list.add(scanner.next());
		}
		
		StringBuilder sb = new StringBuilder();
		
		if(n == 1) {
			System.out.println(list.get(0));
		}else {
			for(int i = 0; i < list.get(0).length(); i++) {
				char ch = list.get(0).charAt(i);
				boolean isSame = false;
				
				for(int j = 1; j < n; j++) {
					if(ch != list.get(j).charAt(i)) {
						sb.append("?");
						isSame = false;
						break;
					}else {
						isSame = true;
					}
				}
				
				if(isSame) {
					sb.append(list.get(0).charAt(i));
				}
			}
		}
		
		System.out.println(sb);
	}
}
