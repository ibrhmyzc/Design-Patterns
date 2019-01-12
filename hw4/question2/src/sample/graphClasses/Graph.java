package sample.graphClasses;

import java.util.List;

/**
 * Insane graph interface
 * @param <T>
 */
public interface Graph<T> {
   /**
    * adds a vertex
    * @param newVertex new vertex
    */
   void addVertex(Vertex<T> newVertex);

   /**
    * ads a new edge
    * @param newEdge new edge
    */
   void addEdge(Edge<T> newEdge);

   /**
    * prints the graph
    * @return string of graph
    */
   String printGraph();

   /**
    * numbers of vertices
    * @return numbers of vertices
    */
   int getNumberOfVertices();

   /**
    * number of edges
    * @return number of edges
    */
   int getNumberOfEdges();

   /**
    * edges
    * @return edges
    */
   List<Edge<T>> getEdges();

   /**
    * vertices
    * @return vertices
    */
   List<Vertex<T>> getVertices();
}
