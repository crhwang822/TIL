import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        int[] count = new int[10];
        
        for(char c : numbers.toCharArray()) {
            int n = Integer.parseInt(c + "");
            count[n]++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 9; i >= 0; i--) {
            for(int j = 0; j < count[i]; j++) 
                sb.append(i);
        }
        
        int maxValue = Integer.parseInt(sb.toString());
        
        List<Integer> primes = findPrimes(maxValue);
        
        for(int i = 0; i < primes.size(); i++) {
            if(canMake(count.clone(), primes.get(i))) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean canMake(int[] count, int num) {
        String str = String.valueOf(num);
        for(char c : str.toCharArray()) {
            count[Integer.parseInt(c+"")]--;
            if(count[Integer.parseInt(c+"")] < 0)
                return false;
        }
        return true;
    }
    
    public List<Integer> findPrimes(int n) {
        boolean[] isNotPrime = new boolean[n + 1];
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(!isNotPrime[i]) {
                for(int j = i * i; j <= n; j += i)
                    isNotPrime[j] = true;
            }
        }
        List<Integer> li = new ArrayList<>();
        for(int i = 2; i < isNotPrime.length; i++) {
            if(!isNotPrime[i])
                li.add(i);
        }
        return li;
    }
}