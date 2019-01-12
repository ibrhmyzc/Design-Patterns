

/**
 * Poor ibrahim that follows the pattern below
 */
public class IbrahimYazici {
    private State currentState;
    private State graduate;
    private State fit;
    private State ready;
    private State needingSleep;
    private State unableToBecomeARodForAnAxe;
    private State chronicIllness;

    /**
     * Constructor for this class
     * instantiating
     */
    public IbrahimYazici() {
        graduate = new Graduate(this);
        fit = new Fit(this);
        ready = new Ready(this);
        needingSleep = new NeedingSleep(this);
        unableToBecomeARodForAnAxe = new UnableToBecomeARodForAnAxe(this);
        chronicIllness = new ChronicIllness(this);

        currentState = ready;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public State getGraduate() {
        return graduate;
    }

    public State getFit() {
        return fit;
    }

    public State getReady() {
        return ready;
    }

    public State getNeedingSleep() {
        return needingSleep;
    }

    public State getUnableToBecomeARodForAnAxe() {
        return unableToBecomeARodForAnAxe;
    }

    public State getChronicIllness() {
        return chronicIllness;
    }

    void sleep() throws UnsupportedStateException {
        currentState.sleep();
    }

    void hardworking() throws UnsupportedStateException{
        currentState.hardworking();
    }

    void exercise() throws UnsupportedStateException{
        currentState.exercise();
    }

    void outUntilLate() throws UnsupportedStateException{
        currentState.outUntilLate();
    }

    void buyingAGtx1080()throws UnsupportedStateException{
        currentState.buyingAGtx1080();
    }

    void coffeeAndWork() throws UnsupportedStateException{
        currentState.coffeeAndWork();
    }

    void cheat() throws UnsupportedStateException{
        currentState.cheat();
    }

}
