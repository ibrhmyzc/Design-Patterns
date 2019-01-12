package sample;

import sample.graphClasses.Edge;
import sample.graphClasses.Graph;
import sample.graphClasses.Vertex;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class BulutGraph<T> implements IbrahimsGraph<T> {
    /**
     * Calculates the incidence matrix with a given graph
     * @param graph Graph
     * @param wallet wallet
     * @return a double matrix that represents incidence matrix
     */
    @Override
    public double[][] getIncidenceMatrix(Graph<T> graph, Wallet wallet) throws RemoteException, OutOfMoneyException {
        int sizeOfVertices = graph.getNumberOfVertices();
        int sizeofEdges = graph.getNumberOfEdges();
        double[][] incidenceMatrix = new double[sizeOfVertices][sizeofEdges];

        /*
         * Every edge must be checked
         * http://www.wikizeroo.net/index.php?q=aHR0cHM6Ly9lbi53aWtpcGVkaWEub3JnL3dpa2kvSW5jaWRlbmNlX21hdHJpeA
         * http://mathonline.wikidot.com/incidence-matrices
         */
        for(int i = 0 ; i < sizeofEdges; ++i){
            Vertex<T> src = graph.getEdges().get(i).getSrc();
            Vertex<T> dest = graph.getEdges().get(i).getDest();

            int indexOfSrc = getIndexOfSrc(src, graph.getVertices());
            int indexOfDest = getIndexOfSrc(dest, graph.getVertices());

            incidenceMatrix[indexOfSrc][i] = 1;
            incidenceMatrix[indexOfDest][i] = -1;
        }
        return incidenceMatrix;
    }

    /**
     * Returns the index of a vertex
     * @param vertex
     * @param vertices
     * @return
     */
    private int getIndexOfSrc(Vertex<T> vertex, List<Vertex<T>> vertices){
        int index = 0;
        for(int i = 0 ; i < vertices.size(); ++i){
            if(vertex.toString().equals(vertices.get(i).toString())){
                index = i;
            }
        }
        return index;
    }

    @Override
    public String getMinimumSpanningTree(Graph<T> graph, Wallet wallet) throws RemoteException, OutOfMoneyException{
        // It is here for only output
        List<Edge<T>> mstEdges = graph.getEdges();
        int numberOfVertices = graph.getNumberOfVertices();
        for(int i = 1; i < numberOfVertices; i+=2){
            if(mstEdges.size() > i)
                mstEdges.remove(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < mstEdges.size(); ++i){
            sb.append(mstEdges.get(i).toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }


}
