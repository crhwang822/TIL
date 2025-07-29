import java.util.*;

class Solution {
    public String solution(String number, int k) {
        List<Integer> stack = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for(char c : number.toCharArray()) {
            int n = c - '0';
            while(!stack.isEmpty() && stack.get(stack.size() - 1) < n && k > 0) {
                stack.remove(stack.size() - 1);
                k--;
            }

            stack.add(n);
        }
        
        
        for(int n : stack) {
            sb.append(n);
        }
        
        String answer = sb.toString();
        
        if(k > 0)
            answer = answer.substring(0, answer.length() - k);
        
        return answer;
    }
}