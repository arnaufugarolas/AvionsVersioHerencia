public class Controller {
    static final int maximumAircraft = 10;
    static final Functions f = new Functions();
    static final Airport airport = new Airport(maximumAircraft);

    public static void addAircraft() {
        String registration = null;
        String destination = null;
        boolean next;

        if (airport.getNumberAircraft() >= maximumAircraft) {
            f.printInRed("L'espai aeri està complert");
            return;
        }
        if (!airport.isFreeAirstrip()) {
            f.printInRed("La pista esta ocupada");
            return;
        }

        int type = f.nextInt("\nConsola de creació d'avions\nTipus d'avions disponibles:\n\t1- Avió de combat\n\t2- Avió comercial", "Tipus: ", 1 , 2);

        next = false;
        while (!next) {
            registration = f.nextString("Introdueix la matrícula de l'avió", "Matrícula: ");
            if (airport.freeRegistration(registration)) next = true;
            else f.printInRed("Matrícula repetida");
        }

        String brand = f.nextString("Introdueix la marca de l'avió", "Marca: ");
        String model = f.nextString("Introdueix el model de l'avió", "Model: ");
        int crewMembers = f.nextInt("Introdueix el nombre de tripulants de l'avió", "Tripulants: ", 0, Integer.MAX_VALUE);
        int autonomy = f.nextInt("Introdueix l'autonomia de l'avió", "Autonomia: ", 0, Integer.MAX_VALUE);

        if (type == 1) {
            int missile = f.nextInt("Introdueix el nombre de míssils de l'avió", "Míssils: ", 0, Integer.MAX_VALUE);
            int shotDistance = f.nextInt("Introdueix la distància màxima de llançament de l'avió", "Distància: ", 0, Integer.MAX_VALUE);

            try { airport.addAircraft(new Combat(registration, brand, model, crewMembers, autonomy, missile, shotDistance)); }
            catch (Exception e) { f.printInRed(e.toString()); }
        }
        else {
            int capacity = f.nextInt("Introdueix la capacitat màxima de l'avió", "Capacitat: ", 0, Integer.MAX_VALUE);
            String origin = f.nextString("Introdueix l'origen de l'avió", "Origen: ");

            next = false;
            while (!next) {
                destination = f.nextString("Introdueix el destí de l'avió", "Destí: ");
                if (!origin.equals(destination)) next = true;
                else f.printInRed("El destí de l'avió no pot ser l'origen");
            }

            try { airport.addAircraft(new Commercial(registration, brand, model, crewMembers, autonomy, capacity, origin, destination)); }
            catch (Exception e) { f.printInRed(e.toString()); }
        }
    }

    public static void manageAircraft() {
        String registration = f.nextString("Introdueix la matrícula de l'avió a gestionar", "Matrícula: ");

        if (airport.freeRegistration(registration)) {
            f.printInRed("L'avio no existeix");
            return;
        }

        Aircraft aircraft = airport.aircraftByRegistration(registration);

        boolean stop = false;
        while (!stop) {
            char letter = f.nextString("""
                    a.- Encendre Motor.
                    b.- Apagar Motor.
                    c.- Accelerar.
                    d.- Frenar.
                    e.- Agafar alçada.
                    f.- Baixar alçada.
                    g.- Pujar /Baixar tren aterratge.
                    h.- Establir rumb
                    i.- Posicionar X,Z
                    j.- Disparar Avió comercial sospitós
                    K.- Finalitzar operativa avio seleccionat""", "Opció: ").toLowerCase().charAt(0);

            switch (letter) {
                case 'a' -> aircraft.setEngine(true);
                case 'b' -> aircraft.setEngine(false);
                case 'c' -> aircraft.setSpeed(-1, true);
                case 'd' -> aircraft.setSpeed(-1, false);
                case 'e' -> aircraft.setAltitude(true);
                case 'f' -> aircraft.setAltitude(false);
                case 'g' -> aircraft.setLandingGear(!aircraft.isLandingGear());
                case 'h' -> aircraft.setOrientation(-1);
                case 'i', 'j' -> f.notImplemented();
                case 'k' -> stop = true;
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
        airport.addAircraft(new Combat("registration", "brand", "model", 0, 0, 10, 0));

        while (!stop) {
            int number = f.nextInt("\nControlador aeri\n1- Afegir un avió a l’espai aeri.\n2- Gestionar un avió de l’espai Aeri.\n3- Mostrar L’espai Aeri actual.\n4- Sortir", "Opció: ", 1, 4);
            switch (number) {
                case 1 -> addAircraft();
                case 2 -> manageAircraft();
                case 3 -> displayAirSpace();
                case 4 -> stop = true;
            }
        }
    }

    public static void main(String[] args) {
        principal();
    }
}