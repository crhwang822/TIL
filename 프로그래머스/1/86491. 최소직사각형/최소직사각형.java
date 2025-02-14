import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxW = 0;
        int maxH = 0;
        
        for(int[] size : sizes){
            Arrays.sort(size);
            if(size[0] > maxW) maxW = size[0];
            if(size[1] > maxH) maxH = size[1];
        }
        
        answer = maxW * maxH;
        
        return answer;
    }
}