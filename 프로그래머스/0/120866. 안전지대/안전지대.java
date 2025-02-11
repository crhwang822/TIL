import java.lang.Math;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int[][] dangerArea = new int[board.length][board[0].length];
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == 1) mark(dangerArea, i, j);
            }
        }
        
        for(int i=0; i<dangerArea.length; i++){
            for(int j=0; j<dangerArea[0].length; j++){
                if(dangerArea[i][j] == 0) answer++;
            }
        }
        
        return answer;
    }
    
    public void mark(int[][] dangerArea, int x, int y){
        for(int i = Math.max(x-1, 0); i<=Math.min(x+1, dangerArea.length-1); i++){
            for(int j = Math.max(y-1, 0); j<=Math.min(y+1, dangerArea[i].length-1); j++){
                dangerArea[i][j] = 1;
            }
        }
    }
}