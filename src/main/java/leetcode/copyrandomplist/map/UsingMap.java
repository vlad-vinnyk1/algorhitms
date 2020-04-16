package leetcode.copyrandomplist.map;

import leetcode.copyrandomplist.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author vvinnyk on 3/31/20.
 */
public class UsingMap {
       public static Node copyRandomList(Node head) {
              Map<Node, Node> nodeToClone = new HashMap<>();
              Node curr = head;
              Node cloneHead = null;
              while (curr != null) {
                     Node thisClone = new Node(curr.val);
                     nodeToClone.put(curr, thisClone);
                     if (curr == head) {
                            cloneHead = thisClone;
                     }
                     curr = curr.next;
              }

              for (Map.Entry<Node, Node> entry : nodeToClone.entrySet()) {
                     Node origin = entry.getKey();
                     Node clone = entry.getValue();
                     clone.next = nodeToClone.get(origin.next);
                     clone.random = nodeToClone.get(origin.random);
              }

              return cloneHead;
       }

       public static void main(String[] args) {
              Node node = new Node(1);
              Node node2 = new Node(2);
              node.next = node2;
              node2.next = node;

              System.out.println(copyRandomList(node));
       }
}
