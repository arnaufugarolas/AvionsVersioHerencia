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
            if (cords.getX() > 1000 || cords.getX() < 0) this.airport.remove(aircraft);
            else if (cords.getY() > 1000 || cords.getY() < 0) this.airport.remove(aircraft);
        }
    }

    public void showInfo() {
        System.out.println("\nSituació de les aeronaus: \n");
        for (Aircraft aircraft : this.airport) {
            System.out.println("Aeronau " + (airport.indexOf(aircraft) + 1));
            aircraft.showInfo();
            System.out.println();
        }
    }

    public void detectDangers() {
        ArrayList<Danger> dangers = new ArrayList<>();
        for (Aircraft aircraftA : this.airport) {
            for (Aircraft aircraftB : this.airport) {
                if (aircraftA == aircraftB) continue;
                Coordinates cords1 = aircraftA.getCoordinates();
                Coordinates cords2 = aircraftB.getCoordinates();
                if (Math.abs(aircraftA.getAltitude() - aircraftB.getAltitude()) < 500) {
                    if (Math.abs(cords1.getX() - cords2.getX()) < 50 || Math.abs(cords1.getY() - cords2.getY()) < 50) {
                        if (dangers.size() == 0) {
                            f.printInRed("\nHi ha un perill entre les aeronaus " + (airport.indexOf(aircraftA) + 1) + " i " + (airport.indexOf(aircraftB) + 1) + "!");
                            dangers.add(new Danger(aircraftA.getRegistration(), aircraftB.getRegistration()));
                        }
                        else {
                            for (Danger danger : dangers) {
                                if (!danger.getAircraftA().equals(aircraftB.getRegistration()) && !danger.getAircraftB().equals(aircraftA.getRegistration())) {
                                    f.printInRed("\nHi ha un perill entre les aeronaus " + (airport.indexOf(aircraftA) + 1) + " i " + (airport.indexOf(aircraftB) + 1) + "!");
                                    dangers.add(new Danger(aircraftA.getRegistration(), aircraftB.getRegistration()));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
