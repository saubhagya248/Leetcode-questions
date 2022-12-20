//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s1 = br.readLine().trim();
            String[] S1 = s1.split(" ");
            String s2 = br.readLine().trim();
            String[] S2 = s2.split(" ");
            int n, k;
            n = Integer.parseInt(S1[0]);
            k = Integer.parseInt(S1[1]);
            int[] nums = new int[n];
            for(int i = 0; i < S2.length; i++)
                nums[i] = Integer.parseInt(S2[i]);
            Solution ob = new Solution();
            int ans = ob.TotalPairs(nums, k);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int TotalPairs(int[] a, int k)
    {
        int cnt = 0;
        int n = a.length;
		Map<Integer,Integer> m = new HashMap<>();
		for(int i=0;i<n;i++){
			int val = m.getOrDefault(a[i],0);
			m.put(a[i],val+1);
		}

		for(Integer key: m.keySet()){
		    
		    if(k==0){
		        if(m.containsKey(key) && m.get(key)>1){
		            cnt += 1;
		            //m.remove(key);
		        }
		        continue;
		    }
		    
			if(m.containsKey(key+k)){
				
				cnt += 1;
				
			}
			/*if(m.containsKey(key-k)){
				
				cnt += 1;
				
			}

			m.remove(key);*/
		}

		return cnt;
    }
}