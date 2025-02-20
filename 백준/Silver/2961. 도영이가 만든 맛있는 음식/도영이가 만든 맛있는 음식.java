import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static List<Dish> dishes = new ArrayList<>();
	static List<List<Dish>> cases = new ArrayList<>();
	static class Dish {
		int sour, bitter;
		public Dish(int sour, int bitter) {
			this.sour = sour;
			this.bitter = bitter;
		}
	}
	
	public static void main(String[] args) {
		int N = scanner.nextInt();
		
		
		for(int i = 0; i < N; i++) {
			int sour = scanner.nextInt();
			int bitter = scanner.nextInt();
			dishes.add(new Dish(sour, bitter));
		}
		
		
		for(int pc = 1; pc <= dishes.size(); pc++) {
			combination(0, pc, new ArrayList<>());
		}
		
		int min = Integer.MAX_VALUE;
		
		for(List<Dish> c: cases) {
			int sourMulti = 1;
			int bitterSum = 0;
			
			for(Dish d: c) {
				sourMulti *= d.sour;
				bitterSum += d.bitter;
			}
			
			min = Math.min(min, Math.abs(sourMulti - bitterSum));
		}
		
		System.out.println(min);
	}
	
	static void combination(int start, int pickCount, List<Dish> list) {
		if(list.size() == pickCount) {
			cases.add(new ArrayList<>(list));
			return;
		}
		
		for(int i = start; i < dishes.size(); i++) {
			list.add(dishes.get(i));
			combination(i + 1, pickCount, list);
			list.remove(list.size() - 1);
		}
		
		return;
	}
}
