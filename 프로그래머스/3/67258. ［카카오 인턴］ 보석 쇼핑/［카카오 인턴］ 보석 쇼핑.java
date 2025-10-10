import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        
        List<int[]> sections = new ArrayList<>();
        int[] answer = new int[2];
        
        PriorityQueue<String[]> pq = new PriorityQueue<>(
            (a,b)-> Integer.parseInt(a[1]) - Integer.parseInt(b[1]));
        
        Set<String> set = new HashSet<>();
        for(int i = 0; i < gems.length; i++) {
            set.add(gems[i]);
        }
        
        Map<String, Integer> indexMap = new HashMap<>();
        
        int cnt = 0;
        for(int i = 0; i < gems.length; i++) {
            String gem = gems[i];
            if(!indexMap.containsKey(gem)) {
                pq.add(new String[]{gem, String.valueOf(i)});
                indexMap.put(gem, i);
                cnt++;
            } else {
                if(pq.peek()[0].equals(gem)) {
                    pq.poll();
                    pq.add(new String[]{gem, String.valueOf(i)});
                }
                indexMap.replace(gem, i);
            }
            
            while(cnt == set.size()) {
                String[] cur = pq.poll();
                sections.add(new int[]{Integer.parseInt(cur[1]), i});
                cnt--;
                if(indexMap.get(cur[0]) > Integer.parseInt(cur[1])) {
                    pq.add(new String[]{cur[0], indexMap.get(cur[0]).toString()});
                    cnt++;
                } else {
                    indexMap.remove(cur[0]);
                }
            }
            
        }
        
        Collections.sort(sections, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] - o1[0] != o2[1] - o2[0]) {
                    return (o1[1] - o1[0]) - (o2[1] - o2[0]);
                }
                return o1[0] - o2[0];
            }
        });
        
        answer = sections.get(0);
        
        
        answer[0] += 1;
        answer[1] += 1;
        return answer;
    }
}