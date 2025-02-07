import java.util.Arrays;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int[] mode = new int[1001];
        for(int i=0; i<array.length; i++){
            mode[array[i]] += 1;
            if(mode[array[i]] > mode[answer])
                answer = array[i];
        }
        Arrays.sort(mode);
        if(mode[999] == mode[1000])
            answer = -1;
        return answer;
    }
}