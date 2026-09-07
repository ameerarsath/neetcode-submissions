class Solution {
    public boolean isAnagram(String s, String t) {
        List<Character> set = new ArrayList<>();
        if(s.length()!=t.length())return false;
        for(int i=0;i<s.length();i++){
            set.add(s.charAt(i));
        }
        for(int i=0;i<t.length();i++){
            if(set.contains(t.charAt(i))){
                set.remove(set.indexOf(t.charAt(i)));
            }
            else{
                return false;
            }
        }
        return true;
    }
}
