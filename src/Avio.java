public class Avio {
    private String matricula;
    private String marca;
    private String model;
    private boolean motor;
    private boolean tren;
    private int tripulants;
    private int[] coordenades;
    private int autonomia;
    private int rumb;

    public Avio(String matricula, String marca, String model, boolean motor, boolean tren, int tripulants, int[] coordenades, int autonomia, int rumb) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.motor = motor;
        this.tren = tren;
        this.tripulants = tripulants;
        this.coordenades = coordenades;
        this.autonomia = autonomia;
        this.rumb = rumb;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isMotor() {
        return motor;
    }

    public void setMotor(boolean motor) {
        this.motor = motor;
    }

    public boolean isTren() {
        return tren;
    }

    public void setTren(boolean tren) {
        this.tren = tren;
    }

    public int getTripulants() {
        return tripulants;
    }

    public void setTripulants(int tripulants) {
        this.tripulants = tripulants;
    }

    public int[] getCoordenades() {
        return coordenades;
    }

    public void setCoordenades(int[] coordenades) {
        this.coordenades = coordenades;
    }

    public int getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }

    public int getRumb() {
        return rumb;
    }

    public void setRumb(int rumb) {
        this.rumb = rumb;
    }
}
