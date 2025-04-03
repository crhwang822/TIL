import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        int max = 0;
        
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[0].length; j++) {
                if(park[i][j].equals("-1")) {
                    while(isSquare(park, i, j, max)) max++;
                }
            }
        }
        
        Arrays.sort(mats);
        
        for(int i = mats.length - 1; i >= 0; i--) {
            if(max >= mats[i]) return mats[i];
        }
        
        return answer;
    }
    
    private boolean isSquare(String[][] park, int i, int j, int len) {
        if(i + len >= park.length || j + len >= park[0].length) 
            return false;
        
        for(int m = i; m < i + len + 1; m++) {
            for(int n = j; n < j + len + 1; n++) {
                if(!park[m][n].equals("-1")) return false;
            }
        }
        
        return true;
        
        
    }
}