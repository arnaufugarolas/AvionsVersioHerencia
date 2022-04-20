public class Combat extends Aircraft {
    private Missile[] missiles;
    private int distance;

    public Combat(String registration, String brand, String model, int crewMembers, Missile[] missiles, int distance) {
        super(registration, brand, model, crewMembers);
        this.missiles = missiles;
        this.distance = distance;
    }

    public Missile[] getMissiles() {
        return missiles;
    }

    public void setMissiles(Missile[] missiles) {
        this.missiles = missiles;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
