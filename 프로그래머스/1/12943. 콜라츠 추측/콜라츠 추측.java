class Solution {
    
    public int solution(int num) {
        int i = 0;
        
        long n = (long) num;
        
        while(n != 1){
            if(n % 2 == 0)
                n = n / 2;
            else
                n = 3 * n + 1;
            if(i++ == 500)
                return -1;
        }
        
        return i;
    }
}