import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(begin, 0));
        
        boolean[] visited = new boolean[words.length];
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            
            if(node.str.equals(target)) {
                answer = node.cnt;
                break;
            }
            
            for(int i = 0; i < words.length; i++) {
                if(!visited[i] && compare(node.str, words[i])) {
                    q.offer(new Node(words[i], node.cnt + 1));
                    visited[i] = true;
                }
            }
        }
        
        return answer;
    }
    
    public boolean compare(String s1, String s2) {
        int n = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i))
                n++;
        }
        if(n == 1)
            return true;
        return false;
    }
    
    static class Node {
        String str;
        int cnt;
        
        public Node(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    }
}