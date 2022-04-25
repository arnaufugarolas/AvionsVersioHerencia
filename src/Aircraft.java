abstract public class Aircraft {
    private int crewMembers, autonomy, orientation, speed;
    private boolean engine, landingGear;
    private String registration, brand, model;
    private Coordinates coordinates;
    static final Functions f = new Functions();

    public Aircraft(String registration, String brand, String model, int crewMembers, int autonomy) {
        this.registration = registration;
        this.brand = brand;
        this.model = model;
        this.crewMembers = crewMembers;
        this.speed = 0;
        this.autonomy = autonomy;
        this.orientation = 0;
        this.coordinates = new Coordinates(100, 110, 0);
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
        if (this.engine == engine) {;
            if (engine) f.printInRed("L'avió ja esta encès");
            else f.printInRed("L'avió ja esta apagat");
        }
        else this.engine = engine;
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

    public void setSpeed(int speed, boolean increase) {
        if (speed < 0) {
            boolean stop = false;
            while (!stop) {
                speed = f.nextInt("Introdueix la nova velocitat", "Velocitat: ");
                if (speed >= 0) stop = true;
            }
        }

        if (increase && speed > this.speed) this.speed = speed;
        else if (increase) f.printInRed("La velocitat no pot ser menor o igual a la velocitat actual");
        else if (speed < this.speed) this.speed = speed;
        else f.printInRed("La velocitat no pot ser major o igual a la velocitat actual");
    }
}
