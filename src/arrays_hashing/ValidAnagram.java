// Leetcode question no : 242 - Valid Anagram
// https://leetcode.com/problems/valid-anagram/description/

// Example 1:

// Input: s = "anagram", t = "nagaram"

// Output: true


Bruteforce : We can take a single character from s and search in t and if found 
we will remove them from both and keep iterating
Time Complexity: O(n^2)
Space Complexity : O(1)

Optimal Solution: We can use an array as it is mentioned that s & t will have 
lowercase characters i.e 26 only
Time Complexity : O(n)
Space Complexity : O(1) (array will be of fixed size so O(1))




Follow up: What if the inputs contain Unicode characters? How would you adapt 
your solution to such a case?
In this case we will use a hashmap based approach
Time Complexity : O(n)
Space Complexity : O(1)

    class Solution {
        public boolean isAnagram(String s, String t) {
            if(s.length() != t.length()){
                return false;
            }
            HashMap<Character,Integer> countMap = new HashMap<>();
            for(int i=0;i<s.length();i++){
                countMap.put(s.charAt(i),countMap.getOrDefault(s.charAt(i),0)+1);
            }
            for(int i=0;i<t.length();i++){
                if(countMap.containsKey(t.charAt(i))){
                    int count = countMap.get(t.charAt(i));
                    if(count <= 0){
                        return false;
                    }
                    countMap.put(t.charAt(i),count-1);
                }
                else{
                    return false;
                }
            }
            return true;
        }
    }



