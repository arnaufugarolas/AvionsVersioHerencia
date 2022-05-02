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
        if (!airport.isFreeAirstrip()) {
            f.printInRed("La pista esta ocupada");
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
            //TODO: Implementar
            // Verificar que el motor estigui encès o no en les funcions que depenguin d’ell.. Accelerar, frenar, pujar, baixar,etc..
            // Podríem imaginar que per tal de poder enlairar-se necessitem una velocitat mínima de 180 km/h.
            // No podem passar de 500 metres d’alçada sense amagar el tren d’aterratge.
            // No podem descendir més metres dels que tenim d’alçada actualment.
            // No podem treure el tren d’aterratge si tenim més alçada de 500 metres i anem a més de 300 km/h.
            // No podem aterrar amb velocitats superiors a 200 km/h i fora de la pista. En cas de que s’incompleixi,
            //      L’avió s’estimbarà i automàticament el controlador mostrarà la informació avisant de que l’avio XXX s’ha estimbat i queda fora de l’espai.

        String registration = f.nextString("Introdueix la matricula de l'avio a gestionar", "Matricula: ");

        if (airport.freeRegistration(registration)) {
            f.printInRed("L'avio no existeix");
            return;
        }

        Aircraft aircraft = airport.aircraftByRegistration(registration);

        boolean stop = false;
        while (!stop) {
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
                case 'J' -> aircraft.atackCommercial(airport);
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
        airport.addAircraft(new Combat("A", "brand", "model", 0, 0, 10, 0));
        airport.addAircraft(new Combat("B", "brand", "model", 0, 0, 10, 0));
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

    // Calling the principal method.
    public static void main(String[] args) { principal(); }
}