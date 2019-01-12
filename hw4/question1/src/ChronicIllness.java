

/**
 * concrete chronic illness
 */
public class ChronicIllness extends IbrahimState {
    @Override
    public void sleep() throws UnsupportedStateException {
        throw new UnsupportedStateException("sleep");
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
    public void coffeeAndWork() throws UnsupportedStateException {
        throw new UnsupportedStateException("koffee and work");
    }

    @Override
    public void cheat() throws UnsupportedStateException {
        throw new UnsupportedStateException("cheating");
    }

    public ChronicIllness(IbrahimYazici ibrahimYazici) {
        super(ibrahimYazici);
    }
}
