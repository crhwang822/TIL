class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int s = 0;
        int e = n - 1;
        int val = 1;
        
        while(val <= n*n){
            for(int i = s; i <= e; i++){
                answer[s][i] = val++;
            }
            for(int i = s+1; i <= e; i++){
                answer[i][e] = val++;
            }
            for(int i = e-1; i >= s; i--){
                answer[e][i] = val++;
            }
            for(int i = e-1; i > s; i--){
                answer[i][s] = val++;
            }
            s++;
            e--;
        }
        
        
        return answer;
    }
}