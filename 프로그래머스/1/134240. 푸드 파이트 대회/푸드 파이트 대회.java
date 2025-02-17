import java.lang.StringBuilder;

class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        int count = 0;
        for(int i = 1; i < food.length; i++) {
            sb.insert(count/2, (i+"").repeat(food[i] - food[i] % 2));
            count += food[i] - food[i] % 2;
        }
        sb.insert(count/2, "0");
        String answer = sb.toString();
        
        return answer;
    }
}