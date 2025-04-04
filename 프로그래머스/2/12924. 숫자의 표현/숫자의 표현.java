class Solution {
    public int solution(int n) {
        int answer = 0;
        int i = 1;
        
        while(true) {
            
            if(i % 2 == 0) {
                if((n - i / 2) / i - (i / 2 - 1) <= 0)
                    break;
                if((n - i / 2) % i == 0)
                    answer++;
            } else {
                if((n / i) - (i / 2) <= 0)
                    break;
                if(n % i == 0)
                    answer++;
            }
            
            i++;
        }
        
        return answer;
    }
}