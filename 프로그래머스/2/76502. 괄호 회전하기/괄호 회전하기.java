import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String open = "[{(";
        String close = "]})";
        
        if(s.length() % 2 == 1)
            return 0;
        
        
        for(int i = 0; i < s.length(); i++) {
            boolean flag = false;
            int index = 0;
            List<String> stack = new ArrayList<>();
            
            for(int j = i; j < i + s.length(); j++) {
                String str = String.valueOf(s.charAt(j % s.length()));
                
                if(open.contains(str)) {
                    stack.add(str);
                    index++;
                    continue;
                }
                
                if(index > 0 && stack.get(index - 1).equals(String.valueOf(open.charAt(close.indexOf(str))))) {
                    stack.remove(index - 1);
                    index--;
                    continue;
                }
                
                flag = true;
                break;
            }
            
            if(!flag)
                answer++;
        }
        
        return answer;
    }
}