import java.io.*;
import java.util.*;



class Main {
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        Solution solution = new Solution();
        List<List<Integer>> result = solution.threeSum(nums);
        //Sort all lists inside the list first
        for (int i = 0; i < result.size(); i++) {
            Collections.sort(result.get(i));
        }
        //Sort the list
        Collections.sort(result, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> l1, List<Integer> l2) {
                for (int i = 0; i < l1.size(); i++) {
                    if (l1.get(i) < l2.get(i)) return -1;
                    else if (l1.get(i) > l2.get(i)) return 1;
                }
                return 0;
            }
        });
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}

/*Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0. 
Find all unique triplets in the array which gives the sum of zero.
5
1 2 -2 0 -1

output - [[1, 0, -1], [2, -2, 0]
 */


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        

        int n = nums.length;

        
        List<List<Integer>> fans = new ArrayList<>();
        if(n<3) return fans;

        if(nums[0]>0) return fans;

        for(int i=0;i<n-2;i++){
            
            if(nums[i]>0) break;
            if(i>0 && nums[i]==nums[i-1]) continue;

            int j = i+1, k = n-1;
            int res = 0-nums[i];

            while(j<k){
                int temp = nums[j]+nums[k];

                if(temp == res){
                    
                    fans.add(Arrays.asList(nums[i],nums[j],nums[k]));

                    while(j<k && nums[j]==nums[j+1])j++;
                    while(j<k && nums[k]==nums[k-1])k--;
                    j++;
                    k--;
                }
                else if(temp < res) j++;
                else k--;
            }
        }

		return fans;
    }
}