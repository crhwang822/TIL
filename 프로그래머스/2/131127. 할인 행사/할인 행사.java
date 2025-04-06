import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        List<String> wish = new ArrayList<>();
        
        for(int i = 0; i < want.length; i++) {
            for(int j = 0; j < number[i]; j++)
                wish.add(want[i]);
        }
        
        for(int i = 0; i < discount.length - 9; i++) {
            String[] items = Arrays.copyOfRange(discount, i, i + 10);
            if(isIncluded(items, new ArrayList<>(wish)))
                answer++;
        }
        
        return answer;
    }
    
    private boolean isIncluded(String[] items, List<String> wish) {
        for(String item : items) {
            if(wish.contains(item)) {
                wish.remove(item);
            }
        }

        if(wish.isEmpty())
            return true;
        
        return false;
    }
    
}