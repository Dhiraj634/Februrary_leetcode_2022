import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
    class Node {
        TreeNode node;
        int pos;
        Node(TreeNode node, int pos){
            this.node = node;
            this.pos = pos;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root, 1));
        int width = 1,first=1,last=1;
        while(queue.size() > 0){
            ArrayList<Node> arr = new ArrayList<>();
            while(queue.size() > 0){
                Node node = queue.poll();
                if(node.node.left !=null) arr.add(new Node(node.node.left,node.pos*2-1));
                if(node.node.right !=null) arr.add(new Node(node.node.right,node.pos*2));
            }
            if(arr.size() > 0)
            {
                first = arr.get(0).pos;
                last = arr.get(arr.size()-1).pos;
            }
            width = Math.max(width, last-first+1);
            queue.addAll(arr);

        }
        return width;
    }
}
