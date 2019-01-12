package sample;

public abstract class TPXPlane {
    public String model;
    public String purpose;
    public String skeleton;
    public String engine;
    public int seating;
    public Engines engineInjectionMethod;
    public Seats seatingCover;

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

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public Engines getEngineInjectionMethod() {
        return engineInjectionMethod;
    }

    public void setEngineInjectionMethod(Engines engineInjectionMethod) {
        this.engineInjectionMethod = engineInjectionMethod;
    }

    public Seats getSeatingCover() {
        return seatingCover;
    }

    public void setSeatingCover(Seats seatingCover) {
        this.seatingCover = seatingCover;
    }

    @Override
    public String toString() {
        return "TPXPlane{" +
                "model='" + model + '\'' +
                System.lineSeparator() +
                ", purpose='" + purpose + '\'' +
                System.lineSeparator() +
                ", skeleton='" + skeleton + '\'' +
                System.lineSeparator() +
                ", engine='" + engine + '\'' +
                System.lineSeparator() +
                ", seating=" + seating +
                System.lineSeparator() +
                ", EngineInjectionMethod='" + engineInjectionMethod.toString() + '\'' +
                System.lineSeparator() +
                ", SeatingCover='" + seatingCover.toString() + '\'' +
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
