import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int hindex = 0;
        
        for(int i = 0; i < citations.length; i++) {
            while(hindex <= citations[i] && hindex <= citations.length - i)
                hindex++;
        }
        
        return hindex - 1;
    }
}