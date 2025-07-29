import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n];
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < parent.length; i++)
            parent[i] = i;
        
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        
        for(int i = 0; i < costs.length; i++) {
            int[] arr = costs[i];
            int island = Math.min(arr[0], arr[1]);
            int other = Math.max(arr[0], arr[1]);
            int cost = arr[2];

            if(find(parent, island) != find(parent, other)) {
                answer += cost;
                //union 시킬 때 루트를 찾아서 연결시켜줘야함 
                parent[find(parent, other)] = island;
            }
        }
            
        return answer;
    }
    
    public int find(int[] parent, int x) {
        if(parent[x] != x)
            parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}