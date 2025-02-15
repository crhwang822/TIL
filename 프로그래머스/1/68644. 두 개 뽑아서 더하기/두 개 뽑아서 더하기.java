import java.util.HashSet;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < numbers.length; i++)
            for(int j = 0; j < numbers.length; j++){
                if(i == j) continue;
                set.add(numbers[i] + numbers[j]);
            }
        int[] answer = set.stream().sorted().mapToInt(i-> i).toArray();
        return answer;
    }
}