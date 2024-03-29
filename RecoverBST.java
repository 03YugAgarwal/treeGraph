// O(n) and O(h)
// O(n) and O(1) in better way
import java.util.*;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

class RecoverBST{

    TreeNode firstNode = null;
    TreeNode secondNode = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    
    void recoverBST(TreeNode root){
        inorder(root);
        int temp = firstNode.data;
        firstNode.data = secondNode.data;
        secondNode.data = temp;
    }
    void inorder(TreeNode node){
        if(node == null){
            return;
        }
        inorder(node.left);
        if(firstNode == null && prev.data >= node.data){
            firstNode = prev;
        }
        if(firstNode != null && prev.data >= node.data){
            secondNode = node;
        }
        prev = node;
        inorder(node.right);
    }
    void printinorder(TreeNode node){
        if(node == null){
            return;
        }
        printinorder(node.left);
        System.out.println(node.data);
        printinorder(node.right);
    }


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        RecoverBST rbst = new RecoverBST();

        rbst.recoverBST(root);
        rbst.printinorder(root);

    }
}