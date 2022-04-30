public class Missile {
    // Attributes
    private boolean used;

    // Constructor
    public Missile() { this.used = false; }

    // Getters
    public boolean isUsed() { return used; }

    // Setters
    public void setUsed(boolean used) {
        if (this.used) throw new IllegalArgumentException("El míssil ja està " + (used ? "usat" : "no usat"));
        else this.used = used;
    }
}
