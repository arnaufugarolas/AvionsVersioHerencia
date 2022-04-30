import java.util.ArrayList;

public class Airport {
    final Functions f = new Functions();

    // Attributes
    private final ArrayList<Aircraft> airport = new ArrayList<>();
    private final int maximumAircraft;
    private boolean freeAirstrip;
    private int numberAircraft;

    // Constructor
    public Airport(int maximumAircraft) {
        this.freeAirstrip = true;
        this.numberAircraft = 0;
        this.maximumAircraft = maximumAircraft;
    }

    // Getters
    public ArrayList<Aircraft> getAirport() { return this.airport; }
    public int getNumberAircraft() { return this.numberAircraft; }
    public int getMaximumAircraft() { return this.maximumAircraft; }

    // Setters
    public void setFreeAirstrip(boolean freeAirstrip) { this.freeAirstrip = freeAirstrip; }
    public void setNumberAircraft(int numberAircraft) { this.numberAircraft = numberAircraft; }
    public boolean isFreeAirstrip() { return this.freeAirstrip;}

    // Methods
    public boolean freeRegistration(String registration) {
        for (Aircraft aircraft : this.airport) {
            if (aircraft.getRegistration().equals(registration)) return false;
        }
        return true;
    }

    public Aircraft aircraftByRegistration(String registration) {
        for (Aircraft aircraft : this.airport) {
            if (aircraft.getRegistration().equals(registration)) return aircraft;
        }
        return null;
    }

    public void addAircraft(Aircraft aircraft) {
        if (this.freeAirstrip) {
            if (this.numberAircraft < this.maximumAircraft) {
                airport.add(aircraft);
                numberAircraft++;
                freeAirstrip = false;
            }
            else f.printInRed("S'ha arribat al màxim d'avions a gestionar (" + this.maximumAircraft + ")");
        }
        else f.printInRed("La pista no està lliure");
    }

    public void maintenance() {
        for (Aircraft aircraft : this.airport) {
            Coordinates cords = aircraft.getCoordinates();
            if (cords.x() > 1000 || cords.x() < 0) this.airport.remove(aircraft);
            else if (cords.y() > 1000 || cords.y() < 0) this.airport.remove(aircraft);
        }
    }

    public void showInfo() {
        f.notImplemented();
    }

    public void detectDangers() {
        f.notImplemented();
    }

}
