import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        for(int testCase = 1; testCase <= T; testCase++) {
            
            System.out.println("#" + testCase);
            int n = sc.nextInt();
        	int temp = 0;
            
            for(int i = 0; i < n; i++) {
                sc.nextLine();
                String s = sc.next();
                int c = sc.nextInt();
                for(int j = 0; j < c; j++) {
                    if(temp == 10) {
                        System.out.println();
                        temp = 0;
                    }
                    System.out.print(s);
                	temp++;
                }
            }
        	System.out.println();
            
        }
    }
}