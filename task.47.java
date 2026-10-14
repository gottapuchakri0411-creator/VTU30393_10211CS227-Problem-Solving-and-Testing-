class Solution {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}


nput
s =
"abcde"
goal =
"cdeab"
Output
true
