package sample;

import sample.graphClasses.Edge;
import sample.graphClasses.Graph;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Services that are provided by BulutCizge...
 */
public interface IbrahimsGraph<T> extends Remote {
    /**
     * Incidence matrix
     * @param graph graph
     * @param wallet wallet
     * @return result matrix
     * @throws RemoteException
     * @throws OutOfMoneyException
     */
    double[][] getIncidenceMatrix(Graph<T> graph, Wallet wallet) throws RemoteException, OutOfMoneyException;

    /**
     * Minimum spanning tree
     * @param graph graph
     * @return list of the edges that are needed to find mst
     */
    String getMinimumSpanningTree(Graph<T> graph, Wallet wallet) throws RemoteException, OutOfMoneyException;
}
