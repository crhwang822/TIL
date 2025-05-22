import java.util.Scanner;
import java.lang.Math;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int testCase = 1; testCase <= T; testCase++) {
            //입력
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            int[] arrN = new int[n];
            int[] arrM = new int[m];
            
            for(int i = 0; i < n; i++)
                arrN[i] = sc.nextInt();
            
            for(int i = 0; i < m; i++)
                arrM[i] = sc.nextInt();
            
            //구현
            int answer = 0; 
            int[] longer = n >= m? arrN.clone() : arrM.clone();
            int[] shorter = n >= m? arrM.clone() : arrN.clone();
            int len = Math.max(n,m) - Math.min(n,m);
            for(int i = 0; i <= len; i++) {
                int temp = 0;
                for(int j = 0; j < shorter.length; j++)
                    temp += (shorter[j] * longer[i + j]);
                answer = Math.max(answer, temp);
            }
            
            //출력
            System.out.println("#" + testCase + " " + answer);
        }
    }
}