import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n;
	static String command;
	static ArrayList<Integer> stackList = new ArrayList<>();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		n = scanner.nextInt();
		
		for(int i = 0; i < n + 1; i++) {
			command = scanner.nextLine();
			
			if(command.length() > 5 && command.substring(0, 4).equals("push")) {
				stackList.add(Integer.parseInt(command.substring(5)));
			}else if(command.equals("pop")) {
				if(stackList.size() == 0) {
					bw.write("-1\n");
				}else {
					bw.write(stackList.get(stackList.size() - 1) + "\n");
					stackList.remove(stackList.size() - 1);
				}
			}else if(command.equals("size")) {
				bw.write(stackList.size() + "\n");
			}else if(command.equals("empty")) {
				if(stackList.isEmpty()) {
					bw.write("1\n");
				}else {
					bw.write("0\n");
				}
			}else if(command.equals("top")) {
				if(stackList.isEmpty()) {
					bw.write("-1\n");
				}else {
					bw.write(stackList.get(stackList.size() - 1) + "\n");
				}
			}
		}
		bw.flush();
		bw.close();
	}
}
