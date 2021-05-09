import java.lang.Math;
import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;

package graph;
import graph.*;

public class IncidenceArrayGraph implements Graph
{
  private Vertex[] tab_vertices; // <=> private Vertex tab_vertices[];
  private Edge[] tab_edges;
  private Edge[][] incidenceArray;
  private EdgeKind edgeKind;
  
  public IncidenceArrayGraph(int n, EdgeKind edgeKind)
  {
    int taille;
    tab_vertices = new Vertex[n];
    this.edgeKind = edgeKind;

    if(this.edgeKind == EdgeKind.directed)
    {
      taille = 2 * n;
      tab_edges = new DirectedEdge[taille];
      incidenceArray = new DirectedEdge[n][taille];
    }
    else
    {
      taille = n;
      tab_edges = new UndirectedEdge[taille];
      incidenceArray = new UndirectedEdge[n][taille];
    } 
  }

/*
  private Edge[] reorderEdge(Edge[] tab_edges) // Removes the null values from the arrays of edges.
  {
    int cpt = 0;
    int taille = 0;

    while(tab_edges[taille] != null && taille < tab_edges.length) { taille ++; }

    Edge[] final_result = new Edge[taille];

    for(int j = 0; j < i; j ++) { final_result[j] = tab_edges[j]; }

    return final_result;
  }

  private Vertex[] reorderVertex(Vertex[] tab_vertices) // Removes the null values from the arrays of vertices.
  {
    int cpt = 0;
    int taille = 0;

    while(tab_vertices[taille] != null && taille < tab_vertices.length) { taille ++; }

    Vertex[] final_result = new Vertex[taille];

    for(int j = 0; j < taille; j ++) { final_result[j] = tab_vertices[j]; }

    return final_result;
  }
*/

  @Override
  public Vertex[] getAllVertices() { return tab_vertices; }

  @Override
  public Edge[] getAllEdges() { return tab_edges; }

  public int[][] getIncidenceArray() { return incidenceArray; }
  // public void setIncidenceArray(int[][] incidenceArray) { this.incidenceArray = incidenceArray; }

  public EdgeKind getEdgeKind() { return edgeKind; }
  public void setEdgeKind(EdgeKind edgeKind) { this.edgeKind = edgeKind; }

  @Override
  public int nbOfVertices() { return tab_vertices.length; }

  @Override
  public int nbOfEdges() { return tab_edges.length; }

  @Override
  public void addVertex(Vertex vertex)
  {
    tab_vertices[vertex.getId()] = vertex;
  }

  
  @Override
  public void addEdge(Vertex v0, Vertex v1) // On considère v0 comme origine et v1 comme fin.
  {   
    int j = 0;
    Edge new_edge;

    if(edgeKind == EdgeKind.directed) { new_edge = new DirectedEdge(v0, v1, 0); }
    else { new_edge = new UndirectedEdge(v0, v1); }

    tab_edges[new_edge.getId()] = new_edge; 
    
    while(incidenceArray[v0.getId()][j] != null) { j ++; }
    incidenceArray[v0.getId()][j] = new_edge; 
    
    j = 0; 
    
    while(incidenceArray[v1.getId()][j] != null) { j ++; }
    incidenceArray[v1.getId()][j] = new_edge;
  }

  @Override
  public Edge[] getEdges(Vertex v0, Vertex v1)
  {
    if(edgeKind == EdgeKind.directed) { Edge[] result = new DirectedEdge[nbOfEdges()]; }
    else { Edge[] result = new UndirectedEdge[nbOfEdges()]; }
    
    int j = 0;

    Vertex[] ends1;
    ends1[0] = v0;
    ends1[1] = v1;
    
    Vertex[] ends2;
    ends2[0] = v1;
    ends2[1] = v0;

    for(int i = 0; i < tab_edges.length; i ++)
    {
      if(tab_edges[i].getEnds() == ends1 || tab_edges[i].getEnds() == ends2)
      {
        result[j] = tab_edges[i];
        j ++;
      }
    }

    result = reorderEdge(result);
    return result;
  }

  @Override
  public boolean areConnected(Vertex v0, Vertex v1)
  {
    Edge[] e = getEdges(v0, v1);

    if(e[0] != null) { return true; }
    else { return false; }
  }

  @Override
  public boolean areAllConnected()
  {
    boolean result = true;
    int  i = 0;

    while(result == true && i != tab_vertices.length)
    {
      for(int j = 0; j < tab_vertices.length; j ++)
      {
        if(areConnected(tab_vertices[i], tab_vertices[j]) == false)
        {
          result = false;
          break;
        }
      }

      i ++;
    }
    
    return result;
  }

  @Override
  public Edge[] getConnectedEdges(Vertex vertex)
  {
    int i = 0;
    if(edgeKind == EdgeKind.directed) { Edge[] result = new DirectedEdge[nbOfEdges()]; }
    else { Edge[] result = new UndirectedEdge[nbOfEdges()]; }

    int id_vertex = vertex.getId();

    for(int j = 0; j < tab_edges.length; j ++)
    {
      if(tab_edges[j].getEnds()[0] == vertex || tab_edges[j].getEnds()[1] == vertex)
      {
        result[i] = tab_edges[j];
        i++;
      }
    }
    
    Edge[] final_result = reorderEdge(result);
    return final_result;
  }

/*
  public String toString()
  { 
    String result;

    for(Vertex v : tab_vertices)
    {
      result = result + "Sommet n° " + v.getId() + "[ ";

      for(int i = 0; i < nbOfEdges() - 1 ; i ++)
      {
        result = result + "[" + tab_edges[i].getEnds()[0].getId() + "," + tab_edges[i].e.getEnds()[1].getId() + "],";
      }

      result = result + "[" + tab_edges[i].getEnds()[0].getId() + "," + tab_edges[i].e.getEnds()[1].getId() + "] ]";

    } 
  
    return "Voici votre tableau d'incidence : \n" + result + "\n";
  }*/
}

