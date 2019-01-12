
/**
 * concrete ready
 */
public class Ready extends IbrahimState {

    public Ready(IbrahimYazici ibrahimYazici){
        super(ibrahimYazici);
    }

    @Override
    public void exercise() {
        alterState(getIbrahimYazici().getFit());
    }

    @Override
    public void outUntilLate() {
        alterState(getIbrahimYazici().getNeedingSleep());
    }

    @Override
    public void buyingAGtx1080() {
        alterState(getIbrahimYazici().getUnableToBecomeARodForAnAxe());
    }

    @Override
    public void hardworking() {
        alterState(getIbrahimYazici().getGraduate());
    }

    @Override
    public void cheat() {
        alterState(getIbrahimYazici().getUnableToBecomeARodForAnAxe());
    }


    @Override
    public void sleep() throws UnsupportedStateException {
        throw new UnsupportedStateException("sleep");
    }

    @Override
    public void coffeeAndWork() throws UnsupportedStateException {
        throw new UnsupportedStateException("koffee and work");
    }


}
