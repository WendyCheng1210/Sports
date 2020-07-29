package Tree;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bfs {
    public static void main(String[] args) {
        Bfs queueSolution = new Bfs();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(8);
        right.left= new TreeNode(7);
        right.right=new TreeNode(9);
    }

    public List<List<Integer>> largestValues(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();

        List<List<Integer>> result = new ArrayList<>();
        queue.offer(root);

        while (!(queue.isEmpty())){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();

                level.add(node.val);
                if (!(node.left == null)){
                    queue.offer(node.left);
                }
                if (!(node.right == null)){
                    queue.offer(node.right);
                }
            }
            result.add(level);
        }
        System.out.println(result);
        return result;
    }
}
