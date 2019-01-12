package sample;

/**
 * https://stackoverflow.com/questions/8423700/how-to-create-a-custom-exception-type-in-java
 */
public class OutOfMoneyException extends Exception{
    public OutOfMoneyException(){

    }
    public OutOfMoneyException(String message){
        super(message);
    }
    public OutOfMoneyException(Throwable cause){
        super(cause);
    }
    public OutOfMoneyException(String message, Throwable cause){
        super(message, cause);
    }
}
