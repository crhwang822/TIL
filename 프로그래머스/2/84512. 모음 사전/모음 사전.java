import java.util.*;

class Solution {
    public int solution(String word) {
        List<String> dict = new ArrayList<>();
        dfs(dict, "");
        int answer = dict.indexOf(word);
        return answer;
    }
    
    public void dfs(List<String> dict, String word) {
        
        dict.add(word);
        
        if(word.length() == 5)
            return;
        String alphabet = "AEIOU";
        for(int i = 0; i < alphabet.length(); i++) {
            dfs(dict, word + String.valueOf(alphabet.charAt(i)));
        }
    }
}