import java.util.ArrayList;
import java.util.List;

class BrowserHistory {
    private List<String> history;
    private int currentIndex;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        currentIndex = 0;
    }
    
    public void visit(String url) {
        // Remove all history forward of the current index
        while (history.size() - 1 > currentIndex) {
            history.remove(history.size() - 1);
        }
        history.add(url);
        currentIndex++;
    }
    
    public String back(int steps) {
        currentIndex = Math.max(0, currentIndex - steps);
        return history.get(currentIndex);
    }
    
    public String forward(int steps) {
        currentIndex = Math.min(history.size() - 1, currentIndex + steps);
        return history.get(currentIndex);
    }
}



Input
["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
[["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
Output
[null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]
