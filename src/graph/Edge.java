package graph;
import graph.*;

public abstract class Edge
{
  private static int availableId = 0;
  private final int id;
  private char color;
  private Vertex[] ends = new Vertex[2];
  private double value;

  public Edge(double value, Vertex v0, Vertex v1)
  {
    id = availableId;
    availableId ++;
    color = 'b';
    ends[0] = v0;
    ends[1] = v1;
    this.value = value;
  }

  public Edge(Vertex v0, Vertex v1)
  {
    id = availableId;
    availableId ++;
    color = 'b';
    ends[0] = v0;
    ends[1] = v1;
  }
  
  public int getId() { return id; }

  public char getColor() { return color; }
  public void setColor(char color) { this.color = color; }

  public double getValue() { return value; }
  public void setValue(double value) { this.value = value; }

  public Vertex[] getEnds() { return ends; }
  public void setEnds(int i, Vertex vertex) { ends[i] = vertex; }
  public void setEnds(Vertex[] ends) { this.ends = ends; }

  public String toString() { return "Une transition a été créée. Ses caractéristiques sont :\nId : " + id + "\nColor : " + color + "\nValue : " + value + "\n"; }
}