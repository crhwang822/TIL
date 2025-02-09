class Solution {
    public int solution(int balls, int share) {
        long numer = 1;
        long denom = 1;
        
        for(int i=0; i<share; i++){
            numer *= (balls-i);
            denom *= (i+1);
            if(numer%denom==0){
                numer /= denom;
                denom = 1;
            }
        }
        
        return (int)(numer/denom);
    }
}