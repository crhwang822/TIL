import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        
        for(int[] command : commands){
            int[] subArray = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(subArray);
            answer[idx++] = subArray[command[2] - 1];
        }
        
        return answer;
    }
}