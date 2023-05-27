import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.BooleanSupplier;

public class MainTest {

  @Test
  public void testDepthFirstSearch() {
    Node a = new Node("a");
    Node b = new Node("b");
    Node c = new Node("c");
    Node d = new Node("d");
    Node e = new Node("e");
    Node f = new Node("f");
    Node g = new Node("g");

    Graph graph = new Graph();
    graph.children = new Node[] { a, b, c, d, e, f, g };

    a.children = new Node[] { b, c, g };
    b.children = new Node[] { a, d };
    c.children = new Node[] { d, e, g };
    d.children = new Node[] { c, e };
    e.children = new Node[] { f };
    f.children = new Node[] { a, b, c, d };
    g.children = new Node[] { };

    assertTrue(graph, () -> Main.depthFirstSearch(a, "a"));
    assertTrue(graph, () -> Main.depthFirstSearch(a, "b"));
    assertTrue(graph, () -> Main.depthFirstSearch(a, "g"));
    assertTrue(graph, () -> Main.depthFirstSearch(a, "d"));
    assertTrue(graph, () -> Main.depthFirstSearch(a, "e"));
    assertTrue(graph, () -> Main.depthFirstSearch(a, "f"));

    assertFalse(graph, () -> Main.depthFirstSearch(a, "o"));

    assertTrue(graph, () -> Main.depthFirstSearch(g, "g"));
    assertFalse(graph, () -> Main.depthFirstSearch(g, "a"));
    assertFalse(graph, () -> Main.depthFirstSearch(g, "b"));
    assertFalse(graph, () -> Main.depthFirstSearch(g, "c"));
    assertFalse(graph, () -> Main.depthFirstSearch(g, "d"));
    assertFalse(graph, () -> Main.depthFirstSearch(g, "e"));
    assertFalse(graph, () -> Main.depthFirstSearch(g, "f"));

    assertTrue(graph, () -> Main.depthFirstSearch(f, "e"));
  }

  @Test
  public void testbreadthFirstSearch() {
    Node a = new Node("a");
    Node b = new Node("b");
    Node c = new Node("c");
    Node d = new Node("d");
    Node e = new Node("e");
    Node f = new Node("f");
    Node g = new Node("g");

    Graph graph = new Graph();
    graph.children = new Node[] { a, b, c, d, e, f, g };

    a.children = new Node[] { b, c, g };
    b.children = new Node[] { a, d };
    c.children = new Node[] { d, e, g };
    d.children = new Node[] { c, e };
    e.children = new Node[] { f };
    f.children = new Node[] { a, b, c, d };
    g.children = new Node[] { };

    assertTrue(graph, () -> Main.breadthFirstSearch(a, "a"));
    assertTrue(graph, () -> Main.breadthFirstSearch(a, "b"));
    assertTrue(graph, () -> Main.breadthFirstSearch(a, "g"));
    assertTrue(graph, () -> Main.breadthFirstSearch(a, "d"));
    assertTrue(graph, () -> Main.breadthFirstSearch(a, "e"));
    assertTrue(graph, () -> Main.breadthFirstSearch(a, "f"));

    assertFalse(graph, () -> Main.breadthFirstSearch(a, "o"));

    assertTrue(graph, () -> Main.breadthFirstSearch(g, "g"));
    assertFalse(graph, () -> Main.breadthFirstSearch(g, "a"));
    assertFalse(graph, () -> Main.breadthFirstSearch(g, "b"));
    assertFalse(graph, () -> Main.breadthFirstSearch(g, "c"));
    assertFalse(graph, () -> Main.breadthFirstSearch(g, "d"));
    assertFalse(graph, () -> Main.breadthFirstSearch(g, "e"));
    assertFalse(graph, () -> Main.breadthFirstSearch(g, "f"));

    assertTrue(graph, () -> Main.breadthFirstSearch(f, "e"));
  }

  private void resetVisited(Graph graph) {
    for (Node node : graph.children) {
      node.visited = false;
    }
  }

  private void assertTrue(Graph graph, BooleanSupplier booleanSupplier) {
    resetVisited(graph);

    Assertions.assertTrue(booleanSupplier.getAsBoolean());
  }

  private void assertFalse(Graph graph, BooleanSupplier booleanSupplier) {
    resetVisited(graph);

    Assertions.assertFalse(booleanSupplier.getAsBoolean());
  }
}
