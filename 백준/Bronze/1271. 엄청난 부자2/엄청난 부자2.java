import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        String n = scanner.next();
        String m = scanner.next();

        BigInteger bigIntegerN = new BigInteger(n);
        BigInteger bigIntegerM = new BigInteger(m);

        System.out.println(bigIntegerN.divide(bigIntegerM));
        System.out.println(bigIntegerN.mod(bigIntegerM));
    }

}
