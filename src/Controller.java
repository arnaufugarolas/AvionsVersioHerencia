public class Controller {
    static final int maximumAircraft = 10;
    static final Controller c = new Controller();
    static final Functions f = new Functions();
    static final Airport airport = new Airport(maximumAircraft);

    public void addAircraft() {
        String registration = null;
        String destination = null;
        int type = 0;
        int crewMembers = 0;
        int autonomy = 0;
        boolean next;

        if (airport.getNumberAircraft() >= maximumAircraft) {
            f.printInRed("L'espai aeri està complert");
            return;
        }
        if (!airport.isFreeAirstrip()) {
            f.printInRed("La pista esta ocupada");
            return;
        }

        next = false;
        while (!next) {
            type = f.nextInt("\nConsola de creació d'avions\nTipus d'avions disponibles:\n\t1- Avió de combat\n\t2- Avió comercial", "Tipus: ");
            if (type == 1 || type == 2) next = true;
            else f.printInRed("Tipus d'avió invàlid");
        }

        next = false;
        while (!next) {
            registration = f.nextString("Introdueix la matrícula de l'avió", "Matrícula: ");
            if (airport.freeRegistration(registration)) next = true;
            else f.printInRed("Matrícula repetida");
        }

        String brand = f.nextString("Introdueix la marca de l'avió", "Marca: ");
        String model = f.nextString("Introdueix el model de l'avió", "Model: ");

        next = false;
        while (!next) {
            crewMembers = f.nextInt("Introdueix el nombre de tripulants de l'avió", "Tripulants: ");
            if (crewMembers > 0) next = true;
            else f.printInRed("Nombre de tripulants invàlid");
        }

        next = false;
        while (!next) {
            autonomy = f.nextInt("Introdueix l'autonomia de l'avió", "Autonomia: ");
            if (autonomy > 0) next = true;
            else f.printInRed("Autonomia invàlida");
        }

        if (type == 1) {
            int missile = 0;
            int shotDistance = 0;

            next = false;
            while (!next) {
                missile = f.nextInt("Introdueix el nombre de míssils de l'avió", "Míssils: ");
                if (missile > 0) next = true;
                else f.printInRed("Nombre de míssils invàlid");
            }

            next = false;
            while (!next) {
                shotDistance = f.nextInt("Introdueix la distància màxima de llançament de l'avió", "Distància: ");
                if (shotDistance > 0) next = true;
                else f.printInRed("Distància invàlida");
            }

            try {
                airport.addAircraft(new Combat(registration, brand, model, crewMembers, autonomy, missile, shotDistance));
            }
            catch (Exception e) {
                f.printInRed(e.toString());
            }
        }
        else {
            int capacity = 0;

            next = false;
            while (!next) {
                capacity = f.nextInt("Introdueix la capacitat màxima de l'avió", "Capacitat: ");
                if (capacity > 0) next = true;
                else f.printInRed("Capacitat invàlida");
            }

            String origin = f.nextString("Introdueix l'origen de l'avió", "Origen: ");

            next = false;
            while (!next) {
                destination = f.nextString("Introdueix el destí de l'avió", "Destí: ");
                if (!origin.equals(destination)) next = true;
                else f.printInRed("El destí de l'avió no pot ser l'origen");
            }

            try {
                airport.addAircraft(new Commercial(registration, brand, model, crewMembers, autonomy, capacity, origin, destination));
            }
            catch (Exception e) {
                f.printInRed(e.toString());
            }
        }
    }

    public void manageAircraft() {
        String registration = f.nextString("Introdueix la matrícula del avió a gestionar", "Matrícula: ");

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
                    K.- Finalitzar operativa avio seleccionat""", "Opció: ").charAt(0);

            switch (letter) {
                case 'a' -> aircraft.setEngine(true);
                case 'b' -> aircraft.setEngine(false);
                case 'c' -> aircraft.setSpeed(-1, true);
                case 'd' -> aircraft.setSpeed(-1, false);
                case 'e' -> f.notImplemented();
                case 'f' -> f.notImplemented();
                case 'g' -> aircraft.setLandingGear(!aircraft.isLandingGear());
                case 'h' -> f.notImplemented();
                case 'i' -> f.notImplemented();
                case 'j' -> f.notImplemented();
                case 'k' -> stop = true;
                default -> f.printInRed("Introdueix una lletra correcta");
            }
        }
    }

    public void displayAirSpace() {
        airport.maintenance();
        airport.showInfo();
        airport.detectDangers();
    }

    public void principal() {
        boolean stop = false;
        airport.addAircraft(new Combat("registration", "brand", "model", 0, 0, 10, 0));

        while (!stop) {
            int number = f.nextInt("\nControlador aeri\n1- Afegir un avió a l’espai aeri.\n2- Gestionar un avió de l’espai Aeri.\n3- Mostrar L’espai Aeri actual.\n4- Sortir", "Opció: ");
            switch (number) {
                case 1 -> c.addAircraft();
                case 2 -> c.manageAircraft();
                case 3 -> c.displayAirSpace();
                default -> stop = true;
            }
        }
    }

    public static void main(String[] args) {
        c.principal();
    }
}