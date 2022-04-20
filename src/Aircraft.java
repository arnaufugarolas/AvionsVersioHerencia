public class Aircraft {
    private String registration;
    private String brand;
    private String model;
    private int crewMembers;
    private Coordinates coordinates;
    private int autonomy;
    private int orientation;
    private int speed;
    private boolean engine;
    private boolean landingGear;

    public Aircraft(String registration, String brand, String model, int crewMembers) {
        this.registration = registration;
        this.brand = brand;
        this.model = model;
        this.crewMembers = crewMembers;
        this.speed = 0;
        this.autonomy = 0;
        this.orientation = 0;
        this.coordinates = new Coordinates(100, 100, 0);
        this.engine = false;
        this.landingGear = true;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCrewMembers() {
        return crewMembers;
    }

    public void setCrewMembers(int crewMembers) {
        this.crewMembers = crewMembers;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public int getAutonomy() {
        return autonomy;
    }

    public void setAutonomy(int autonomy) {
        this.autonomy = autonomy;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public boolean isEngine() {
        return engine;
    }

    public void setEngine(boolean engine) {
        this.engine = engine;
    }

    public boolean isLandingGear() {
        return landingGear;
    }

    public void setLandingGear(boolean landingGear) {
        this.landingGear = landingGear;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
