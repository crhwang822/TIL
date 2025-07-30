import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        for(int i = 1; i < 9; i++) {
            int temp = Integer.parseInt("1".repeat(i));
            map.put(i, new HashSet<>());
            Set<Integer> set = map.get(i);
            set.add(temp * N);
            for(int j = 1; j <= i - 1; j++) {
                Set<Integer> o1 = map.get(j);
                Set<Integer> o2 = map.get(i - j);
                for(int a : o2) {
                    for(int b : o1) {
                        if(a + b != 0)
                            set.add(a+b);
                        if(a - b != 0)
                            set.add(a-b);
                        set.add(a*b);
                        if(a / b != 0)
                            set.add(a/b);
                    }
                }
            }
            if(set.contains(number)) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}