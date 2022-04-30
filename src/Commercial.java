public class Commercial extends Aircraft {
    // Attributes
    private final int capacity;
    private final String origin, destination;

    // Constructor
    public Commercial(String registration, String brand, String model, int crewMembers, int autonomy, int capacity, String origin, String destination) {
        super(registration, brand, model, crewMembers, autonomy);
        this.capacity = capacity;
        this.origin = origin;
        this.destination = destination;
    }

    // Getters
    public int getCapacity() { return this.capacity; }
    public String getOrigin() { return this.origin; }
    public String getDestination() { return this.destination; }

    // Methods
    public void showInfo() {
        super.showInfo();
        System.out.println("Origen: " + this.origin);
        System.out.println("Destinació: " + this.destination);
    }
}
