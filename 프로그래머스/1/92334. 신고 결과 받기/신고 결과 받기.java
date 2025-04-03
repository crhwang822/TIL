import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Set<String>> map = new HashMap<>();
        List<String> ids = new ArrayList<>();
        
        for(String id : id_list) {
            ids.add(id);
        }
        
        for(String str : report) {
            String userId = str.split(" ")[0];
            String reportedId = str.split(" ")[1];
            
            if(!map.containsKey(reportedId)) {
                map.put(reportedId, new HashSet<>()); 
            }
            map.get(reportedId).add(userId);
        }
        
        for(String id : ids) {
            if(!map.containsKey(id))
                continue;
            
            if(map.get(id).size() < k)
                continue;
            
            for(String user : map.get(id)) {
                answer[ids.indexOf(user)]++;
            }
        }
        
        return answer;
    }
}