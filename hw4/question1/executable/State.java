
/**
 * Interface that has all
 */
public interface State {
    /**
     *  sleep
     */
    void sleep() throws UnsupportedStateException;
    /**
     * hardworking
     */
    void hardworking() throws UnsupportedStateException;
    /**
     * exercise
     */
    void exercise() throws UnsupportedStateException;
    /**
     *  outUntilLate
     */
    void outUntilLate() throws UnsupportedStateException;
    /**
     * buyingAGtx1080
     */
    void buyingAGtx1080() throws UnsupportedStateException;
    /**
     * coffeeAndWork
     */
    void coffeeAndWork() throws UnsupportedStateException;
    /**
     * cheat
     */
    void cheat() throws UnsupportedStateException;
}
