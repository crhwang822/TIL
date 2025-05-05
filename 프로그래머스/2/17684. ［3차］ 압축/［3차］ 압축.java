import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> ans = new ArrayList<>();
        
        List<String> dict = new ArrayList<>();
        String alphabet = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i = 0; i < alphabet.length(); i++) {
            dict.add(alphabet.substring(i, i + 1));
        }
        while(msg.length() > 0) {
            int index = 1;
            while(msg.length() >= index && dict.contains(msg.substring(0, index)))
                index++;
            String w = msg.substring(0, index - 1);
            ans.add(dict.indexOf(w));
            msg = msg.replaceFirst(w, "");
            if(msg.length() != 0) {
                String c = msg.substring(0, 1);
                dict.add(w + c);
            }
        }
        
        int[] answer = new int[ans.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = ans.get(i);
        }
        
        
        return answer;
    }
}