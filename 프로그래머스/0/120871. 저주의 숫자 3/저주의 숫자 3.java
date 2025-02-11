import java.util.List;
import java.util.ArrayList;

class Solution {
    
    public int solution(int n) {
        int answer = 0;
        List<Integer> num = new ArrayList<>(List.of(0));
        int temp = 0;

        for(int i = 1; i<=n; i++){
            temp = num.get(i-1) + 1;
            while(temp % 3 == 0 || String.valueOf(temp).contains("3"))
                temp += 1;
            num.add(temp);
        }
        
        answer = num.get(n);
        return answer;
    }
    
}