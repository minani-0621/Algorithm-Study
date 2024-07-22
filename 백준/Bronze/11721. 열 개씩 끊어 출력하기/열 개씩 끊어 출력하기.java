import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input = scanner.next();
        int index = 0;

        while(true){
            if(input.length() - index > 10){
                String subInput = input.substring(index, index + 10);
                bw.write(subInput + "\n");
                index += 10;
            }else{
                String subInput = input.substring(index);
                bw.write(subInput);
                break;
            }
        }

        bw.flush();
        bw.close();
    }
}
