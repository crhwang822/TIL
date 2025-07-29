import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n];
        
        for (int i = 0; i < n; i++)
            parent[i] = i;
        
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        for (int[] edge : costs) {
            int a = edge[0];
            int b = edge[1];
            int cost = edge[2];
            
            if (find(parent, a) != find(parent, b)) {
                answer += cost;
                union(parent, a, b);
            }
        }
        
        return answer;
    }
    
    private int find(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]);
        return parent[x];
    }
    
    private void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }
}
