import java.lang.Math;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i = 1; i <= number; i++){
            int k = count(i);
            if(k > limit)
                k = power;
            answer += k;
        }
        
        return answer;
    }
    
    public int count(int n){
        int cnt = 0;
        for(int i = 1; i < Math.sqrt(n); i++){
            if(n % i == 0)
                cnt += 2;
        }
        if(Math.sqrt(n) % 1 == 0) cnt++;
        return cnt;
    }
}