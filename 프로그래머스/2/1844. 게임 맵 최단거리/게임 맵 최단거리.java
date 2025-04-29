import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        boolean[][] visited = new boolean[n][m];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1}); // i, j, depth
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int depth = current[2];
            
            if (x == n - 1 && y == m - 1) {
                return depth;
            }
            
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!visited[nx][ny] && maps[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, depth + 1});
                    }
                }
            }
        }
        
        return -1; // 도달 불가
    }
}
