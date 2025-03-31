import java.lang.StringBuilder;
import java.lang.Math;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        String direction = "LR";
        int[] hands = {10,12};
        int idx = -1;
        
        for(int n : numbers) {
            if(n == 0) n = 11;
            //눌러야 하는 번호가 1, 4, 7
            if(n % 3 == 1) {
                idx = 0;
            }
            //눌러야 하는 번호가 3, 6, 9
            else if(n % 3 == 0) {
                idx = 1;
            }
            //눌러야 하는 번호가 2, 5, 8, 0
            else {
                int ld = distance(n, hands[0]);
                int rd = distance(n, hands[1]);
                
                if(ld == rd) {
                    idx = direction.indexOf(hand.substring(0,1).toUpperCase());
                } else if(ld < rd) {
                    idx = 0;
                } else {
                    idx = 1;
                }
            }
            sb.append(direction.charAt(idx));
            hands[idx] = n;
        }
        
        
        String answer = sb.toString();
        return answer;
    }
    
    public int distance(int n, int thumb) {
        if(n == thumb) return 0;
        int d = Math.abs(n - thumb);
        if(d % 2 == 0) {
            if(d < 8) return 2;
            else return 4;
        } else {
            if (d < 4) return 1;
            else return 3;
        }
    }
}