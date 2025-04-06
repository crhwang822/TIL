import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int sum = 0;
        int index = 1;
        Set<Integer> set = new HashSet<>();
        int[] arr = Arrays.copyOfRange(elements, 0, elements.length);
        
        for(int i = 0; i < elements.length; i++) 
            sum += elements[i];
        
        
        for(int i = 0; i < elements.length / 2; i++) {
            for(int j = 0; j < elements.length; j++) {
                set.add(elements[j]);
                set.add(sum - elements[j]);
                elements[j] += arr[(j + index) % arr.length];
            }
            index++;
        }

        set.add(sum);
        int answer = set.size();
        
        return answer;
    }
}