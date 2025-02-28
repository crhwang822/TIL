class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int w = wallet[0];
        int h = wallet[1];
        
        while(!((bill[0] <= w && bill[1] <= h) || (bill[0] <= h && bill[1] <= w))){
            int idx = bill[0] > bill[1]? 0 : 1;
            bill[idx] /= 2;
            answer++;
        }
        
        return answer;
    }
}