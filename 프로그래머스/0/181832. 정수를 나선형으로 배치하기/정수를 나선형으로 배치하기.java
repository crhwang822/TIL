class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        String[] direction = {"right", "down", "left", "up"};
        int row = 0;
        int column = 0;
        int val = 1;
        int idx = 0;
        int round = 0;
        
        while(val <= n*n){
            switch(direction[idx]){
                case "right":
                    while(column < n - round)
                        answer[row][column++] = val++;
                    column--;
                    row++;
                    break;
                case "down":
                    while(row < n - round)
                        answer[row++][column] = val++;
                    row--;
                    column--;
                    break;
                case "left":
                    while(column >= 0 + round)
                        answer[row][column--] = val++;
                    column++;
                    row--;
                    round++;
                    break;
                case "up":
                    while(row >= 0 + round)
                        answer[row--][column] = val++;
                    row++;
                    column++;
                    break;
            }
            idx = (++idx) % 4;
        }
        
        
        return answer;
    }
}