

/**
 * class for abstract state
 */
public class IbrahimState implements State {
    private IbrahimYazici ibrahimYazici;

    public IbrahimState(IbrahimYazici ibrahimYazici){
        this.ibrahimYazici = ibrahimYazici;
    }

    public void alterState(State desiredState) {
        System.out.print("Old state is " + getIbrahimYazici().getCurrentState());
        getIbrahimYazici().setCurrentState(desiredState);
        System.out.println("---> New state is " + getIbrahimYazici().getCurrentState());
    }

    public IbrahimYazici getIbrahimYazici() {
        return ibrahimYazici;
    }

    public void setIbrahimYazici(IbrahimYazici ibrahimYazici) {
        this.ibrahimYazici = ibrahimYazici;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void sleep() throws UnsupportedStateException {
        throw new UnsupportedStateException(" not implemented");
    }

    @Override
    public void hardworking() throws UnsupportedStateException {
        throw new UnsupportedStateException(" not implemented");
    }

    @Override
    public void exercise() throws UnsupportedStateException {
        throw new UnsupportedStateException(" not implemented");
    }

    @Override
    public void outUntilLate() throws UnsupportedStateException {
        throw new UnsupportedStateException(" not implemented");
    }

    @Override
    public void buyingAGtx1080() throws UnsupportedStateException {
        throw new UnsupportedStateException(" not implemented");
    }

    @Override
    public void coffeeAndWork() throws UnsupportedStateException {
        throw new UnsupportedStateException(" not implemented");
    }

    @Override
    public void cheat() throws UnsupportedStateException {
        throw new UnsupportedStateException(" not implemented");
    }
}
