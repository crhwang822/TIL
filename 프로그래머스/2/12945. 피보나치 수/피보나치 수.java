class Solution {
    public int solution(int n) {
        boolean[] visited = new boolean[n + 1];
        int[] arr = new int[n + 1];
        int answer = fib(n, visited, arr) % 1234567;
        
        return answer;
    }
    
    private int fib(int n, boolean[] visited, int[] arr) {
        
        if(n < 2)
            return n;
        
        if(visited[n])
            return arr[n];            
        
        visited[n] = true;
        arr[n] = (fib(n - 2, visited, arr) + fib(n - 1, visited, arr)) % 1234567;
        return arr[n];
    }
}