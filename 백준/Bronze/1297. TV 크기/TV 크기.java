import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int D;
    static int H;
    static int W;
    static double X;
    
    static void input(){
        D = scanner.nextInt();
        H = scanner.nextInt();
        W = scanner.nextInt();
    }
    
    static void calculate(){
    	X = Math.sqrt((double)(D * D) / (double)((W * W) + (H * H)));
        H = (int) Math.floor(H * X);
        W = (int) Math.floor(W * X);
    }
    
    public static void main(String[] args){
        input();
        while((H > W) || ((D < 5) && (D > 1000)) || ((H < 1) && (H > 99)) || ((W < 2) && (W > 100))){
            input();
        }
        calculate();
        System.out.printf("%d %d", H, W);
    }
}