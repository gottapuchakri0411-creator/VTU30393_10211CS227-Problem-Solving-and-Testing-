import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

enum Color {
    RED, GREEN
}

abstract class Tree {
    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {
    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);
        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {
    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    private int result = 0;

    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {
        // Do nothing for internal nodes
    }

    public void visitLeaf(TreeLeaf leaf) {
        result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private long result = 1;
    private final int MOD = 1000000007;

    public int getResult() {
        return (int) result;
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) {
            result = (result * node.getValue()) % MOD;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            result = (result * leaf.getValue()) % MOD;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int evenDepthNonLeafSum = 0;
    private int greenLeafSum = 0;

    public int getResult() {
        return Math.abs(evenDepthNonLeafSum - greenLeafSum);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            evenDepthNonLeafSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            greenLeafSum += leaf.getValue();
        }
    }
}

public class Solution {

    public static Tree solve() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        int[] values = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            values[i] = scanner.nextInt();
        }
        
        Color[] colors = new Color[n + 1];
        for (int i = 1; i <= n; i++) {
            colors[i] = (scanner.nextInt() == 0) ? Color.RED : Color.GREEN;
        }
        
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }
        
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        // Handle edge case for a single node tree
        if (n == 1) {
            return new TreeLeaf(values[1], colors[1], 0);
        }

        // To correctly build the tree structure, we can precalculate the children list for each node from root (node 1) downwards.
        Map<Integer, List<Integer>> childrenMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            childrenMap.put(i, new ArrayList<>());
        }
        
        int[] depths = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(1);
        visited[1] = true;
        depths[1] = 0;
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    depths[v] = depths[u] + 1;
                    childrenMap.get(u).add(v);
                    queue.add(v);
                }
            }
        }
        
        return buildNode(1, depths[1], values, colors, childrenMap);
    }
    
    private static Tree buildNode(int u, int depth, int[] values, Color[] colors, Map<Integer, List<Integer>> childrenMap) {
        List<Integer> children = childrenMap.get(u);
        if (children.isEmpty()) {
            return new TreeLeaf(values[u], colors[u], depth);
        } else {
            TreeNode node = new TreeNode(values[u], colors[u], depth);
            for (int v : children) {
                node.addChild(buildNode(v, depth + 1, values, colors, childrenMap));
            }
            return node;
        }
    }

    public static void main(String[] args) {
          Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
          ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
          FancyVisitor vis3 = new FancyVisitor();

          root.accept(vis1);
          root.accept(vis2);
          root.accept(vis3);

          int res1 = vis1.getResult();
          int res2 = vis2.getResult();
          int res3 = vis3.getResult();

          System.out.println(res1);
         System.out.println(res2);
          System.out.println(res3);
    }
}





Input (stdin)
5
4 7 2 5 12
0 1 0 0 1
1 2
1 3
3 4
3 5
Expected Output
24
40
15
