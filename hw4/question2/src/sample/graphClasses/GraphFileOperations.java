package sample.graphClasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class helps generating a graph
 */
public class GraphFileOperations<T> {
    private Graph<T> graph;
    private String filename;
    private int numberOfVertices;
    private Set<Vertex<T>> listOfVertices;
    public GraphFileOperations(String filename) {
        this.filename = filename;
        listOfVertices = new HashSet<>();
        graph = new MyGraph<>();
    }

    /**
     * Construct a graph from a file
     * @return
     */
    public Graph constructGraphFromFile(){
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filename)));
            String line = "";
            line = bufferedReader.readLine();
            numberOfVertices = Integer.parseInt(line);

            // Read the list of vertices
            line = bufferedReader.readLine();
            String[] vertices = line.split("\\s+");

            for(int i= 0 ; i < numberOfVertices; ++i){
                //System.out.println("vertices added " + vertices[i]);
                listOfVertices.add(new Vertex<T>((T) vertices[i]));
                graph.addVertex(new Vertex<T>((T) vertices[i]));
            }

//            for(Vertex<T> v : listOfVertices){
//                System.out.println(v.toString());
//            }

            // Dealing with edges here
            while((line = bufferedReader.readLine()) != null){
                String[] strEdge = line.split("\\s+");

                Vertex<T> tmpSrc = new Vertex<>((T)strEdge[0]);
                Vertex<T> tmpDest = new Vertex<>((T)strEdge[1]);
                double weight = Double.parseDouble(strEdge[2]);
                Edge<T> tmpEdge = new Edge<>(tmpSrc, tmpDest, weight);
                graph.addEdge(tmpEdge);
            }
            bufferedReader.close();
        } catch (IOException e){
            System.out.println("file read error");
        }
        return graph;
    }

    /**
     * Checks the edge for errors
     * @param src to edge
     * @param dest from edge
     * @return validation
     */
    private boolean validateEdges(Vertex<T> src, Vertex<T> dest){
        return listOfVertices.contains(src) && listOfVertices.contains(dest);
    }

}
