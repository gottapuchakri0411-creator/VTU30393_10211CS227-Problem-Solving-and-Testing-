import java.util.*;

class Solution {
    public String frequencySort(String s) {
        // Step 1: Count the frequency of each character
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        
        // Step 2: Sort characters by frequency in descending order
        List<Character> characters = new ArrayList<>(counts.keySet());
        characters.sort((a, b) -> counts.get(b) - counts.get(a));
        
        // Step 3: Build the result string
        StringBuilder sb = new StringBuilder();
        for (char c : characters) {
            int frequency = counts.get(c);
            for (int i = 0; i < frequency; i++) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}


Input
s =
"tree"
Output
"eert"
