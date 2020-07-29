package Tree;

public class Dfs {
    public static void  main(String[] args){
        Dfs dfsTest = new Dfs();
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(1);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(3);
        left.right = new TreeNode(2);
        right.right=new TreeNode(2);
        dfsTest.preOrder(root);
//        dfsTest.inOrder(root);
//        dfsTest.postOrder(root);
    }

    public void preOrder(TreeNode n){
        if (n != null){
            System.out.println(n);
        }else {
            return;
        }
        if (n.left != null) preOrder(n.left);
        if (n.right != null) preOrder(n.right);
    }

    public void inOrder(TreeNode n){
        if (n.left != null){
            System.out.println(n.left);
        }else {
            return;
        }
        if (n != null) inOrder(n);
        if (n.right != null) inOrder(n.right);
    }

    public void postOrder(TreeNode n){
        if (n.right != null){
            System.out.println(n.right);
        }else {
            return;
        }
    }

}
