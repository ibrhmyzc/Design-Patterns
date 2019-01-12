package sample;

public abstract class TPXPlane {
    public String model;
    public String purpose;
    public String skeleton;
    public String engine;
    public int seating;

    /**
     * get model
     * @return model
     */
    public String getModel() {
        return model;
    }

    /**
     * set model
     * @param model model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * getPurpose
     * @return setpurpose
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     * set purpose
     * @param purpose
     */
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    /**
     * get skeleton
     * @return skeleton
     */
    public String getSkeleton() {
        return skeleton;
    }

    /**
     * set skeleton
     * @param skeleton skeleton
     */
    public void setSkeleton(String skeleton) {
        this.skeleton = skeleton;
    }

    /**
     * get engine
     * @return engine
     */
    public String getEngine() {
        return engine;
    }

    /**
     * set Engine
     * @param engine engine
     */
    public void setEngine(String engine) {
        this.engine = engine;
    }

    /**
     * get seating
     * @return seating
     */
    public int getSeating() {
        return seating;
    }

    /**
     * set seating
     * @param seating eating
     */
    public void setSeating(int seating) {
        this.seating = seating;
    }

    @Override
    public String toString() {
        return "TPXPlane{" +
                "model='" + model + '\'' +
                ", purpose='" + purpose + '\'' +
                ", skeleton='" + skeleton + '\'' +
                ", engine='" + engine + '\'' +
                ", seating=" + seating +
                '}';
    }

    /**
     * construct the skeleton
     */
    public void constructSkeleton() {
        System.out.println("");
    }

    /**
     * place the engine of the plane
     */
    public void placeEngines(){

    }

    /**
     * place the seats of the plane
     */
    public void placeSeats(){

    }
}
