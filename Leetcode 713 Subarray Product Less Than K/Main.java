import java.util.*;

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length, i = 0;
		int prod = 1, cnt = 0;

		for(int j = 0;j<n;j++){
			prod *= nums[j];
			if(prod>=k){
				while(prod>=k && i<n){
					prod /= nums[i];
					i++;
				}
			}
			if(prod<k) cnt+=(j-i+1);
			
		}

		return cnt;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int k;
        k = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.numSubarrayProductLessThanK(arr, k);
        System.out.println(result);
        sc.close();
    }
}