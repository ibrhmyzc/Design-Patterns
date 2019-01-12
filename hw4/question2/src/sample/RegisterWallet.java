package sample;

import java.rmi.Remote;
import java.util.HashMap;
import java.util.Map;

public class RegisterWallet implements RemoteRegisterWallet {
    private Map<Wallet, Double> wallets;

    /**
     * Instantiates the map
     */
    public RegisterWallet() {
        wallets = new HashMap<>();
    }

    /**
     * It is a synchronized method that returns the current balance of the given wallet
     * @param w Wallet object
     * @return the balance
     */
    public synchronized double getBalance(Wallet w){
        return wallets.get(w);
    }

    /**
     * Registers a new wallet in the map
     * @param w Wallet object
     */
    @Override
    public synchronized void register(Wallet w) {
        if(wallets.containsKey(w)){
            wallets.put(w, wallets.get(w));
        }else{
            wallets.put(w, 50.0);
        }
    }

    /**
     * Changes the amount of money in the wallet
     * @param w Wallet object
     * @param amount the balance
     */
    @Override
    public synchronized void changeBalance(Wallet w, double amount){
        if(wallets.containsKey(w)){
            wallets.replace(w, wallets.get(w) - amount);
        } else{
            wallets.put(w, amount);
        }
        System.out.println("number of members = " + wallets.size());
    }
}