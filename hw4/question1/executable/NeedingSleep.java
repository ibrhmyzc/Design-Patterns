
/**
 * concrete needingsleep
 */
public class NeedingSleep extends IbrahimState {
    public NeedingSleep (IbrahimYazici ibrahimYazici){
        super(ibrahimYazici);
    }

    @Override
    public void coffeeAndWork(){
        alterState(getIbrahimYazici().getChronicIllness());
    }

    @Override
    public void sleep(){
        alterState(getIbrahimYazici().getReady());
    }


    @Override
    public void hardworking() throws UnsupportedStateException {
        throw new UnsupportedStateException("hardworking");
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
    public void cheat() throws UnsupportedStateException {
        throw new UnsupportedStateException("cheating");
    }
}
