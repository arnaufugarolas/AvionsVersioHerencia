abstract public class Aircraft {
    private final Functions f = new Functions();
    private final int crewMembers, autonomy;
    private final String registration, brand, model;
    private int orientation, speed, altitude;
    private boolean engine, landingGear;
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

    // Getters
    public String getRegistration() { return registration; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getCrewMembers() { return crewMembers; }
    public Coordinates getCoordinates() { return coordinates; }
    public int getAltitude() { return altitude; }
    public int getAutonomy() { return autonomy; }
    public int getOrientation() { return orientation; }
    public int getSpeed() { return speed; }
    public boolean isEngine() { return engine; }
    public boolean isLandingGear() { return landingGear; }

    // Setters
    public void setCoordinates(Coordinates coordinates) { this.coordinates = coordinates; }
    public void setCoordinates() {
        int x = f.nextInt("Introdueix la coordenada X: ", "X: ");
        int y = f.nextInt("Introdueix la coordenada Y: ", "Y: ");
        this.coordinates = new Coordinates(x, y);
    }

    public void setAltitude(int altitude) { this.altitude = altitude; }
    public void setAltitude(boolean increase) {
        if (increase) this.altitude = f.nextInt("Altitud: ", this.altitude + 1, Integer.MAX_VALUE);
        else this.altitude = f.nextInt("Altitud: ", 0, this.altitude - 1);
    }

    public void setOrientation(int orientation) { this.orientation = orientation; }
    public void setOrientation() { this.orientation = f.nextInt("Introdueix el rumb de l'avió", "Rumb: ", 0, 360); }

    public void setEngine(boolean engine) {
        if (this.engine != engine) this.engine = engine;
        else throw new IllegalArgumentException("El motor ja està " + (engine ? "encès" : "apagat"));
    }

    public void setLandingGear(boolean landingGear) {
        if (this.landingGear != landingGear) this.landingGear = landingGear;
        else throw new IllegalArgumentException("El tren aterratge ja està" + (landingGear ? "pujat" : "baixat"));
    }

    public void setSpeed(int speed) { this.speed = speed; }
    public void setSpeed(boolean increase) {
        if (increase) this.speed = f.nextInt("Velocitat: ", this.speed + 1, Integer.MAX_VALUE);
        else this.speed = f.nextInt("Velocitat: ", 0, this.speed - 1);
    }
}
