import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int i = 1; i <= T; i++) { 
            int n = sc.nextInt();
            Queue<Integer> q = new LinkedList<>();
            q.add(0);
            q.add(1);
            q.add(0);
            
            System.out.println("#" + i);
            System.out.println(1);
            for(int j = 1; j < n; j++) {
                for(int k = 0; k < j + 1; k++) {
                    int temp = q.poll() + q.peek();
                    System.out.print(temp);
                    System.out.print(" ");
                    q.add(temp);
                }
                q.add(0);
                System.out.println();
            }
            
        }
        
        sc.close();
    }
}
