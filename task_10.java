import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();
        
        int n = in.nextInt();
        int m = in.nextInt();
        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            
            // Add new element to window and unique tracker
            deque.add(num);
            set.add(num);

            // Once the sliding window reaches size m
            if (deque.size() == m) {
                // Update maximum unique count
                if (set.size() > maxUnique) {
                    maxUnique = set.size();
                }

                // If all elements in the window are unique, early exit
                if (maxUnique == m) {
                    break;
                }

                // Remove the oldest element from the window
                int first = deque.remove();
                
                // Only remove from set if it does not occur again in the current window
                if (!deque.contains(first)) {
                    set.remove(first);
                }
            }
        }
        
        System.out.println(maxUnique);
        in.close();
    }
}


input (stdin)
6 3
5 3 5 2 3 2
Expected Output
3
