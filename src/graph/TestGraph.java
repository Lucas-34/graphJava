package graph;
import graph.*;

public class TestGraph
{
  public static void main(String[] args) throws Exception
  {
    Vertex v0 = new Vertex();
    System.out.println(v0);
    Vertex v1 = new Vertex();
    System.out.println(v1);

    Edge edge = new DirectedEdge(v0, v1, 0);
    System.out.println(edge.toString());
  }
}