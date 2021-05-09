package graph;
import graph.*;

public class UndirectedEdge extends Edge
{
  public UndirectedEdge(double value, Vertex v0, Vertex v1)
  {
    super(value, v0, v1);
  }

  public UndirectedEdge(Vertex v0, Vertex v1)
  {
    super(v0, v1);
  }

  @Override
  public String toString() { return "Une transition non-orientée a été créée. Ses caractéristiques sont :\nId : " + this.getId() + "\nColor : " + this.getColor() + "\nValue : " + this.getValue() + "\n"; }
}