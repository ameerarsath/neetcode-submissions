class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int max=0,ans=0;
    
        if(nums.length<=0)return 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i-1]+1==nums[i]){
                max++;
            }
            else{
                System.out.println(ans+" "+max);
               ans=Math.max(ans,max);
                max=0;
            }
            ans=Math.max(ans,max);
            
        }
        return ans+1;
    }
}
