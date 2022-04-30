abstract public class Aircraft {
    private int crewMembers, autonomy, orientation, speed, altitude;
    private boolean engine, landingGear;
    private String registration, brand, model;
    private Coordinates coordinates;

    public Aircraft(String registration, String brand, String model, int crewMembers, int autonomy) {
        this.registration = registration;
        this.brand = brand;
        this.model = model;
        this.crewMembers = crewMembers;
        this.speed = 0;
        this.autonomy = autonomy;
        this.orientation = 0;
        this.coordinates = new Coordinates(100, 110);
        this.altitude = 0;
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

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude, boolean increase) {
        if (altitude < 0) throw new IllegalArgumentException("L'altitud minima es 0");
        if (increase && altitude > this.altitude) this.altitude = altitude;
        else if (increase) throw new IllegalArgumentException("L'altitud no pot ser menor o igual a l'altitud actual");
        else if (altitude < this.altitude) this.altitude = altitude;
        else throw new IllegalArgumentException("L'altitud no pot ser major o igual a l'altitud actual");
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
        if (orientation >= 0 && orientation <= 360) this.orientation = orientation;
        else throw new IllegalArgumentException("L'orientació ha d'estar entre 0º i 360º");
    }

    public boolean isEngine() {
        return engine;
    }

    public void setEngine(boolean engine) {
        if (this.engine != engine) this.engine = engine;
        else throw new IllegalArgumentException("El motor ja està " + (engine ? "encès" : "apagat"));
    }

    public boolean isLandingGear() {
        return landingGear;
    }

    public void setLandingGear(boolean landingGear) {
        if (this.landingGear != landingGear) this.landingGear = landingGear;
        else throw new IllegalArgumentException("El tren aterratge ja està" + (landingGear ? "pujat" : "baixat"));
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed, boolean increase) {
        if (speed < 0) throw new IllegalArgumentException("La velocitat minima es 0");
        if (increase && speed > this.speed) this.speed = speed;
        else if (increase) throw new IllegalArgumentException("La velocitat no pot ser menor o igual a la velocitat actual");
        else if (speed < this.speed) this.speed = speed;
        else throw new IllegalArgumentException("La velocitat no pot ser major o igual a la velocitat actual");
    }
}
