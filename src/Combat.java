public class Combat extends Aircraft {
    private Missile[] missiles;
    private int shotDistance;

    public Combat(String registration, String brand, String model, int crewMembers, int num_missiles, int shotDistance) {
        super(registration, brand, model, crewMembers);
        Missile[] missiles = new Missile[num_missiles];
        for (int i = 0; i < num_missiles; i++) missiles[i] = new Missile();
        this.missiles = missiles;
        this.shotDistance = shotDistance;
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
