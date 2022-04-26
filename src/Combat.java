public class Combat extends Aircraft {
    private Missile[] missiles;
    private int shotDistance;

    public Combat(String registration, String brand, String model, int crewMembers, int autonomy, int numberMissiles, int shotDistance) {
        super(registration, brand, model, crewMembers, autonomy);
        this.shotDistance = shotDistance;
        this.missiles = new Missile[numberMissiles];
        for (int i = 0; i < numberMissiles; i++) this.missiles[i] = new Missile();
    }

    public Combat(Combat combat) {
        super(combat);
        this.shotDistance = combat.getShotDistance();
        this.missiles = new Missile[combat.getMissiles().length];
        for (int i = 0; i < this.missiles.length; i++) this.missiles[i] = new Missile();
    }

    public Missile[] getMissiles() {
        return missiles;
    }

    public void setMissiles(Missile[] missiles) {
        this.missiles = missiles;
    }

    public int getShotDistance() {
        return shotDistance;
    }

    public void setShotDistance(int shotDistance) {
        if (shotDistance > 0) this.shotDistance = shotDistance;
        else throw new IllegalArgumentException("La distancia de dispar ha de ser més gran de 0");
    }
}
