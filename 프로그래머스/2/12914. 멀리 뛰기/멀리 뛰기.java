class Solution {
    public long solution(int n) {
        boolean[] visited = new boolean[n];
        int[] arr = new int[n];
        
        int answer = count(n, visited, arr) % 1234567;
        
        return answer;
    }
    
    private int count(int n, boolean[] visited, int[] arr) {
        
        if(n < 3) 
            return n;
        
        if(visited[n- 1])
            return arr[n - 1];
        visited[n - 1] = true;
        arr[n - 1] = (count(n - 1, visited, arr) + count(n - 2, visited, arr)) % 1234567;
        return arr[n - 1];
    }
}