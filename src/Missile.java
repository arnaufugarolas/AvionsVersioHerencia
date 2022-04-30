public class Missile {
    private boolean used;

    public Missile() {
        this.used = false;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        if (this.used) throw new IllegalArgumentException("El míssil ja està " + (used ? "usat" : "no usat"));
        else this.used = used;
    }
}
