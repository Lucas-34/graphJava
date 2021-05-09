package graph;
import graph.*;

public class Vertex
{
  private static int availableId = 0;
  private final int id;
  private Object info;
  private char color;

  public Vertex(Object info)
  {
    this.id = availableId;
    availableId ++;
    this.info = info;
    color = 'b';
  }

  public Vertex()
  {
    this.id = availableId;
    availableId ++;
    color = 'b';
  }

  public int getId() { return id; }

  public Object getInfo() { return info; }
  public void setInfo(Object info) { this.info = info; }

  public char getColor() { return color; }
  public void setColor(char color) { this.color = color; }

  public String toString() { return "Un sommet a été créé. Ses caractéristiques sont :\nId : " + id + "\nInfo : " + info + "\nColor : " + color + "\n"; }
}