import java.io.*;
import java.util.*;

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

abstract class TreeVis {
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
    }

    public void visitLeaf(TreeLeaf leaf) {
        result += leaf.getValue();
    }
}

class ProductRedNodesVisitor extends TreeVis {
    private long result = 1;
    private final long MOD = 1000000007;

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
    private int nonLeafEvenDepthSum = 0;
    private int greenLeavesSum = 0;

    public int getResult() {
        return Math.abs(nonLeafEvenDepthSum - greenLeavesSum);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            nonLeafEvenDepthSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            greenLeavesSum += leaf.getValue();
        }
    }
}

public class Solution {

    public static Tree solve() {
        Scanner scanner = new Scanner(System.in);
        int numNodes = scanner.nextInt();

        int[] values = new int[numNodes + 1];
        for (int i = 1; i <= numNodes; i++) {
            values[i] = scanner.nextInt();
        }

        Color[] colors = new Color[numNodes + 1];
        for (int i = 1; i <= numNodes; i++) {
            colors[i] = (scanner.nextInt() == 0) ? Color.RED : Color.GREEN;
        }

        Map<Integer, ArrayList<Integer>> edges = new HashMap<>();
        for (int i = 1; i <= numNodes; i++) {
            edges.put(i, new ArrayList<>());
        }

        for (int i = 0; i < numNodes - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            edges.get(u).add(v);
            edges.get(v).add(u);
        }

        TreeNode root = new TreeNode(values[1], colors[1], 0);
        Map<Integer, Tree> treeMap = new HashMap<>();
        treeMap.put(1, root);

        boolean[] visited = new boolean[numNodes + 1];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            TreeNode currentParent = (TreeNode) treeMap.get(u);

            for (int neighbor : edges.get(u)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    int depth = currentParent.getDepth() + 1;

                    boolean isLeaf = true;
                    for (int nextNeighbor : edges.get(neighbor)) {
                        if (!visited[nextNeighbor]) {
                            isLeaf = false;
                            break;
                        }
                    }

                    Tree child;
                    if (isLeaf) {
                        child = new TreeLeaf(values[neighbor], colors[neighbor], depth);
                    } else {
                        child = new TreeNode(values[neighbor], colors[neighbor], depth);
                        queue.add(neighbor);
                    }

                    treeMap.put(neighbor, child);
                    currentParent.addChild(child);
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductRedNodesVisitor vis2 = new ProductRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int ans1 = vis1.getResult();
        int ans2 = vis2.getResult();
        int ans3 = vis3.getResult();

        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);
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
