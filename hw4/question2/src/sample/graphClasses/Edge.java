package sample.graphClasses;
import java.io.Serializable;

/**
 * Generic edge
 * @param <T>
 */
public class Edge<T> implements Serializable, Comparable<Edge<T>> {
    private Vertex<T> src;
    private Vertex<T> dest;
    private double weight;

    public Edge(Vertex<T> src, Vertex<T> dest, double weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;

    }

    public Vertex<T> getSrc() {
        return src;
    }

    public Vertex<T> getDest() {
        return dest;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return src.toString() + " -> " + dest.toString() + " with a weight of " + weight;
    }

    @Override
    public int compareTo(Edge<T> o) {
        return Double.compare(this.getWeight(), o.getWeight());
    }
}
