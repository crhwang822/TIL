class Solution {
    
    int solution(int[][] land) {
        
        /* dp[i][j]를 'i-1번째 행까지 최선의 선택을 했다고 가정하고, 
        ** land[i][j]를 선택했을 때 얻을 수 있는 점수의 총합' 이라고 정의 */
        int[][] dp = new int[land.length][land[0].length];
        
        for(int i = 0; i < 4; i++)
            dp[0][i] = land[0][i];
        
        for(int i = 1; i < land.length; i++) {
            dp[i][0] = land[i][0] + max(dp[i-1][1], dp[i-1][2], dp[i-1][3]);
            dp[i][1] = land[i][1] + max(dp[i-1][0], dp[i-1][2], dp[i-1][3]);
            dp[i][2] = land[i][2] + max(dp[i-1][1], dp[i-1][0], dp[i-1][3]);
            dp[i][3] = land[i][3] + max(dp[i-1][1], dp[i-1][2], dp[i-1][0]);
        }
        
        int last = dp.length - 1;
        int answer = Math.max(Math.max(dp[last][0], dp[last][1]), 
                              Math.max(dp[last][2], dp[last][3]));
        return answer;
    }
    
    public int max(int a, int b, int c) {
        return Math.max(Math.max(a,b), c);
    }
}