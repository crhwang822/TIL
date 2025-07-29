import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = Integer.MAX_VALUE;
        int currentPos = 0;
        int length = name.length();
        
        List<int[]> letter = new ArrayList<>();
        for(int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if(c == 'A')
                continue;
            letter.add(new int[]{i, (int)c - 'A'});
        }
        
        for(int i = 0; i < length; i++) {
            int temp = count(new ArrayList<>(letter), i, length);
            temp += Math.min(i, length - i);
            answer = Math.min(answer, temp);
        }
        
        if(answer == Integer.MAX_VALUE)
            return 0;
        
        return answer;
    }
    
    public int count(List<int[]> letter, int currentPos, int length) {
        int val = 0;
        while(!letter.isEmpty()) {
            int minAction = Integer.MAX_VALUE;
            int idx = 0;
            for(int i = 0; i < letter.size(); i++) {
                int[] l = letter.get(i);
                int pos = Math.abs(l[0] - currentPos);
                int action = Math.min(pos, length - pos);
                if(action < minAction) {
                    minAction = action;
                    idx = i;
                }
            }
            
            currentPos = letter.get(idx)[0];
            val += minAction + Math.min(letter.get(idx)[1], 26 - letter.get(idx)[1]);
            letter.remove(idx);
        }
        return val;
    }
    
}