import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        List<Node> queue = new ArrayList<>();
        
        for(int i = 0; i < priorities.length; i++) {
            queue.add(new Node(i, priorities[i]));
        }
        
        while(!queue.isEmpty()) {
            Node max = queue.get(0);
            
            for(int i = 1; i < queue.size(); i++) {
                if(queue.get(i).priority > max.priority)
                    max = queue.get(i);
            }
            
            if(max.index == location)
                break;
            answer++;
            
            Node node = queue.get(0);
            while(node.index != max.index) {
                queue.remove(node);
                queue.add(node);
                node = queue.get(0);
            }
            queue.remove(node);
        }
        
        return answer;
    }
}

class Node {
    public int index;
    public int priority;
    
    public Node(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}