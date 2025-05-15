import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        sc.nextLine();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            String str = sc.nextLine();
            int ld = getMaxPos(str.replace("?", "L"));
            int rd = getMaxPos(str.replace("?", "R"));
            System.out.println(Math.max(ld, rd));
		}
    }
    
    public static int getMaxPos(String str) {
        int pos = 0;
        int max = 0;
        
        for(char c : str.toCharArray()) {
            switch(c) {
            case 'L' :
                pos--;
                break;
            case 'R':
                pos++;
                break;
        }
        
        if(Math.abs(pos) > max)
            max = Math.abs(pos);
        }
        
        return max;
    }
    
}
    