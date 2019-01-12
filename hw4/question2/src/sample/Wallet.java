package sample;

import java.io.Serializable;
import java.util.Objects;

public class Wallet implements Serializable {
    private int clientId;

    public Wallet(int clientId) {
        this.clientId = clientId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }


    /*
    https://stackoverflow.com/questions/2265503/why-do-i-need-to-override-the-equals-and-hashcode-methods-in-java
     */

    @Override
    public int hashCode() {
        return Objects.hash(clientId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Wallet wallet = (Wallet) obj;

        if(Objects.equals(clientId, wallet.clientId)){
            return true;
        } else{
            return false;
        }
    }
}

