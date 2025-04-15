//DFS 풀이

class Solution {
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        
        int answer = dfs(0, visited, dungeons, k);
        
        return answer;
    }
    
    private int dfs(int depth, boolean[] visited, int[][] dungeons, int k) {
        int max = depth;
        for(int i = 0; i < dungeons.length; i++) {
            if(visited[i])
                continue;
            if(dungeons[i][0] > k)
                continue;
            visited[i] = true;
            max = Math.max(max, 
                             dfs(depth + 1, visited, dungeons, k - dungeons[i][1]));
            visited[i] = false;
        }
        return max;
    }
}