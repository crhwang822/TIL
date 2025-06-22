import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] network = new int[n];
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++) {
            if(network[i] == 0) {
                network[i] = ++answer;
                q.add(i);
            }
            else
                continue;
            while(!q.isEmpty()) {
                int k = q.poll();
                for(int j = 0; j < n; j++) {
                    if(computers[k][j] == 1) {
                        if(network[j] == 0) {
                            q.add(j);
                            network[j] = network[k];
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}