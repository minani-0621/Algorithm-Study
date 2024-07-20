import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("NLCS", "North London Collegiate School");
        hashMap.put("BHA", "Branksome Hall Asia");
        hashMap.put("KIS", "Korea International School");
        hashMap.put("SJA", "St. Johnsbury Academy");

        String input = scanner.next();

        System.out.print(hashMap.get(input));
    }
}
