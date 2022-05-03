abstract public class Aircraft {
    final Functions f = new Functions();
    
    // Attributes
    private final int crewMembers, autonomy;
    private final String registration, brand, model;
    private int orientation, speed, altitude;
    private boolean engine, landingGear, destroyed;
    private Coordinates coordinates;
    
    // Constructor
    public Aircraft(String registration, String brand, String model, int crewMembers, int autonomy) {
        this.registration = registration;
        this.brand = brand;
        this.model = model;
        this.coordinates = new Coordinates(100, 100);
        this.crewMembers = crewMembers;
        this.autonomy = autonomy;
        this.speed = 0;
        this.orientation = 0;
        this.altitude = 0;
        this.landingGear = true;
        this.engine = false;
        this.destroyed = false;
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
    public boolean isDestroyed() { return destroyed; }
    
    // Setters
    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }
    
    public void setCoordinates(Coordinates coordinates) { this.coordinates = coordinates; }
    public void setCoordinates() {
        if (!this.engine) {
            f.printInRed("El motor no esta ences");
            return;
        }
        int x = f.nextInt("Introdueix la coordenada X: ", "X: ");
        int y = f.nextInt("Introdueix la coordenada Y: ", "Y: ");
        this.coordinates = new Coordinates(x, y);
    }
    
    public void setAltitude(int altitude) { this.altitude = altitude; }
    public void setAltitude(boolean increase) {
        if (!this.engine) {
            f.printInRed("El motor no esta ences");
            return;
        }
        int newAltitude = 0;
        if (increase) {
            if (this.altitude == 0) {
                if (!this.isInAirstrip()) {
                    f.printInRed("No estas a la pista d'enlairament (X = 100, Y = 100-120) aixo vol dir que no pots despegar");
                    return;
                }
                else if (!(this.speed >= 180)) {
                    f.printInRed("La velocitat ha de ser igual o superior a 180 km/h per despegar");
                    return;
                }
            }
            newAltitude = f.nextInt("Altitud: ", this.altitude + 1, Integer.MAX_VALUE);
            if (newAltitude > 500 && this.landingGear) {
                f.printInRed("No pots passar de 500 metres d'alcada sense amagar el tren d'aterratge");
                this.altitude = 500;
            }
            else this.altitude = newAltitude;
        }
        else {
            newAltitude = f.nextInt("Altitud: ", 0, this.altitude - 1);
            if (newAltitude == 0) {
                if (!this.isInAirstrip()) {
                    f.printInRed("Has intentat aterrar pero com que no estabes a la pista d'aterratge l'avio s'ha destruit");
                    this.destroyed = true;
                    return;
                }
                else if (!this.landingGear) {
                    f.printInRed("Has intentat aterrar pero com que no has baixat el tren d'aterratge l'avio s'ha destruit");
                    this.destroyed = true;
                    return;
                }
                else if (this.speed > 200) {
                    f.printInRed("Has intentat aterrar pero com que anaves a mes de 200 km/h l'avio s'ha destruit");
                    this.destroyed = true;
                    return;
                }
            }
            this.altitude = newAltitude;
        }
        
        System.out.println("L'altitud actual es " + this.altitude);
    }
    
    public void setOrientation(int orientation) { this.orientation = orientation; }
    public void setOrientation() { this.orientation = f.nextInt("Introdueix el rumb de l'avió", "Rumb: ", 0, 360); }
    
    public void setEngine(boolean engine) {
        if (this.engine != engine) {
            this.engine = engine;
            System.out.println("El motor ha estat " + (engine ? "ences" : "apagat"));
        }
        else f.printInRed("El motor ja esta " + (engine ? "ences" : "apagat"));
    }
    
    public void setLandingGear(boolean landingGear) {
        if (this.altitude > 500) {
            f.printInRed("No pots baixar el tren d'aterratge si estas a mes de 500 metres d'alcada");
            return;
        }
        if (this.speed > 300) {
            f.printInRed("No pots baixar el tren d'aterratge si vas a mes de 300 km/h");
            return;
        }
        
        if (this.landingGear != landingGear) {
            this.landingGear = landingGear;
            System.out.println("El tren d'aterratge ha estat " + (landingGear ? "baixat" : "pujat"));
        }
        else f.printInRed("El tren d'aterratge ja esta" + (landingGear ? "baixat" : "pujat"));
    }
    
    public void setSpeed(int speed) { this.speed = speed; }
    public void setSpeed(boolean increase) {
        if (!this.engine) {
            f.printInRed("El motor no esta ences");
            return;
        }
        if (increase) this.speed = f.nextInt("Velocitat: ", this.speed + 1, Integer.MAX_VALUE);
        else this.speed = f.nextInt("Velocitat: ", 0, this.speed - 1);
    }
    
    // Methods
    public void showInfo() {
        System.out.println("Matricula: " + this.registration);
        System.out.println("Marca: " + this.brand);
        System.out.println("Model: " + this.model);
        System.out.println("X: " + this.coordinates.getX());
        System.out.println("Y: " + this.coordinates.getY());
        System.out.println("Alcada: " + this.altitude);
        System.out.println("Velocitat: " + this.speed);
        System.out.println("Tren aterratge: " + (this.landingGear ? "On" : "Off"));
        System.out.println("Motor: " + (this.engine ? "On" : "Off"));
    }
    
    public void atack(Airport airport) { f.printInRed("Aquest avio no pot atacar, no es un avio de combat"); }
    
    public boolean isInAirstrip() {
        Coordinates c = this.coordinates;
        return (c.getX() == 100 && (c.getY() >= 100 && c.getY() <= 120));
    }
}
