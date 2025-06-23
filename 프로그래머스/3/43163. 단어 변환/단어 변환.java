import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        List<String> list = new ArrayList<>();
        list.add(begin);
        for(int i = 0; i < words.length; i++)
            list.add(words[i]);
        
        if(!list.contains(target))
            return answer;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            if(list.get(temp[0]).equals(target)) {
                answer = temp[1];
                break;
            }
            for(int i = 1; i < list.size(); i++) {
                if(temp[0] == i)
                    continue;
                if(compare(list.get(temp[0]), list.get(i)))
                    q.offer(new int[]{i, temp[1] + 1});
            }
        }
        
        return answer;
    }
    
    boolean compare(String s1, String s2) {
        int n = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i))
                n++;
        }
        if(n == 1)
            return true;
        return false;
    }
}