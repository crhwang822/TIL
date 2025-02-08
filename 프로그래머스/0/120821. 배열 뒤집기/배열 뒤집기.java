import java.util.Collections;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        int j = num_list.length - 1;
        for(int i=0; i<num_list.length/2; i++){
            int temp = num_list[j];
            num_list[j] = num_list[i];
            num_list[i] = temp;
            j--;
        }
        return num_list;
    }
}