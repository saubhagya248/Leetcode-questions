//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main(String[] args) throws IOException{
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		while(t-->0)
		{
		    int n=sc.nextInt();
		    sc.nextLine();
		    Solution obj = new Solution();
		    String arr[]=sc.nextLine().split(" ");
		    System.out.println(obj.mostFrequentWord(arr, n));
		    
		}
	}
}

// } Driver Code Ends
//User function Template for Java


class Solution
{
    //Function to find most frequent word in an array of strings.
    public String mostFrequentWord(String arr[],int n)
    {
        // code here
        String ans = arr[n-1];
		int freq = 1;
		Map<String,Integer> m = new HashMap<>();

		for(int i=n-1;i>=0;i--){
			String word = arr[i];
			if(m.containsKey(word)){
				m.put(word,m.get(word)+1);
				if(m.get(word)>freq){
					freq = m.get(word);
					ans = word;
				}
			}
			else{
			    m.put(word,1);
			}
		}

		return ans;
    }

}


//{ Driver Code Starts.
// } Driver Code Ends