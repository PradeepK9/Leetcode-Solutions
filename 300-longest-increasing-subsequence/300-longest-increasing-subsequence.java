class Solution {
//     public int memo(int curr, int prev, int[] nums, int[][] dp){
//         if(curr == nums.length) return 0;
//         if(dp[curr][prev + 1] != -1) return dp[curr][prev + 1];
        
//         int yes = (prev == -1 || nums[prev] < nums[curr])
//                    ? memo(curr + 1, curr, nums, dp) + 1 : 0;
            
//         int no = memo(curr + 1, prev, nums, dp);
        
//         return dp[curr][prev + 1] = Math.max(yes, no);
//     }
    
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxLIS = 0;
        for(int i=0; i<nums.length; i++){
            dp[i] = 1; // If Prev Does not Exist, then current element can have yes
            
            for(int j=0; j<i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            maxLIS = Math.max(maxLIS, dp[i]);
        }
        
        return maxLIS;
    }
}