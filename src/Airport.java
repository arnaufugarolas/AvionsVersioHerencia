import java.util.ArrayList;

public class Airport {
    private final ArrayList<Aircraft> airport = new ArrayList<>();
    private boolean freeAirstrip;
    private int numberAircraft;
    private int maximumAircraft;

    public Airport(int maximumAircraft) {
        this.freeAirstrip = true;
        numberAircraft = 0;
        this.maximumAircraft = maximumAircraft;
    }

    public ArrayList<Aircraft> getAirport() {
        return airport;
    }

    public boolean isFreeAirstrip() {
        return freeAirstrip;
    }

    public void setFreeAirstrip(boolean freeAirstrip) {
        this.freeAirstrip = freeAirstrip;
    }

    public int getNumberAircraft() {
        return numberAircraft;
    }

    public void setNumberAircraft(int numberAircraft) {
        this.numberAircraft = numberAircraft;
    }

    public int getMaximumAircraft() {
        return maximumAircraft;
    }

    public void setMaximumAircraft(int maximumAircraft) {
        this.maximumAircraft = maximumAircraft;
    }

    public boolean FreeRegistration(String registration) {
        for (Aircraft aircraft : airport) {
            if (aircraft.getRegistration().equals(registration)) return false;
        }
        return true;
    }

    public void addAircraft(Aircraft aircraft) {
        if (freeAirstrip) {
            if (numberAircraft < maximumAircraft) {
                airport.add(aircraft);
            }
            else throw new RuntimeException("S'ha arribat al màxim d'avions a gestionar (" + maximumAircraft + ")");

        }
        else throw new RuntimeException("La pista no està lliure");
    }

    public Aircraft AircraftByRegistration(String registration) {
        for (Aircraft aircraft : airport) {
            if (aircraft.getRegistration().equals(registration)) return aircraft;
        }
        return null;
    }

}
