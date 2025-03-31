import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> cart = new ArrayList<>();
        
        for(int j : moves) {
            int i = 0;
            do {
                if(board[i][j - 1] != 0) { //꼭대기 층부터 탐색
                    
                    //방금 뽑은 인형과 장바구니 상위에 있는 인형이 동일한 경우
                    if(!cart.isEmpty() && board[i][j - 1] == cart.get(cart.size() - 1)) {
                        answer += 2;
                        cart.remove(cart.size() - 1);
                    } else {
                        cart.add(board[i][j - 1]);
                    }
                    board[i][j - 1] = 0;
                    break;
                } 
                i++;  //한 층씩 내려감
            } while(i != board.length);
        }
        return answer;
    }
}