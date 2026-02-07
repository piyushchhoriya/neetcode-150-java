
// Topics
// premium lock icon
// Companies
// Given an array of strings strs, group the anagrams together. You can return the answer in any order.

 

// Example 1:

// Input: strs = ["eat","tea","tan","ate","nat","bat"]

// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

// Explanation:

// There is no string in strs that can be rearranged to form "bat".
// The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
// The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

// Constraint : strs[i] consists of lowercase English letters.
// In this case instead of sorting we will use frequency array as we just have 26 letters
Time Complexity : O(n · k)
Space Complexity : O(n · k)

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null || strs.length == 0){
            return new ArrayList<>();
        }
        List<List<String>> anagrams = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            int[] frequency = new int[26];
            for(int i=0;i<str.length();i++){
                frequency[str.charAt(i)-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++){
                sb.append('#');
                sb.append(frequency[i]);
            }
            String st = sb.toString();
            if(!map.containsKey(st)){
                map.put(st,new ArrayList<>());
            }
            map.get(st).add(str);
        }
        for(List<String> st : map.values()){
            anagrams.add(st);
        }
        return anagrams; 
    }
}


//If strs[i] - contains anything and not just lowercase letters
// In that case we can't keep a frequency array. We will need to sort it and then use hashmap
// Time Complexity : O(n · k log k)
// Space Complexity : O(n · k)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null || strs.length == 0){
            return new ArrayList<>();
        }
        List<List<String>> anagrams = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String str = new String(ch);
            if(!map.containsKey(str)){
                map.put(str,new ArrayList<>());
            }
            map.get(str).add(strs[i]);
        }
        for(List<String> st : map.values()){
            anagrams.add(st);
        }
        return anagrams; 
    }
}