import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] cnt = new int[3];
        int[] ans1 = {1,2,3,4,5};
        int[] ans2 = {2,1,2,3,2,4,2,5};
        int[] ans3 = {3,3,1,1,2,2,4,4,5,5};
        
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == ans1[i % 5])
                cnt[0]++;
            if(answers[i] == ans2[i % 8])
                cnt[1]++;
            if(answers[i] == ans3[i % 10])
                cnt[2]++;
        }
        
        List<Integer> list = new ArrayList<>();
        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        
        for(int i = 0; i < 3; i++){
            if(max == cnt[i]) list.add(i + 1);
        }
        
        Collections.sort(list);
        int[] arr = new int[list.size()];
        
        for(int i = 0; i < arr.length; i++){
            arr[i] = list.get(i);
        }
        
        return arr;
    }
}