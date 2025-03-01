import java.lang.StringBuilder;
import java.lang.Character;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public String solution(String s, String skip, int index) {
        List<Character> skipList = new ArrayList<>();
        for(char c : skip.toCharArray()){
            skipList.add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            int tmp = 0;
            while(tmp < index){
                c = (char)((c - 'a' + 1) % 26 + 'a');
                if(!skipList.contains(c)) tmp++;
            }
            sb.append(c);
        }
        
        String answer = sb.toString();
        return answer;
    }
}