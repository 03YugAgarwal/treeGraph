import java.util.*;

class TreeNode {

  int data;
  TreeNode left;
  TreeNode right;

  TreeNode(int data) {
    this.data = data;
  }
}

class BoundaryTraversal {

  private static void printLeaves(TreeNode root) {
    if (root != null) {
      printLeaves(root.left);
      if (root.left == null && root.right == null) System.out.print(root.data + " ");
      printLeaves(root.right);
    }
  }

  static void BoundaryTraversal(TreeNode root) {
    if (root != null) {
      System.out.print(root.data + " ");
      printLeaves(root.left);
      printLeaves(root.right);
    }
  }

  public static void main(String args[]) {
    TreeNode root = new TreeNode(8);
    root.left = new TreeNode(3);
    root.right = new TreeNode(10);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(6);
    root.left.right.left = new TreeNode(4);
    root.left.right.right = new TreeNode(7);
    root.right.right = new TreeNode(14);
    root.right.right.left = new TreeNode(13);

    BoundaryTraversal(root);
  }
}
