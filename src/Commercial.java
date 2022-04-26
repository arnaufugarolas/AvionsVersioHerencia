public class Commercial extends Aircraft {
    private int capacity;
    private String origin;
    private String destination;

    public Commercial(String registration, String brand, String model, int crewMembers, int autonomy, int capacity, String origin, String destination) {
        super(registration, brand, model, crewMembers, autonomy);
        this.capacity = capacity;
        this.origin = origin;
        this.destination = destination;
    }

    public Commercial(Commercial commercial) {
        super(commercial);
        this.capacity = commercial.getCapacity();
        this.origin = commercial.getOrigin();
        this.destination = commercial.getDestination();
    }

    public Commercial() {
        super("", "", "", 0, 0);
        this.capacity = 0;
        this.origin = "";
        this.destination = "";
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
