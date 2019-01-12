package sample.server;

import sample.BulutGraph;
import sample.IbrahimInvocationHandler;
import sample.IbrahimsGraph;
import sample.RegisterWallet;

import java.lang.reflect.Proxy;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Server for the homework
 */
public class Server {
    public static void main(String[] args) throws RemoteException {

        /*
        https://stackoverflow.com/questions/7083908/do-i-need-all-classes-on-the-client-server-and-registry-for-rmi-to-work
         */
        try{
            IbrahimsGraph<String> ibrahimGraph = new BulutGraph();

            // For one of the bonus parts, registration is done through java rmi
            RegisterWallet registerWallet = new RegisterWallet();
            IbrahimsGraph<String> proxy = (IbrahimsGraph<String>)  Proxy.newProxyInstance(
                    ibrahimGraph.getClass().getClassLoader(),
                    ibrahimGraph.getClass().getInterfaces(),
                    new IbrahimInvocationHandler(ibrahimGraph, registerWallet)
            );

            // Rebinds happen here
            Naming.rebind("BulutGraph", UnicastRemoteObject.exportObject(proxy, 0));
            Naming.rebind("WolkesGraphRegister", UnicastRemoteObject.exportObject(registerWallet, 0));

            System.out.println("Server is running and waiting for clients");

        } catch(Exception e) {
            System.out.println("Exception xd" + System.lineSeparator() + e.getMessage());
        }
    }
}
