import java.util.*;
import java.lang.*;

class Solution {
    
    public static List<String> combList = new ArrayList<>();
    
    public String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for(int i = 0; i < course.length; i++) {
            countMap.put(course[i], 0);
        }
        
        for(int i = 0; i < orders.length; i++) {
            String order = orders[i];
            
            for(int j = 0; j < course.length; j++) {
                int len = course[j];
                if(order.length() < len)
                    break;
                
                boolean[] selected = new boolean[order.length()];
                combi(order, 0, len, selected);
                
                //코스요리 후보 카운팅
                for(int k = 0; k < combList.size(); k++) {
                    map.put(combList.get(k), 
                            map.getOrDefault(combList.get(k), 0) + 1);
                }
                combList.clear();
            }
        }
        
        int max = 0;
        //map 조회
        for(String key : map.keySet()) {
            int count = map.get(key);
            if(count > countMap.get(key.length()))
                countMap.replace(key.length(), count);
        }
        
        for(String key : map.keySet()) {
            int count = map.get(key);
            if(count == countMap.get(key.length()) && count > 1) {
                list.add(key);
            }
        }
        
        Collections.sort(list);
        
        String[] answer = new String[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public static void combi(String str, int n, int r, boolean[] selected) {
        if(r == 0) {
            String temp = "";
            for(int i = 0; i < selected.length; i++) {
                if(selected[i])
                    temp += str.charAt(i);
            }
            char[] tempArr = temp.toCharArray();
            Arrays.sort(tempArr);
            temp = new String(tempArr);
            combList.add(temp);
            return;
        }
        if(n == str.length())
            return;
        selected[n] = true;
        combi(str, n + 1, r - 1, selected);
        selected[n] = false;
        combi(str, n + 1, r, selected);
    }

}