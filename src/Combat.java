public class Combat extends Aircraft {
    final Functions f = new Functions();

    // Attributes
    private final Missile[] missiles;
    private final int shotDistance;

    // Constructor
    public Combat(String registration, String brand, String model, int crewMembers, int autonomy, int numberMissiles, int shotDistance) {
        super(registration, brand, model, crewMembers, autonomy);
        this.shotDistance = shotDistance;
        this.missiles = new Missile[numberMissiles];
        for (int i = 0; i < numberMissiles; i++) this.missiles[i] = new Missile();
    }

    // Getters
    public Missile[] getMissiles() {
        return missiles;
    }

    public int getShotDistance() {
        return shotDistance;
    }

    // Methods
    public void showInfo() {
        super.showInfo();
        System.out.print("Misils: ");
        for (Missile missile : this.missiles) { System.out.print((missile.isUsed() ? "usat " : "disponible ")); }
        System.out.println();
    }

    public void atackCommercial(Airport airport) {
        Coordinates cords = this.getCoordinates();
        for (Aircraft aircraft : airport.getAirport()) {
            if (aircraft instanceof Combat) {
                if (this == aircraft) continue;
                Coordinates cords2 = aircraft.getCoordinates();
                if (Math.abs(cords.getX() - cords2.getX()) <= this.shotDistance && Math.abs(cords.getY() - cords2.getY()) <= this.shotDistance) {
                    System.out.printf("L'avio %s es pot atacar ja que esta dintre de la distancia de disparo (%d)", aircraft.getRegistration(), this.shotDistance);
                    int confirm = f.nextInt("\nVols atacar aquest avi? (1: si, 0: no): ", 1, 2);
                    if (confirm == 1) {
                        Combat enemy = (Combat) aircraft;
                        boolean hit = false;
                        for (Missile missile : this.missiles) {
                            if (!missile.isUsed()) {
                                missile.setUsed(true);
                                System.out.printf("L'avio %s ha disparat un misil a l'avio %s\n", this.getRegistration(), aircraft.getRegistration());
                                airport.removeAircraft(enemy);
                                hit = true;
                                break;
                            }
                        }
                        if (!hit) { System.out.println("L'avio " + this.getRegistration() + " no te misils disponibles, no s'ha pogut atacar"); }
                        break;
                    }
                }
            }
        }
    }
}
