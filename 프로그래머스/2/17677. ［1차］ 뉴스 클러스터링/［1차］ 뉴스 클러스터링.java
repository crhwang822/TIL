import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        Set<String> elems = new HashSet<>();
        
        double intersection = 0;
        double union = 0;
        
        str1 = str1.toLowerCase().replaceAll("[^a-z]", " ");
        str2 = str2.toLowerCase().replaceAll("[^a-z]", " ");
        
        for(int i = 0; i < str1.length() - 1; i++) {
            String elem = str1.substring(i, i + 2);
            if(elem.contains(" ")) continue;
            elems.add(elem);
            if(!map1.containsKey(elem))
                map1.put(elem, 1);
            else map1.replace(elem, map1.get(elem) + 1);
        }
        
        for(int i = 0; i < str2.length() - 1; i++) {
            String elem = str2.substring(i, i + 2);
            if(elem.contains(" ")) continue;
            elems.add(elem);
            if(!map2.containsKey(elem))
                map2.put(elem, 1);
            else map2.replace(elem, map2.get(elem) + 1);
        }
        
        if(map1.isEmpty() && map2.isEmpty()) {
            return 65536;
        }
        
        for(String elem : elems) {
            int a = map1.getOrDefault(elem, 0);
            int b = map2.getOrDefault(elem, 0);
            
            intersection += Math.min(a,b);
            union += Math.max(a,b);
        }
        
        int answer = (int)((intersection / union) * 65536);
        return answer;
    }
}