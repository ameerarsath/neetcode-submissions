class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] ans=new int[nums.length];

        int sum=1;
        for(int i=0;i<nums.length;i++){
            ans[i]=sum;
            sum=sum*nums[i];
        }

        sum=1;
        for(int i=nums.length-1;i>=0;i--){
            ans[i]=ans[i]*sum;
            sum=sum*nums[i];
        }

        return ans;
    }
}