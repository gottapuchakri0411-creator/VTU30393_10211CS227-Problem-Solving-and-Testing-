class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int left = 0;
        
        // Map to store the last seen index of each character
        java.util.HashMap<Character, Integer> charIndexMap = new java.util.HashMap<>();
        
        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            
            // If the character is already in the window, shrink the window from the left
            if (charIndexMap.containsKey(currentChar)) {
                left = Math.max(left, charIndexMap.get(currentChar) + 1);
            }
            
            // Update the last seen position of the current character
            charIndexMap.put(currentChar, right);
            
            // Calculate the maximum length found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}


Input
s =
"abcabcbb"
Output
3
