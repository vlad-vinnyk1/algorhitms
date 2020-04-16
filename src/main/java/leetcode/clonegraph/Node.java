package leetcode.clonegraph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vvinnyk on 3/31/20.
 */
public class Node {
       public int val;
       public List<Node> neighbors;

       public Node() {
              val = 0;
              neighbors = new ArrayList<>();
       }

       public Node(int _val) {
              val = _val;
              neighbors = new ArrayList<>();
       }

       public Node(int _val, ArrayList<Node> _neighbors) {
              val = _val;
              neighbors = _neighbors;
       }
}
