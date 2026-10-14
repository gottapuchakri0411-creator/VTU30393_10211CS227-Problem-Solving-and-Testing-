class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        String normalizedPattern = getNormalizedPattern(pattern);
        
        for (String word : words) {
            if (getNormalizedPattern(word).equals(normalizedPattern)) {
                result.add(word);
            }
        }
        
        return result;
    }
    
    private String getNormalizedPattern(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, counter++);
            }
            sb.append(map.get(c)).append(".");
        }
        
        return sb.toString();
    }
}


Input
words =
["abc","deq","mee","aqq","dkd","ccc"]
pattern =
"abb"
Output
["mee","aqq"]
