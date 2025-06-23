class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int len = triangle.length;
        int[][] table = new int[len][triangle[len-1].length];
        table[0][0] = triangle[0][0];
        for(int i = 1; i < triangle.length; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                if(j == 0)
                    table[i][j] = table[i-1][j];
                else if(j == triangle[i].length - 1) 
                    table[i][j] = table[i-1][j-1];
                else {
                    int a = table[i-1][j-1];
                    int b = table[i-1][j];
                    table[i][j] = Math.max(a, b);
                }
                table[i][j] += triangle[i][j];  
            }
        }
        
        for(int i = 0; i < triangle[len-1].length; i++) {
            answer = Math.max(answer, table[len-1][i]);
        }
        return answer;
    }
}