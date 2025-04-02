import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> expired = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int[] criteria = new int[3];
        
        //today : String -> int[]
        for(int i = 0; i < criteria.length; i++) {
            criteria[i] = Integer.parseInt(today.split("[.]")[i]);
        }
        
        //약관별 유효기간 저장
        for(String str : terms) {
            map.put(str.split(" ")[0], Integer.parseInt(str.split(" ")[1]));
        }
        
        for(int i = 0; i < privacies.length; i++) {
            
            //개인정보 수집 일자 : String -> int[]
            String[] tmp = privacies[i].split(" ")[0].split("[.]");
            int[] date = new int[3];
            for(int j = 0; j < date.length; j++) {
                date[j] = Integer.parseInt(tmp[j]);
            }
            
            //유효기간 계산
            date = afterMonth(date, map.get(privacies[i].split(" ")[1]));
            
            for(int k : date)
                System.out.print(k + " ");
            System.out.println();
            
            //유효기간이 지났는지 검사
            if(isExpired(criteria, date)) expired.add(i + 1);
        }
        
        //List -> array 변환
        int[] answer = new int[expired.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = expired.get(i);
        }
        
        return answer;
    }
    
    private boolean isExpired(int[] criteria, int[] date) {
        if(criteria[0] > date[0])
            return true;
        if(criteria[0] < date[0])
            return false;
        
        if(criteria[1] > date[1])
            return true;
        if(criteria[1] < date[1])
            return false;
        
        if(criteria[2] > date[2])
            return true;
        
        return false;
        
    }
    
    private int[] afterMonth(int[] date, int month) {
        
        date[2] = date[2] == 1? 28 : date[2] - 1;
        date[0] += (date[1] + month - 1) / 12;
        date[1] = (date[1] + month) % 12 == 0? 12 : (date[1] + month) % 12;
        date[1] -= date[2] / 28;
        
        return date;
    }
    
}