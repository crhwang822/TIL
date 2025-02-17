import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        HashMap<String, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < strings.length; i++){
            if(!map.containsKey(strings[i].charAt(n) + ""))
                map.put(strings[i].charAt(n) + "", new ArrayList<>());
            map.get(strings[i].charAt(n) + "").add(i);
        }
        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        
        int idx = 0;
        for(String key : keySet){
            List<Integer> list = map.get(key);
            if(list.size() != 1){
                String[] temp = new String[list.size()];
                for(int i = 0; i < temp.length; i++){
                    temp[i] = strings[list.get(i)];
                }
                Arrays.sort(temp);
                for(String string : temp)
                    answer[idx++] = string;
            }   
            else
                answer[idx++] = strings[list.get(0)];
        }
        return answer;
    }
}