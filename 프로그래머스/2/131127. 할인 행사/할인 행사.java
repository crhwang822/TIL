import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        List<String> wish = Arrays.asList(want);
        
        for(int i = 0; i < discount.length - 9; i++) {
            String[] items = Arrays.copyOfRange(discount, i, i + 10);
            if(isIncluded(items, wish, number.clone()))
                answer++;
        }
        
        return answer;
    }
    
    private boolean isIncluded(String[] items, List<String> wish, int[] number) {
        for(String item : items) {
            if(wish.contains(item)) {
                number[wish.indexOf(item)] -= 1;
            }
        }
        
        for(int i = 0; i < number.length; i++)
            if(number[i] > 0)
                return false;
        
        return true;
    }
    
}