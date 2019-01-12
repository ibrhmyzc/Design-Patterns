package sample;

public class PlaneModel extends PlaneFactory {

    @Override
    TPXPlane buildPlane(String plane) {
        if(plane.equals("TPX 100"))
            return new TPX100();
        else if (plane.equals("TPX 200"))
            return new TPX200();
        else if(plane.equals("TPX 300"))
            return new TPX300();
        return null;
    }
}
