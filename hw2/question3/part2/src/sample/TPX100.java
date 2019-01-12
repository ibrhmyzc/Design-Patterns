package sample;

public class TPX100 extends TPXPlane {
    PlaneVariousFactory planeVariousFactory;
    public TPX100(PlaneVariousFactory planeVariousFactory) {
        this.planeVariousFactory = planeVariousFactory;
        super.setModel("TPX 100");
        super.setPurpose("DomesticFactory flights");
        super.setSkeleton("Aluminum alloy");
        super.setEngine("Single jet engine");
        super.setSeating(50);
        super.setEngineInjectionMethod(planeVariousFactory.createEngineInjectionType());
        super.setSeatingCover(planeVariousFactory.createSeatingCover());
    }
}
