import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer,Integer> cake1 = new HashMap<>();
        Map<Integer,Integer> cake2 = new HashMap<>();
        
        for(int i = 0; i < topping.length; i++) {
            cake2.put(topping[i], cake2.getOrDefault(topping[i], 0) + 1);
        }
        
        int i = 0;
        while(cake1.keySet().size() <= cake2.keySet().size()) {
            cake1.put(topping[i], cake1.getOrDefault(topping[i], 0) + 1);
            if(cake2.get(topping[i]) == 1) cake2.remove(topping[i]);
            else cake2.put(topping[i], cake2.get(topping[i]) - 1);
            
            if(cake1.keySet().size() == cake2.keySet().size())
                answer++;
            i++;
        }
        
        return answer;
    }
}