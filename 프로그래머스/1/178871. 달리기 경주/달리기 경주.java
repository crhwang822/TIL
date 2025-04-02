import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for(String name : callings) {
            int i = map.get(name);
            String tmp = players[i - 1];
            players[i - 1] = name;
            players[i] = tmp;
            
            map.replace(name, i - 1);
            map.replace(tmp, i);
        }
         
        return players;
    }
}