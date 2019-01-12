package sample;

public class OtherFactory implements PlaneVariousFactory {

    @Override
    public Engines createEngineInjectionType() {
        return new GearedTurbofan();
    }

    @Override
    public Seats createSeatingCover() {
        return new Leather();
    }
}
