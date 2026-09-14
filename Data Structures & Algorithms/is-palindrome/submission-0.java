class Solution {
    public boolean isPalindrome(String s) {
        String sb = s.replaceAll(" ","").toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "");
        int left=0;
        int right=sb.length()-1;
        while(left<=right){
            if(sb.charAt(left)!=sb.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;

      
    }
}
