import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int testCase = 1;  testCase <= T; testCase++) {
            int pm = sc.nextInt();
            int pd = sc.nextInt();
            int nm = sc.nextInt();
            int nd = sc.nextInt();
            
            int answer = 0;
            int[] days = new int[]{0, 31,28,31,30,31,30,31,31,30,31,30,31};
            
            if(pm == nm)
                answer = nd - pd + 1;
            else {
                answer += (days[pm] - pd + 1) + nd;
                for(int i = pm + 1; i < nm; i++)
                    answer += days[i];
            }
            
            System.out.println("#" + testCase + " " + answer);
        }
    }
}