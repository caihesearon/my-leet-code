package Entity;

/**
 * @author hecai
 * @date 2020年5月5日
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    
    public String path;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
