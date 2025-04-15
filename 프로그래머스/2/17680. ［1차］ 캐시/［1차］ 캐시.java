import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize == 0)
            return cities.length * 5;
        
        List<String> cache = new ArrayList<>();
        
        for(int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if(cache.contains(city)) {
                cache.remove(city);
                answer += 1;
            } else {
                if(cache.size() >= cacheSize)
                    cache.remove(0);
                answer += 5;
            }
            cache.add(city);
        }
        
        return answer;
    }
}