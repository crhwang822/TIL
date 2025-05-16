import java.util.*;

public class Solution {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        //각각의 테스트 케이스 시작
        for(int i = 0; i < T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();
            int answer = 0;
            
            while(a <= n && b <= n) {
                answer++;
                if(a >= b)
                    b += a;
                else
                    a += b;
            }
            
            System.out.println(answer);
            
        }
    }
}