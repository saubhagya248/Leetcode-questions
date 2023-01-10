import java.util.*;
class Main{
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
        int n,k;
        n=sc.nextInt();
        k=sc.nextInt();
        int[] a= new int[n];
        for(int i=0;i<n;i++){
          a[i] = sc.nextInt();
        }
        Solution obj=new Solution();
        System.out.println(obj.findPairs(a,n,k));
        sc.close();		    
    }
}

class Solution
{
    public int findPairs(int[] nums,int n, int k) {
        Arrays.sort(nums);

		int i = 0, j = 1;
		int count = 0;
		while(j<n){
			if(nums[j]-nums[i]==k){
				count++;
				i++;j++;

				while(i<n && nums[i]==nums[i-1]) i++;
				while(j<n && nums[j]==nums[j-1]) j++;
				
			}
			else if(nums[j]-nums[i]<k) j++;
			else i++;
			if(i==j) j++;
		}

		return count;
    }
}