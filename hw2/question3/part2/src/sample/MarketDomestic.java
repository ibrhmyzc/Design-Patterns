package sample;

public class MarketDomestic extends PlaneFactory{
    @Override
    TPXPlane buildPlane(String plane) {
        TPXPlane tpxPlane = null;
        PlaneVariousFactory planeVariousFactory = new DomesticFactory();
        if(plane.equals("TPX 100")){
            tpxPlane = new TPX100(planeVariousFactory);
        }
        return  tpxPlane;
    }
}
