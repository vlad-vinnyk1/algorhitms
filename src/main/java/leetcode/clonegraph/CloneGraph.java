package leetcode.clonegraph;

import java.util.*;

/**
 * @author vvinnyk on 3/31/20.
 */
public class CloneGraph {

       public Node cloneGraph(Node head) {
              if (head == null) {
                     return head;
              }
              Node cloneHead = null;
              Map<Node, Node> srcToClone = new HashMap<>();
              Queue<Node> queue = new LinkedList<>();
              queue.add(head);
              while (!queue.isEmpty()) {
                     Node curr = queue.poll();
                     if (srcToClone.get(curr) != null) {
                            continue;
                     }
                     srcToClone.put(curr, new Node(curr.val));
                     queue.addAll(curr.neighbors);
                     if (curr == head) {
                            cloneHead = srcToClone.get(curr);
                     }

              }

              for (Map.Entry<Node, Node> node : srcToClone.entrySet()) {
                     Node src = node.getKey();
                     Node clone = node.getValue();
                     List<Node> cloneNeighbors = new ArrayList<>();
                     for (Node neib : src.neighbors) {
                            cloneNeighbors.add(srcToClone.get(neib));
                     }
                     clone.neighbors = cloneNeighbors;

              }

              return cloneHead;
       }

       public static void main(String[] args) {

       }
}
