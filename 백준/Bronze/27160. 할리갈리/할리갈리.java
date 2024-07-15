import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HashMap<String, Integer> hashmap = new HashMap<>();

        int n = scanner.nextInt();

        for(int i = 0; i< n; i++){
            String input = scanner.next();
            int count = scanner.nextInt();

            if(!hashmap.containsKey(input)){
                hashmap.put(input, count);
            }else{
                hashmap.replace(input, hashmap.get(input) + count);
            }
        }

        boolean answer = false;

        for(String key: hashmap.keySet()){
            if(hashmap.get(key) == 5){
                answer = true;
            }
        }

        if(answer){
            System.out.print("YES");
        }else{
            System.out.print("NO");
        }
    }
}