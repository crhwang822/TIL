import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        List<String> list = new ArrayList<>();
        list.add(words[0].substring(0,1));
        
        int i = 0;
        
        for(String word : words) {
            if(word.length() == 1)
                break;
            if(list.indexOf(word) != -1)
                break;
            if(list.get(i).charAt(list.get(i).length() - 1) != word.charAt(0))
                break;
            list.add(word);
            i++;
        }
        
        if(list.size() - 1 == words.length)
            return new int[]{0,0};

        int[] answer = {i % n + 1, i / n + 1};
        
        return answer;
    }
}