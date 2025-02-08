import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        int even = (int) Arrays.stream(num_list).filter(i-> i%2==0).count();
        int odd = (int) Arrays.stream(num_list).filter(i-> i%2==1).count();
        
        return new int[]{even, odd};
    }
}