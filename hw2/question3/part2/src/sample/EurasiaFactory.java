package sample;

public class EurasiaFactory implements PlaneVariousFactory {
    @Override
    public Engines createEngineInjectionType() {
        return new Turbofan();
    }

    @Override
    public Seats createSeatingCover() {
        return new Linen();
    }
}
