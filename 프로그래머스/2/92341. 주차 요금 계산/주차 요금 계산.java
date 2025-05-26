import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, int[]> map = new HashMap<>();
        
        for(String record : records) {
            String[] info = record.split(" ");
            String type = info[2];
            int car = Integer.parseInt(info[1]);
            int h = Integer.parseInt(info[0].split(":")[0]);
            int m = Integer.parseInt(info[0].split(":")[1]);
            
            if(type.equals("IN")) {
                if(!map.containsKey(car))
                    map.put(car, new int[3]);
                map.get(car)[0] = h;
                map.get(car)[1] = m;
            } else {
                int[] arr = map.get(car);
                arr[2] += getMinutes(arr[0], arr[1], h, m);
                arr[0] = -1;
            }
        }
        
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        int[] answer = new int[keys.size()];
        
        for(int i = 0; i < answer.length; i++) {
            int[] arr = map.get(keys.get(i));
            int fee = fees[1];
            if(arr[0] != -1)
                arr[2] += getMinutes(arr[0], arr[1], 23, 59);
            if(arr[2] > fees[0])
                fee += (((arr[2] - fees[0] - 1) / fees[2]) + 1) * fees[3];
            answer[i] = fee;
        }
        
        return answer;
    }
    
    public int getMinutes(int inH, int inM, int outH, int outM) {
        if(inH == outH)
            return outM - inM;
        int minutes = 0;
        for(int i = inH + 1; i < outH; i++)
            minutes += 60;
        minutes += (60 - inM) + outM;
        return minutes;
    }
}