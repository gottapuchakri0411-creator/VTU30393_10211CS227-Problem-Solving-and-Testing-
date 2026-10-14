public static int birthday(List<Integer> s, int d, int m) {
    int count = 0;
    
    // If the segment length is greater than the size of the list, no segment can be formed
    if (s.size() < m) {
        return 0;
    }
    
    // Calculate the sum of the first window of size m
    int currentSum = 0;
    for (int i = 0; i < m; i++) {
        currentSum += s.get(i);
    }
    
    // Check if the first window matches the target sum d
    if (currentSum == d) {
        count++;
    }
    
    // Slide the window across the rest of the list
    for (int i = m; i < s.size(); i++) {
        currentSum = currentSum - s.get(i - m) + s.get(i);
        if (currentSum == d) {
            count++;
        }
    }
    
    return count;
}


Input (stdin)
5
1 2 1 3 2
3 2
Expected Output
2
