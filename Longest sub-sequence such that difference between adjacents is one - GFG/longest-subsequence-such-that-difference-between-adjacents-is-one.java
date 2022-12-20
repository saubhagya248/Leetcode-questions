//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		while(testcases-- > 0){
		    
		    int n = Integer.parseInt(br.readLine());
		    int arr[] = new int[n];
		    
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split(" ");
		    
		    for(int index = 0;index < n; index++){
		        arr[index] = Integer.parseInt(elements[index]);
		    }
		    
		    Solution obj = new Solution();
		    System.out.println(obj.longLenSub(arr,n));
		}
		
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    
    public int longLenSub(int []nums, int n) 
    { 
        Map<Integer,Integer> ans = new HashMap<>();
		int maxlen = 0;
		

		for(int i=0;i<nums.length;i++){
			int val1 = ans.getOrDefault(nums[i]-1,0);
			int val2 = ans.getOrDefault(nums[i]+1,0);
			int val = Math.max(val1,val2);
			ans.put(nums[i],val+1);
			maxlen = Math.max(ans.get(nums[i]),maxlen);
		}
		

		return maxlen;
    } 
      
}


