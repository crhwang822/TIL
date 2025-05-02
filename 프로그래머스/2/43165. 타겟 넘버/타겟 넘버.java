class Solution {
    int answer = 0; 
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return answer;
    }
    
    public void dfs(int[] numbers, int sum, int index, int target) {
        if(index == numbers.length) {
            if(sum == target)
                answer++;
            return;
        }
        
        dfs(numbers, sum + numbers[index], index + 1, target);
        dfs(numbers, sum - numbers[index], index + 1, target);
    }
}