import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public String solution(String s) {
        String answer = "";
        List<String> list = new ArrayList<>();
        
        for(int i=0; i<s.length(); i++){
            if(i == s.indexOf(s.charAt(i)))
                list.add(String.valueOf(s.charAt(i)));
            else
                list.remove(String.valueOf(s.charAt(i)));
        }
        
        String[] arr = list.toArray(new String[list.size()]);
        Arrays.sort(arr);
        answer = String.join("", arr);
        
        return answer;
    }
}