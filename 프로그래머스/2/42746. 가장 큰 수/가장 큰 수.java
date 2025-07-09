import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++)
            list.add(numbers[i]);
        
        Collections.sort(list, (o1, o2) -> {
            String s1 = o1+""+o2;
            String s2 = o2+""+o1;
            
            return Integer.parseInt(s1) - Integer.parseInt(s2);
        });
        
        for(int i = list.size() - 1; i >= 0; i--)
            answer += list.get(i);
        
        while(answer.length() != 1 && answer.substring(0,1).equals("0")) 
            answer = answer.substring(1,answer.length());
        
        return answer;
    }
}