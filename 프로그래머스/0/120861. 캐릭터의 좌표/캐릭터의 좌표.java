class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        int limitX = board[0] / 2;
        int limitY = board[1] / 2;
        
        for(String direction:keyinput){
            switch(direction){
                case "left":
                    answer[0] -= (answer[0] == -limitX)? 0:1;
                    break;
                case "right":
                    answer[0] += (answer[0] == limitX)? 0:1;
                    break;
                case "up":
                    answer[1] += (answer[1] == limitY)? 0:1;
                    break;
                case "down":
                    answer[1] -= (answer[1] == -limitY)? 0:1;
                    break;
            }
        }
        
        return answer;
    }
}