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
    public int getCapacity() { return capacity; }
    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }
}
