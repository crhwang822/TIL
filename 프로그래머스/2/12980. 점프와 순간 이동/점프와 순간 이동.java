import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = usage(n);

        return ans;
    }
    
    private int usage(int n) {
        while(n % 2 == 0)
            n = n / 2;
        if(n == 1)
            return 1;
        else return usage(n - 1) + 1;
    }
}