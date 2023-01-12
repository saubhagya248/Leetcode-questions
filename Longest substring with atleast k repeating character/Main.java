class Solution {
    private int xUniquek(String s, int k, int x){
		int i = 0, j = 0, n = s.length();
		int freq[] = new int[123];
		int unique = 0, char_atleastk = 0;
		int ans = 0;

		while(j<n){
			freq[s.charAt(j)]++;
			if(freq[s.charAt(j)]==1) unique++;
			if(freq[s.charAt(j)]==k) char_atleastk++;
			j++;

			//contraction
			while(i<j && unique>x){
				freq[s.charAt(i)]--;
				if(freq[s.charAt(i)] == 0) unique--;
				if(freq[s.charAt(i)] == k-1) char_atleastk--;
				i++;
			}

			if(unique == x && char_atleastk == x){
				ans = Math.max(ans,j-i);
			}
			
		}

		return ans;
	}
    public int longestSubstring(String s, int k) {
        int[] freq = new int[123];
		int n = s.length();int total = 0;

		for(int i = 0; i < n; i++){
			freq[s.charAt(i)]++;
			if(freq[s.charAt(i)]==1) total++;
		}

		int ans = 0;

		for(int i = 1; i <= total; i++){
			ans = Math.max(xUniquek(s,k,i),ans);
		}

		return ans;
    }
}