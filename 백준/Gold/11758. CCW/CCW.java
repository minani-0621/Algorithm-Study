import java.util.Scanner;
/*
 * 세 점이 있고, 첫 번째 점에서 두 번째 점까지의 v1 벡터, 두 번째 점에서 세 번째 점까지의 v2 벡터가 있을 때,
 * 두 벡터의 외적을 통해서 시계 방향인지 반시계방향인지 알아낼 수 있다. 벡터의 외적은 무조건 3차원의 좌표로만 
 * 구할 수 있으므로 좌표의 z값은 모두 0으로 세팅하면 된다. 외적을 구하게 되면 벡터의 z값을 통해 시계방향인지 
 * 반시계방향인지 판별할 수 있는데, 시계방향이면 음수가, 반시계방향이면 양수가, 일직선이면 0이 나오게 된다.
*/
public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Coordinate c1 = new Coordinate();
		c1.x = scanner.nextInt();
		c1.y = scanner.nextInt();
		c1.z = 0;
		
		Coordinate c2 = new Coordinate();
		c2.x = scanner.nextInt();
		c2.y = scanner.nextInt();
		c2.z = 0;
		
		Coordinate c3 = new Coordinate();
		c3.x = scanner.nextInt();
		c3.y = scanner.nextInt();
		c3.z = 0;
		
		Vector v1 = new Vector();
		v1.x = c2.x - c1.x;
		v1.y = c2.y - c1.y;
		v1.z = c2.z - c1.z;
		
		Vector v2 = new Vector();
		v2.x = c3.x - c1.x;
		v2.y = c3.y - c1.y;
		v2.z = c3.z - c1.z;
		
		Vector result = new Vector();
		result.x = v1.y * v2.z - v1.z * v2.y;
		result.y = v1.z * v2.x - v1.x * v2.z;
		result.z = v1.x * v2.y - v1.y * v2.x;

		if(result.z == 0) {
			System.out.println("0");
		}else if(result.z > 0) {
			System.out.println("1");
		}else if(result.z < 0){
			System.out.println("-1");
		}
	}
}

class Coordinate {
	int x;
	int y;
	int z;
}

class Vector {
	int x;
	int y;
	int z;
}
