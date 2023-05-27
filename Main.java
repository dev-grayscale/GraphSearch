import java.util.LinkedList;
import java.util.Queue;

/**
 * A graph is a collection of nodes and edges (which could be directed or undirected).
 *
 * Let's depict the directions using the following two nodes: <b>A</b> and <b>B</b>.
 *
 * Directed graph: Node A points to node B (only 1 direction)
 * Undirected graph: Node A points to node B AND Node B points to node A
 *
 * A graph can also contain cycles (unlike trees).
 *
 * For this challenge, we'll assume the following Graph Node structure:
 *
 * public class Node {
 *   public String data;
 *   public Node[] children;
 *   public boolean visited;
 *
 *   public Node(String data) {
 *     this.data = data;
 *   }
 * }
 *
 * Let's take the following graph:
 *
 * a: [b,c]
 * b: [d,e]
 * c: [f]
 * d: [r,n]
 * e: [o]
 * r: []
 *
 * The traversal process for <b>depthFirstSearch</b> with starting node of <b>a</b> goes like this:
 *
 * a -> b -> d -> r -> n -> ... (It recursively visits the leftmost non-visited child until there are no more in that path, then propagates upwards with the next
 * non-visited child in line from the closest parent)
 *
 * For <b>breadthFirstSearch</b> with starting node of <b>a</b>, it goes like this:
 *
 * a -> b -> c -> d -> e -> f -> .. (One way to traverse all elements is to push the root node in a queue.
 * Then, until the queue is not empty, simply pop() the oldest element, add its children to end of the queue in the exact same order, and repeat the process
 * from described in this sentence.)
 *
 * <danger>Make sure to visit only NOT yet visited nodes to avoid infinite cycles</danger>
 */
public class Main {

  /**
   * Time Complexity: O(n)
   * Space Complexity: O(d) where d is the depth of the tree
   */
  public static boolean depthFirstSearch(Node node, String search) {
    if (node == null) {
      return false;
    }

    boolean found = node.data.equals(search);

    node.visited = true;

    for (Node child : node.children) {
      if (!child.visited && !found) {
        found = depthFirstSearch(child, search);
      }
    }

    return found;
  }

  /**
   * Time Complexity: O(n)
   * Space Complexity: O(n)
   */
  public static boolean breadthFirstSearch(Node node, String search) {
    if (node == null) {
      return false;
    }

    if (node.data.equals(search)) {
      return true;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(node);

    while (!queue.isEmpty()) {
      Node current = queue.remove();

      if (current.data.equals(search)) {
        return true;
      }

      current.visited = true;

      for (Node child : current.children) {
        if (!child.visited) {
          queue.add(child);
        }
      }
    }

    return false;
  }
}
