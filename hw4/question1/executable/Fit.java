/**
 * concrete fit
 */
public class Fit extends IbrahimState {

    public Fit(IbrahimYazici ibrahimYazici) {
        super(ibrahimYazici);
    }

    @Override
    public void hardworking(){
        alterState(getIbrahimYazici().getGraduate());
    }

    @Override
    public void sleep() throws UnsupportedStateException {
        throw new UnsupportedStateException("sleep");
    }


    @Override
    public void exercise() throws UnsupportedStateException {
        throw new UnsupportedStateException("exercise");
    }

    @Override
    public void outUntilLate() throws UnsupportedStateException {
        throw new UnsupportedStateException("out till late");
    }

    @Override
    public void buyingAGtx1080() throws UnsupportedStateException {
        throw new UnsupportedStateException("buying gpu");
    }

    @Override
    public void coffeeAndWork() throws UnsupportedStateException {
        throw new UnsupportedStateException("koffee and work");
    }

    @Override
    public void cheat() throws UnsupportedStateException {
        throw new UnsupportedStateException("cheating");
    }
}
