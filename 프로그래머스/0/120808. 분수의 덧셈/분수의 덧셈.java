class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = {};
        numer1 *= denom2;
        numer2 *= denom1;
        int denom = denom1 * denom2;
        int numer = numer1 + numer2;
        int gcd = getGcd(denom,numer);
        answer = new int[] {numer / gcd, denom / gcd};
        return answer;
    }
    
    public int getGcd(int a, int b){
        if (b == 0)
            return a;
        else
            return getGcd(b, a % b);
    }
}