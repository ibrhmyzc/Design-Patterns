package sample.graphClasses;

import java.io.Serializable;

/**
 * Generic Vertex
 * @param <T>
 */
public class Vertex<T> implements Serializable {
    private T vertex;

    public Vertex(T vertex) {
        this.vertex = vertex;
    }

    public T getVertex() {
        return vertex;
    }

    public void setVertex(T vertex) {
        this.vertex = vertex;
    }

    @Override
    public String toString() {
        return vertex.toString();
    }
}
