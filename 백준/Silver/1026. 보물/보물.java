import java.util.Scanner;
/** S = A[0] × B[0] + ... + A[N-1] × B[N-1] 가 최소가 되게 하려면 A[]은 내림차순, B[]은 오름차순으로
  * 정렬한 후 계산하면 된다. 문제에서 A[]은 재정렬하되, B[]은 재정렬하지 말라고 되어 있지만, 두 배열을 모두 재정렬
  * 한 후에 계산해도 문제가 없다. 왜냐하면 두 배열이 모두 재정렬 된 상태에서 A[]의 요소와 B[]의 요소의 쌍을 같이 엮은
  * 상태에서 B[]을 기준으로 원래 정렬되어 있던 상태로 복구시키면 결국, A[]만 재정렬한 것과 같기 때문이다.
  */
public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n;
	static int a[];
	static int b[];
	static int sum;
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		a = new int[n];
		b = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			b[i] = scanner.nextInt();
		}
		
		ascendingOrder(a, n);
		
		descendingOrder(b, n);
		
		sum = calcSum(a, b, n);
		
		System.out.printf("%d", sum);
	}
	
	static void ascendingOrder(int list[], int n) {
		int i, j, least, tmp;
		for(i = 0; i < n - 1; i++) {
			least = i;
			for(j = i + 1; j < n; j++ ) {
				if(list[least] >= list[j]) {
					least = j;
				}
			}
			tmp = list[least];
			list[least] = list[i];
			list[i] = tmp;
		}
	}

	static void descendingOrder(int list[], int n) {
		int i, j, most, tmp;
		for(i = 0; i < n - 1; i++) {
			most = i;
			for(j = i + 1; j < n; j++) {
				if(list[most] <= list[j]) {
					most = j;
				}
			}
			tmp = list[most];
			list[most] = list[i];
			list[i] = tmp;
		}
	}
	
	static int calcSum(int a[], int b[], int n) {
		int sum = 0;
		for(int i = 0; i < n; i++) {
			sum += (a[i] * b[i]); 
		}
		
		return sum;
	}
}
