package sample;

public class DomesticFactory implements PlaneVariousFactory {
    @Override
    public Engines createEngineInjectionType() {
        return new Turbojet();
    }

    @Override
    public Seats createSeatingCover() {
        return new Velvet();
    }
}
