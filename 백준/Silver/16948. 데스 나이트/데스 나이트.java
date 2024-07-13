import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static class Node {
        int x, y, moveCnt;
        public Node(int x, int y, int moveCnt){
            this.x = x;
            this.y = y;
            this.moveCnt = moveCnt;
        }
    }
    public static void main(String[] args) {
        n = scanner.nextInt();

        map = new int[n][n];
        visited = new boolean[n][n];

        int r1 = scanner.nextInt();
        int c1 = scanner.nextInt();
        int r2 = scanner.nextInt();
        int c2 = scanner.nextInt();

        System.out.print(bfs(r1, c1, r2, c2));
    }

    static int bfs(int startX, int startY, int stopX, int stopY){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startX, startY, 0));
        visited[startX][startY] = true;

        while(!queue.isEmpty()){
            Node checkNode = queue.poll();

            if(checkNode.x == stopX && checkNode.y == stopY){
                return checkNode.moveCnt;
            }

            // 이동 가능한 6방향
            int[] mr = {-2, -2, 0, 0, 2, 2};
            int[] mc = {-1, 1, -2, 2, -1, 1};

            for(int i = 0; i < 6; i++){
                int nextX = checkNode.x + mr[i];
                int nextY = checkNode.y + mc[i];
                int nextMoveCnt = checkNode.moveCnt + 1;

                if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && !visited[nextX][nextY]){
                    queue.offer(new Node(nextX, nextY, nextMoveCnt));
                    visited[nextX][nextY] = true;
                }
            }
        }

        return -1;
    }
}