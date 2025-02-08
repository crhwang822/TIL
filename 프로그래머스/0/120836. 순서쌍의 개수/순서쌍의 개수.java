import java.lang.Math;
import java.util.HashSet;

class Solution {
    public int solution(int n) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=1; i<=Math.sqrt(n); i++){
            if(n%i==0){
                set.add(i);
                set.add(n/i);
            }
        }
        
        return set.size();
    }
}