import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            List<Double> grades = new ArrayList<>();
            String[] alphabet = new String[]{"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
            for(int i = 0; i < N; i++) 
                grades.add(0.35 * sc.nextInt() + 0.45 * sc.nextInt() + 0.2 * sc.nextInt());
            double temp = grades.get(K - 1);
            Collections.sort(grades, Comparator.reverseOrder());
            int index = grades.indexOf(temp);
            String answer = alphabet[index / (N / 10)];
            System.out.println("#" + testCase + " " + answer);
        }
    }
}