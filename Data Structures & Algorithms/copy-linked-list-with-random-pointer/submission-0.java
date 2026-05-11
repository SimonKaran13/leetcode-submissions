/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    private HashMap<Node, Integer> nodeToIndexMap = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        List<Node> nodes = getNodesAndPopulateMap(head);
        int n = nodes.size();

        // Create new nodes ( + 1 for null value at the end)
        Node[] newNodes = new Node[n + 1];
        for (int i = 0; i < n; i++) {
            int val = nodes.get(i).val;
            Node newNode = new Node(val);
            newNodes[i] = newNode;
        }

        // Add next and random references
        for (int i = 0; i < n; i++) {
            newNodes[i].next = newNodes[i + 1];

            if (nodes.get(i).random != null) {
                int randomIdx = nodeToIndexMap.get(nodes.get(i).random);
                newNodes[i].random = newNodes[randomIdx]; 
            }
        }

       return newNodes[0];
    }


    private List<Node> getNodesAndPopulateMap(Node head) {
        List<Node> nodes = new ArrayList<>();
        int n = 0;
        Node tmp = head;
        while (tmp != null) {
            nodes.add(tmp);
            nodeToIndexMap.put(tmp, n);
            n++;
            tmp = tmp.next;
        }
        return nodes;
    }
}
