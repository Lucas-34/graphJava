package graph;

import graph.*;

public class DirectedEdge extends Edge
{
  private int source;

  public DirectedEdge(double value, Vertex v0, Vertex v1, int source) throws Exception
  {
    super(value, v0, v1);
    if(source != 0 && source != 1) { throw new Exception("Erreur: l'indice de la source ne peut qu'être 0 ou 1."); }
    this.source = source;
  }

  public DirectedEdge(Vertex v0, Vertex v1, int source) throws Exception
  {
    super(v0, v1);
    if(source != 0 && source != 1) { throw new Exception("Erreur: l'indice de la source ne peut qu'être 0 ou 1."); }
    this.source = source;
  }

  public Vertex getSource() 
  {
    return getEnds()[source];
  }
  
  public Vertex getSink()
  { 
    if(source == 1) { return getEnds()[0]; }
    else { return getEnds()[1]; }
  }

  @Override
  public String toString() { return "Une transition orientée a été créée. Ses caractéristiques sont :\nId : " + this.getId() + "\nColor : " + this.getColor() + "\nValue : " + this.getValue() + "\nSource id : " + source + "\n"; }
}