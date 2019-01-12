package sample;

public class TPX200 extends TPXPlane  {
    PlaneVariousFactory planeVariousFactory;
    public TPX200(PlaneVariousFactory planeVariousFactory) {
        this.planeVariousFactory = planeVariousFactory;
        super.setModel("TPX 200");
        super.setPurpose("DomesticFactory and short international flights");
        super.setSkeleton("Nickel alloy");
        super.setEngine("Two jet engines");
        super.setSeating(100);
        super.setEngineInjectionMethod(planeVariousFactory.createEngineInjectionType());
        super.setSeatingCover(planeVariousFactory.createSeatingCover());
    }
}
