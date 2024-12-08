import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static class Taekwondo {
		int scoreTaekyun, scoreRival, count;
		public Taekwondo(int scoreTaekyun, int scoreRival, int count) {
			this.scoreTaekyun = scoreTaekyun;
			this.scoreRival = scoreRival;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		int C = scanner.nextInt();
		
		for(int i = 0; i < C; i++) {
			int S = scanner.nextInt();
			int T = scanner.nextInt();
			
			int result = bfs(S, T);
			bw.write(result + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static int bfs(int S, int T) {
		Queue<Taekwondo> queue = new LinkedList<>();
		queue.offer(new Taekwondo(S, T, 0));
		
		while(!queue.isEmpty()) {
			Taekwondo checkTaekwondo = queue.poll();
			
			if(checkTaekwondo.scoreTaekyun == checkTaekwondo.scoreRival) {
				return checkTaekwondo.count;
			}
			
			if(checkTaekwondo.scoreTaekyun * 2 <= checkTaekwondo.scoreRival + 3) {
				queue.offer(new Taekwondo(checkTaekwondo.scoreTaekyun * 2, checkTaekwondo.scoreRival + 3, checkTaekwondo.count + 1));
			}
			
			queue.offer(new Taekwondo(checkTaekwondo.scoreTaekyun + 1, checkTaekwondo.scoreRival, checkTaekwondo.count + 1));
			
		}
		
		return -1;
	}
}
