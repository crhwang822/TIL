import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int time = 0;
        boolean flag = false;
        int index = 0;
        int remainTime = 0;
        
        int answer = 0; 
        
        Arrays.sort(jobs, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2] != o2[2])
                    return o1[2] - o2[2];
                if(o1[1] != o2[1])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        
        
        do {
            while(index < jobs.length && jobs[index][0] <= time) {
                pq.add(new int[]{index, jobs[index][0], jobs[index][1]});
                index++;
            }
            
            if(pq.isEmpty()) {
                time++;
            } else {
                int[] job = pq.poll();
                answer += (time + job[2] - job[1]); 
                time += job[2];
            }
              
        }while(index < jobs.length || !pq.isEmpty());
        
        return answer / jobs.length;
    }
    
}