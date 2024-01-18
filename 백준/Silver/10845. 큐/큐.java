import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n;
	static String command;
	static ArrayList<Integer> queue = new ArrayList<>();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		n = scanner.nextInt();
		
		for(int i = 0; i < n + 1; i++) {
			command = scanner.nextLine();
			
			if(command.length() > 5 && command.substring(0, 4).equals("push")) {
				queue.add(Integer.parseInt(command.substring(5)));
			}else if(command.equals("pop")) {
				if(queue.size() == 0) {
					bw.write("-1\n");
				}else {
					bw.write(queue.get(0) + "\n");
					queue.remove(0);
				}
			}else if(command.equals("size")) {
				bw.write(queue.size() + "\n");
			}else if(command.equals("empty")) {
				if(queue.isEmpty()) {
					bw.write("1\n");
				}else {
					bw.write("0\n");
				}
			}else if(command.equals("front")) {
				if(queue.isEmpty()) {
					bw.write("-1\n");
				}else {
					bw.write(queue.get(0) + "\n");
				}
			}else if(command.equals("back")) {
				if(queue.isEmpty()) {
					bw.write("-1\n");
				}else {
					bw.write(queue.get(queue.size() - 1) + "\n");
				}
			}
		}
		
		bw.flush();
		bw.close();
	}
}
