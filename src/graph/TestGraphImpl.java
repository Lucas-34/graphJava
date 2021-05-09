package graph;
import graph.*;

public class TestGraphImpl
{
  public static void main(String[] args)
  {
    IncidenceArrayGraph incidence_array_graph = new IncidenceArrayGraph(3, EdgeKind.undirected);

    Vertex v0 = new Vertex();
    System.out.println(v0);
    incidence_array_graph.addVertex(v0);

    Vertex v1 = new Vertex();
    System.out.println(v1);
    incidence_array_graph.addVertex(v1);

    Vertex v2 = new Vertex();
    System.out.println(v2);
    incidence_array_graph.addVertex(v2);

    Edge e1 = new UndirectedEdge(v0, v1);
    System.out.println(edge.toString());
    incidence_array_graph.addEdge(v0, v1);

    Edge e2 = new UndirectedEdge(v1, v2);
    System.out.println(edge.toString());
    incidence_array_graph.addEdge(v1, v2);

    incidence_array_graph.initIncidenceArray();

    System.out.println("Est-ce que tous les sommets du graphe sont connectés ? " + incidence_array_graph.areConnected()); // Doit retourner false

    System.out.println("Est-ce que v1 est connecté à v2 ? " + incidence_array_graph.areConnected(v1, v2)); // Doit retourner true

    System.out.println("Est-ce que v1 est connecté à v3 ? " + incidence_array_graph.areConnected(v1, v3)); // Doit retourner false

    System.out.println("Liste de sommets : " + incidence_array_graph.getEdges().toString()); 
    // Montre la liste des vertex
  }
}