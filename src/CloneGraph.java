import java.util.HashMap;

public class CloneGraph {
    HashMap<Integer,Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Node currNode = new Node(node.val);
        map.put(node.val,currNode);
        for(Node nextNode : node.neighbors){
            if(map.containsKey(nextNode.val))
                currNode.neighbors.add(map.get(nextNode.val));
            else
                currNode.neighbors.add(cloneGraph(nextNode));
        }
        return currNode;
    }
}
