package sample.graphClasses;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Generic graph
 * @param <T>
 */
public class MyGraph<T> implements Graph<T>, Serializable {
    private List<Edge<T>> edges;
    private List<Vertex<T>> vertices;

    public MyGraph() {
        edges = new ArrayList<>();
        vertices = new ArrayList<>();
    }

    @Override
    public List<Edge<T>> getEdges() {
        return edges;
    }

    @Override
    public List<Vertex<T>> getVertices() {
        return vertices;
    }


    @Override
    public void addVertex(Vertex<T> newVertex) {
        vertices.add(newVertex);
    }

    @Override
    public void addEdge(Edge<T> newEdge) {
        edges.add(newEdge);
    }

    @Override
    public String printGraph() {
        StringBuilder sb = new StringBuilder();

        for (Edge<T> edge : edges) {
            sb.append(edge.getSrc()).append(" -> ").append(edge.getDest()).
                    append(" with a weight of ").append(edge.getWeight()).append(System.lineSeparator());
        }

        return sb.toString();
    }

    @Override
    public int getNumberOfVertices() {
        return vertices.size();
    }

    @Override
    public int getNumberOfEdges() {
        return edges.size();
    }
}
