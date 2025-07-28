import java.util.*;

class Solution {
    static Map<Integer, List<Integer>> connectionMap = new HashMap<>();
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        //노드 간 연결 정보 저장
        for(int[] arr : wires) {
            if(!connectionMap.containsKey(arr[0])) {
                connectionMap.put(arr[0], new ArrayList<>());
            }
            if(!connectionMap.containsKey(arr[1])) {
                connectionMap.put(arr[1], new ArrayList<>());
            }
            connectionMap.get(arr[0]).add(arr[1]);
            connectionMap.get(arr[1]).add(arr[0]);
        }
        
        for(int[] arr : wires) {
            boolean[] visited = new boolean[n];
            List<Integer> q = new ArrayList<>();
            int cnt = 0;
            q.add(arr[0]);
            
            //bfs
            do {
                int target = q.get(0);
                visited[target - 1] = true;
                cnt++;
                for(int num : connectionMap.get(target)) {
                    if(!visited[num-1] && num != arr[1])
                        q.add(num);
                }
                q.remove(0);
            }while(!q.isEmpty());
            
            int other = n - cnt;
            answer = Math.min(answer, Math.abs(cnt - other));
        } 
        
        return answer;
    }
}