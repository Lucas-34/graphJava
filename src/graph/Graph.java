package graph;
import graph.*;

public interface Graph
{
  public int nbOfVertices();
  public int nbOfEdges();
  public void addVertex(Vertex vertex); 
  public void addEdge(Vertex v0, Vertex v1, EdgeKind edgeKind); // EdgeKind: "directed" or "undirected"
  public boolean areConnected(Vertex v0, Vertex v1); // Says if these 2 vertices v0 and v1 are connected or not.
  public boolean areAllConnected(); // Says whether all vertices are interconnected or not.
  public Edge[] getEdges(Vertex v0, Vertex v1); // Gives edge(s) connecting these vertices.
  public Edge[] getAllEdges(); // Gives all edges of the graph.
  public Vertex[] getAllVertices(); // Gives all vertices of the graph.
  public Edge[] getConnectedEdges(Vertex vertex); // Gives edges connected to this vertex.
}