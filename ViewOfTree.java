import java.util.*;

class TreeNode {

  char data;
  TreeNode left;
  TreeNode right;

  TreeNode(char data) {
    this.data = data;
  }
}

class ViewOfTree {

  List<Character> horizontalView(TreeNode root) {
    List<Character> hv = new ArrayList();
    if (root == null) return hv;
    Queue<TreeNode> queue = new LinkedList();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      for (int i = 0; i < levelSize; i++) {
        TreeNode node = queue.poll();
        hv.add(node.data);
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
    }
    return hv;
  }

  List<Character> verticalView(TreeNode root) {
    List<Character> vv = new ArrayList();
    if (root == null) return vv;
    Map<Integer, List<Character>> vmap = new TreeMap<>();
    Queue<TreeNode> nodeQueue = new LinkedList();
    Queue<Integer> hdQueue = new LinkedList();
    nodeQueue.offer(root);
    hdQueue.offer(0);
    while (!nodeQueue.isEmpty()) {
      TreeNode node = nodeQueue.poll();
      int hd = hdQueue.poll();
      vmap.computeIfAbsent(hd, k -> new ArrayList<>()).add(node.data);
      if (node.left != null) {
        nodeQueue.offer(node.left);
        hdQueue.offer(hd - 1);
      }
      if (node.right != null) {
        nodeQueue.offer(node.right);
        hdQueue.offer(hd + 1);
      }
    }
    for (List<Character> values : vmap.values()) {
      vv.addAll(values);
    }
    return vv;
  }

  List<Character> leftView(TreeNode root) {
    List<Character> lv = new ArrayList();
    if (root == null) return lv;
    Queue<TreeNode> nodeQueue = new LinkedList();
    nodeQueue.offer(root);
    while (!nodeQueue.isEmpty()) {
      int levelSize = nodeQueue.size();
      for (int i = 0; i < levelSize; i++) {
        TreeNode node = nodeQueue.poll();
        if (i == 0) {
          lv.add(node.data);
        }
        if (node.left != null) {
          nodeQueue.offer(node.left);
        }
        if (node.right != null) {
          nodeQueue.offer(node.right);
        }
      }
    }
    return lv;
  }

  List<Character> rightView(TreeNode root) {
    List<Character> rv = new ArrayList();
    if (root == null) return rv;
    Queue<TreeNode> nodeQueue = new LinkedList();
    nodeQueue.offer(root);
    while (!nodeQueue.isEmpty()) {
      int levelSize = nodeQueue.size();
      for (int i = 0; i < levelSize; i++) {
        TreeNode node = nodeQueue.poll();
        if (i == levelSize - 1) {
          rv.add(node.data);
        }
        if (node.left != null) {
          nodeQueue.offer(node.left);
        }
        if (node.right != null) {
          nodeQueue.offer(node.right);
        }
      }
    }
    return rv;
  }

  // top view
  List<Character> topView(TreeNode root) {
    List<Character> tv = new ArrayList();
    if (root == null) return tv;
    Queue<TreeNode> nodeQueue = new LinkedList();
    Queue<Integer> hdQueue = new LinkedList();
    Map<Integer, Character> map = new TreeMap();
    nodeQueue.offer(root);
    hdQueue.offer(0);
    while (!nodeQueue.isEmpty()) {
      TreeNode node = nodeQueue.poll();
      int hd = hdQueue.poll();
      if (!map.containsKey(hd)) {
        map.put(hd, node.data);
      }
      if (node.left != null) {
        nodeQueue.offer(node.left);
        hdQueue.offer(hd - 1);
      }
      if (node.right != null) {
        nodeQueue.offer(node.right);
        hdQueue.offer(hd + 1);
      }
    }
    for (char x : map.values()) {
      tv.add(x);
    }
    return tv;
  }

  // bottom view
  List<Character> bottomView(TreeNode root) {
    List<Character> tv = new ArrayList();
    if (root == null) return tv;
    Queue<TreeNode> nodeQueue = new LinkedList();
    Queue<Integer> hdQueue = new LinkedList();
    Map<Integer, Character> map = new TreeMap();
    nodeQueue.offer(root);
    hdQueue.offer(0);
    while (!nodeQueue.isEmpty()) {
      TreeNode node = nodeQueue.poll();
      int hd = hdQueue.poll();
      map.put(hd, node.data);

      if (node.left != null) {
        nodeQueue.offer(node.left);
        hdQueue.offer(hd - 1);
      }
      if (node.right != null) {
        nodeQueue.offer(node.right);
        hdQueue.offer(hd + 1);
      }
    }
    for (char x : map.values()) {
      tv.add(x);
    }
    return tv;
  }

  public static void main(String args[]) {
    TreeNode root = new TreeNode('A');
    root.left = new TreeNode('B');
    root.right = new TreeNode('C');
    root.left.left = new TreeNode('D');
    root.left.right = new TreeNode('E');
    root.right.left = new TreeNode('F');
    root.right.right = new TreeNode('G');

    ViewOfTree ans = new ViewOfTree();

    List<Character> horizontalViewResult = ans.horizontalView(root);
    List<Character> verticalViewResult = ans.verticalView(root);
    List<Character> leftViewResult = ans.leftView(root);
    List<Character> rightViewResult = ans.rightView(root);
    List<Character> topViewResult = ans.topView(root);
    List<Character> bottomViewResult = ans.bottomView(root);
    System.out.print("Horizontal View: ");
    for (char node : horizontalViewResult) {
      System.out.print(node + " ");
    }
    System.out.println();
    System.out.print("Vertical View: ");
    for (char node : verticalViewResult) {
      System.out.print(node + " ");
    }
    System.out.println();
    System.out.print("Left View: ");
    for (char node : leftViewResult) {
      System.out.print(node + " ");
    }
    System.out.println();
    System.out.print("Right View: ");
    for (char node : rightViewResult) {
      System.out.print(node + " ");
    }
    System.out.println();
    System.out.print("Top View: ");
    for (char node : topViewResult) {
      System.out.print(node + " ");
    }
    System.out.println();
    System.out.print("Bottom View: ");
    for (char node : bottomViewResult) {
      System.out.print(node + " ");
    }
    System.out.println();
  }
}
