package sample;

public abstract class PlaneFactory {
    abstract TPXPlane buildPlane(String plane);

    /**
     * Orders a plane
     * @param plane_of_choioce plane model
     * @return deseired plane
     */
    public TPXPlane orderPlane(String plane_of_choioce) {
        TPXPlane plane = buildPlane(plane_of_choioce);
        System.out.println(plane.getModel() + " is ordered");
        plane.constructSkeleton();
        plane.placeEngines();
        plane.placeSeats();
        return plane;
    }
}
