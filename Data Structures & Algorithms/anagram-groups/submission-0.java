class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map =new HashMap<>();
        for(String temp:strs){
        char [] str=temp.toCharArray();
        Arrays.sort(str);
        String st= new String(str);
        map.computeIfAbsent(st, k -> new ArrayList<>()).add(temp);

    }

    return new ArrayList<>(map.values());
    }
}
