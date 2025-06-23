import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String operation : operations) {
            if(operation.equals("D 1") && !maxQ.isEmpty()) {
                minQ.remove(maxQ.poll());
            }
            else if(operation.equals("D -1") && !minQ.isEmpty()) {
                maxQ.remove(minQ.poll());
            }
            else if(operation.split(" ")[0].equals("I")) {
                int n = Integer.parseInt(operation.split(" ")[1]);
                minQ.add(n);
                maxQ.add(n);
            }
        }
        
        if(minQ.isEmpty() || maxQ.isEmpty())
            return new int[]{0,0};
        
        int[] answer = {maxQ.peek(), minQ.peek()};
        
        
        return answer;
    }
}