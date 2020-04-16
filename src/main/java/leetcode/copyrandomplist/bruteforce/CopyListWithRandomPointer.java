package leetcode.copyrandomplist.bruteforce;

import leetcode.copyrandomplist.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vvinnyk on 3/30/20.
 */
public class CopyListWithRandomPointer {
       private static int getNumberToEnd(Node random) {
              Node cur = random;
              int counter = 1;
              while (cur.next != null) {
                     counter++;
                     cur = cur.next;
              }
              return counter;
       }

       public static Node copyRandomList(Node head) {
              Node curNode = head;
              List<Node> list = new ArrayList<>();
              int index = 0;

              while (curNode != null) {
                     Node copy = new Node(curNode.val);
                     list.add(copy);
                     if (index > 0) {
                            Node prev = list.get(index - 1);
                            prev.next = copy;
                     }

                     curNode = curNode.next;
                     index++;
              }

              curNode = head;
              index = 0;

              while (curNode != null) {
                     Node thisRandom = curNode.random;
                     if (thisRandom != null) {
                            int numberToTail = getNumberToEnd(thisRandom);
                            int randomCoordinate = list.size() - numberToTail;
                            list.get(index).random = list.get(randomCoordinate);
                     }

                     curNode = curNode.next;
                     index++;
              }
              return list.isEmpty() ? new Node(0) : list.get(0);
       }

       public static void main(String[] args) {
              Node head = new Node(1);
              Node next = new Node(2);
              head.next = next;
              next.random = next;
              head.random = next;
              System.out.println(copyRandomList(head));
       }
}
