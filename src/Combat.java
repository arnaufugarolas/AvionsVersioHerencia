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
    public Missile[] getMissiles() { return missiles; }
    public int getShotDistance() { return shotDistance; }
}
