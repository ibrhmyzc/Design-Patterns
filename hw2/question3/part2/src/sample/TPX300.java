package sample;

public class TPX300 extends TPXPlane  {
    PlaneVariousFactory planeVariousFactory;
    public TPX300(PlaneVariousFactory planeVariousFactory) {
        this.planeVariousFactory = planeVariousFactory;
        super.setModel("TPX 300");
        super.setPurpose("Transatlantic flights");
        super.setSkeleton("Titanium alloy");
        super.setEngine("Quadro jet engines");
        super.setSeating(250);
        super.setEngineInjectionMethod(planeVariousFactory.createEngineInjectionType());
        super.setSeatingCover(planeVariousFactory.createSeatingCover());
    }
}
