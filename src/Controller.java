public class Controller {
    static final int maximumAircraft = 10;
    static final Functions f = new Functions();
    static final Airport airport = new Airport(maximumAircraft);
    
    public static void addAircraft() {
        String registration = null;
        String destination = null;
        boolean next;
        
        if (airport.getNumberAircraft() >= maximumAircraft) {
            f.printInRed("L'espai aeri esta complert");
            return;
        }
        airport.checkAirstrip();
        if (!airport.isFreeAirstrip()) {
            f.printInRed("La pistaesta ocupada");
            return;
        }
        
        int type = f.nextInt("\nConsola de creacio d'avions\nTipus d'avions disponibles:\n\t1- Avio de combat\n\t2- Avio comercial", "Tipus: ", 1 , 2);
        
        next = false;
        while (!next) {
            registration = f.nextString("Introdueix la matricula de l'avio", "Matricula: ");
            if (airport.freeRegistration(registration)) next = true;
            else f.printInRed("Matricula repetida");
        }
        
        String brand = f.nextString("Introdueix la marca de l'avio", "Marca: ");
        String model = f.nextString("Introdueix el model de l'avio", "Model: ");
        int crewMembers = f.nextInt("Introdueix el nombre de tripulants de l'avio", "Tripulants: ", 0, Integer.MAX_VALUE);
        int autonomy = f.nextInt("Introdueix l'autonomia de l'avio", "Autonomia: ", 0, Integer.MAX_VALUE);
        
        if (type == 1) {
            int missile = f.nextInt("Introdueix el nombre de missils de l'avio", "Missils: ", 0, Integer.MAX_VALUE);
            int shotDistance = f.nextInt("Introdueix la distancia maxima de llancament de l'avio", "Distancia: ", 0, Integer.MAX_VALUE);
            
            try { airport.addAircraft(new Combat(registration, brand, model, crewMembers, autonomy, missile, shotDistance)); }
            catch (Exception e) { f.printInRed(e.toString()); }
        }
        else {
            int capacity = f.nextInt("Introdueix la capacitat maxima de l'avio", "Capacitat: ", 0, Integer.MAX_VALUE);
            String origin = f.nextString("Introdueix l'origen de l'avio", "Origen: ");
            
            next = false;
            while (!next) {
                destination = f.nextString("Introdueix el desti de l'avio", "Desti: ");
                if (!origin.equals(destination)) next = true;
                else f.printInRed("El desti de l'avio no pot ser l'origen");
            }
            
            try { airport.addAircraft(new Commercial(registration, brand, model, crewMembers, autonomy, capacity, origin, destination)); }
            catch (Exception e) { f.printInRed(e.toString()); }
        }
    }
    
    public static void manageAircraft() {
        String registration = f.nextString("Introdueix la matricula de l'avio a gestionar", "Matricula: ");
        
        if (airport.freeRegistration(registration)) {
            f.printInRed("L'avio no existeix");
            return;
        }
        
        Aircraft aircraft = airport.aircraftByRegistration(registration);
        
        boolean stop = false;
        while (!stop) {
            airport.checkAirstrip();
            if (aircraft.isDestroyed()) {
                f.printInRed("L'avio esta destruit");
                return;
            }
            char letter = f.nextString("""
                    A.- Encendre Motor
                    B.- Apagar Motor
                    C.- Accelerar
                    D.- Frenar
                    E.- Agafar alcada
                    F.- Baixar alcada
                    G.- Pujar / Baixar tren aterratge
                    H.- Establir rumb
                    I.- Posicionar X i Z
                    J.- Disparar Avio comercial sospitos
                    K.- Finalitzar operativa avio seleccionat""", "Opcio: ").toUpperCase().charAt(0);
            
            switch (letter) {
                case 'A' -> aircraft.setEngine(true);
                case 'B' -> aircraft.setEngine(false);
                case 'C' -> aircraft.setSpeed(true);
                case 'D' -> aircraft.setSpeed(false);
                case 'E' -> aircraft.setAltitude(true);
                case 'F' -> aircraft.setAltitude(false);
                case 'G' -> aircraft.setLandingGear(!aircraft.isLandingGear());
                case 'H' -> aircraft.setOrientation();
                case 'I' -> aircraft.setCoordinates();
                case 'J' -> aircraft.atack(airport);
                case 'K' -> stop = true;
                default -> f.printInRed("Introdueix una lletra correcta");
            }
        }
    }
    
    public static void displayAirSpace() {
        airport.maintenance();
        airport.showInfo();
        airport.detectDangers();
    }
    
    public static void principal() {
        boolean stop = false;
        while (!stop) {
            int number = f.nextInt("\nControlador aeri\n1- Afegir un avio a l'espai aeri.\n2- Gestionar un avio de l'espai Aeri.\n3- Mostrar L'espai Aeri actual.\n4- Sortir", "Opcio: ", 1, 4);
            switch (number) {
                case 1 -> addAircraft();
                case 2 -> manageAircraft();
                case 3 -> displayAirSpace();
                case 4 -> stop = true;
            }
        }
    }
    
    public static void main(String[] args) { principal(); }
}