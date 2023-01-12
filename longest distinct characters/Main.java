import java.io.*;
import java.util.*;

class Solution {
    public static int longestUniqueSubsttr(String str)
    {
        int i = 0, j = 0, len = 0;
		int[] freq = new int[123];

		while(j<str.length() && i<str.length()){
			//expansion
			freq[str.charAt(j)]++;
			j++;

			//contraction
			while(i<j && freq[str.charAt(j-1)]>1){
				
				freq[str.charAt(i)]--;
				i++;
			}

			//calculation
			len = Math.max(len,j-i);
		}

		return len;
    }
}

public class Main {
     public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Solution obj = new Solution();
        int len = obj.longestUniqueSubsttr(str);
        System.out.println(len);
    }
}

