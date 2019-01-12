package sample;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Registers wallet through rmi
 */
public interface RemoteRegisterWallet extends Remote {
    /**
     * Registers a user to the system
     * @param w wallet of the client
     * @throws RemoteException exception
     */
    void register(Wallet w) throws RemoteException;

    /**
     * Returns the balance of the wallet
     * @param w Wallet of the client
     * @return balance
     * @throws RemoteException exception
     */
    double getBalance(Wallet w) throws RemoteException;

    /**
     * Changes the balance
     * @param w wallet of the user
     * @param amount amount of money changed
     * @throws RemoteException exception
     */
    void changeBalance(Wallet w, double amount) throws RemoteException;
}
