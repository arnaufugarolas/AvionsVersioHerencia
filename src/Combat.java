public class Combat extends Aircraft {
    private Missile[] missiles;
    private int shotDistance;

    public Combat(String registration, String brand, String model, int crewMembers, int autonomy, int numberMissiles, int shotDistance) {
        super(registration, brand, model, crewMembers, autonomy);
        this.shotDistance = shotDistance;
        this.missiles = new Missile[numberMissiles];
        for (int i = 0; i < numberMissiles; i++) this.missiles[i] = new Missile();
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
        this.shotDistance = shotDistance;
    }
}
