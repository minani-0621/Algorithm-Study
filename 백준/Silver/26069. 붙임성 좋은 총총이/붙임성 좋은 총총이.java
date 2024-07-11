import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("ChongChong");

        int n = scanner.nextInt();

        for(int i = 0; i < n; i++) {
            String p1 = scanner.next();
            String p2 = scanner.next();

            if(hashSet.contains(p1) && !hashSet.contains(p2)) {
                hashSet.add(p2);
            }else if(!hashSet.contains(p1) && hashSet.contains(p2)) {
                hashSet.add(p1);
            }
        }

        System.out.print(hashSet.size());
    }
}