package sample;

public class PlaneModelOther extends PlaneFactory {
    @Override
    TPXPlane buildPlane(String plane) {
        TPXPlane tpxPlane = null;
        PlaneVariousFactory planeVariousFactory = new OtherFactory();
        if(plane.equals("TPX 100"))
            tpxPlane =  new TPX100(planeVariousFactory);
        else if (plane.equals("TPX 200"))
            tpxPlane = new TPX200(planeVariousFactory);
        else if(plane.equals("TPX 300"))
            tpxPlane = new TPX300(planeVariousFactory);
        return  tpxPlane;
    }
}
