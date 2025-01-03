import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int x1, y1, x2, y2, x3, y3, x4 = 0, y4 = 0;
		
		x1 = scanner.nextInt();
		y1 = scanner.nextInt();
		x2 = scanner.nextInt();
		y2 = scanner.nextInt();
		x3 = scanner.nextInt();
		y3 = scanner.nextInt();
		
		HashMap<Integer, Integer> hashmapX = new HashMap<>();
		HashMap<Integer, Integer> hashmapY = new HashMap<>();
		
		if(!hashmapX.containsKey(x1)) {
			hashmapX.put(x1, 1);
		}else {
			hashmapX.put(x1, hashmapX.get(x1) + 1);
		}
		
		if(!hashmapY.containsKey(y1)) {
			hashmapY.put(y1, 1);
		}else {
			hashmapY.put(y1, hashmapY.get(y1) + 1);
		}
		
		if(!hashmapX.containsKey(x2)) {
			hashmapX.put(x2, 1);
		}else {
			hashmapX.put(x2, hashmapX.get(x2) + 1);
		}
		
		if(!hashmapY.containsKey(y2)) {
			hashmapY.put(y2, 1);
		}else {
			hashmapY.put(y2, hashmapY.get(y2) + 1);
		}
		
		if(!hashmapX.containsKey(x3)) {
			hashmapX.put(x3, 1);
		}else {
			hashmapX.put(x3, hashmapX.get(x3) + 1);
		}
		
		if(!hashmapY.containsKey(y3)) {
			hashmapY.put(y3, 1);
		}else {
			hashmapY.put(y3, hashmapY.get(y3) + 1);
		}
		
		for(int num: hashmapX.keySet()) {
			if(hashmapX.get(num) == 1) {
				x4 = num;
				break;
			}
		}
		
		for(int num: hashmapY.keySet()) {
			if(hashmapY.get(num) == 1) {
				y4 = num;
				break;
			}
		}
		
		System.out.println(x4 + " " + y4);
	}
}
