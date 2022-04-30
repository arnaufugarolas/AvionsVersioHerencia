abstract public class Aircraft {
    final Functions f = new Functions();

    // Attributes
    private final int crewMembers, autonomy;
    private final String registration, brand, model;
    private int orientation, speed, altitude;
    private boolean engine, landingGear;
    private Coordinates coordinates;

    // Constructor
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
        else f.printInRed("El motor ja està " + (engine ? "encès" : "apagat"));
    }

    public void setLandingGear(boolean landingGear) {
        if (this.landingGear != landingGear) this.landingGear = landingGear;
        else f.printInRed("El tren d'aterratge ja està" + (landingGear ? "baixat" : "pujat"));
    }

    public void setSpeed(int speed) { this.speed = speed; }
    public void setSpeed(boolean increase) {
        if (increase) this.speed = f.nextInt("Velocitat: ", this.speed + 1, Integer.MAX_VALUE);
        else this.speed = f.nextInt("Velocitat: ", 0, this.speed - 1);
    }

    // Methods
    public void showInfo() {
        System.out.println("Matrícula: " + this.registration);
        System.out.println("Marca: " + this.brand);
        System.out.println("Model: " + this.model);
        System.out.println("X: " + this.coordinates.getX());
        System.out.println("Y: " + this.coordinates.getX());
        System.out.println("Alçada: " + this.altitude);
        System.out.println("Velocitat: " + this.speed);
        System.out.println("Tren aterratge: " + (this.landingGear ? "On" : "Off"));
        System.out.println("Motor: " + (this.engine ? "On" : "Off"));
    }

}
