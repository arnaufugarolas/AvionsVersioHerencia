import java.util.Scanner;

public class Controller {
    static final int maximumAircraft = 10;
    static final Controller c = new Controller();
    static final Scanner input = new Scanner(System.in);
    static final Airport airport = new Airport(maximumAircraft);

    public int NextInt(String msg, String question) {
        int intInput = 0;
        boolean correct = false;
        System.out.printf("%s\n%s", msg, question);

        while (!correct) {
            if (input.hasNextInt()){
                intInput = input.nextInt();
                correct = true;
            }
            else {
                input.nextLine();
                System.out.printf("%s\n%s", "Introdueix un número", question);
            }
        }

        return intInput;
    }

    public String NextString(String msg, String question) {
        System.out.printf("%s\n%s", msg, question);
        return input.next();
    }

    public void AddAircraft() {
        String registration = null;
        String destination = null;
        int type = 0;
        int crewMembers = 0;
        int autonomy = 0;
        boolean next;

        if (airport.getNumberAircraft() >= maximumAircraft) {
            System.err.println("L'espai aeri està complert");
            return;
        }
        if (!airport.isFreeAirstrip()) {
            System.err.println("La pista esta ocupada");
            return;
        }

        next = false;
        while (!next) {
            type = c.NextInt("\nConsola de creació d'avions\nTipus d'avions disponibles:\n\t1- Avió de combat\n\t2- Avió comercial", "Tipus: ");
            if (type == 1 || type == 2) next = true;
            else System.err.println("Tipus d'avió invàlid");
        }

        next = false;
        while (!next) {
            registration = c.NextString("Introdueix la matrícula de l'avió", "Matrícula: ");
            if (airport.FreeRegistration(registration)) next = true;
            else System.err.println("Matrícula repetida");
        }

        String brand = c.NextString("Introdueix la marca de l'avió", "Marca: ");
        String model = c.NextString("Introdueix el model de l'avió", "Model: ");

        next = false;
        while (!next) {
            crewMembers = c.NextInt("Introdueix el nombre de tripulants de l'avió", "Tripulants: ");
            if (crewMembers > 0) next = true;
            else System.err.println("Nombre de tripulants invàlid");
        }

        next = false;
        while (!next) {
            autonomy = c.NextInt("Introdueix l'autonomia de l'avió", "Autonomia: ");
            if (autonomy > 0) next = true;
            else System.err.println("Autonomia invàlida");
        }

        if (type == 1) {
            int missile = 0;
            int shotDistance = 0;

            next = false;
            while (!next) {
                missile = c.NextInt("Introdueix el nombre de míssils de l'avió", "Míssils: ");
                if (missile > 0) next = true;
                else System.err.println("Nombre de míssils invàlid");
            }

            next = false;
            while (!next) {
                shotDistance = c.NextInt("Introdueix la distància màxima de llançament de l'avió", "Distància: ");
                if (shotDistance > 0) next = true;
                else System.err.println("Distància invàlida");
            }

            try {
                airport.addAircraft(new Combat(registration, brand, model, crewMembers, autonomy, missile, shotDistance));
            }
            catch (Exception e) {
                System.err.println(e);
            }
        }
        else {
            int capacity = 0;

            next = false;
            while (!next) {
                capacity = c.NextInt("Introdueix la capacitat màxima de l'avió", "Capacitat: ");
                if (capacity > 0) next = true;
                else System.err.println("Capacitat invàlida");
            }

            String origin = c.NextString("Introdueix l'origen de l'avió", "Origen: ");

            next = false;
            while (!next) {
                destination = c.NextString("Introdueix el destí de l'avió", "Destí: ");
                if (!origin.equals(destination)) next = true;
                else System.err.println("El destí de l'avió no pot ser l'origen");
            }

            try {
                airport.addAircraft(new Commercial(registration, brand, model, crewMembers, autonomy, capacity, origin, destination));
            }
            catch (Exception e) {
                System.err.println(e);
            }
        }
    }

    /*
    a.- Encendre Motor.
    b.- Apagar Motor.
    c.- Accelerar.
    d.- Frenar.
    e.- Agafar alçada.
    f.- Baixar alçada.
    g.- Pujar /Baixar tren aterratge.
    h.- Establir rumb
    i.- Posicionar X,Y
    j.- Disparar Avió comercial sospitós
    K.- Finalitzar operativa avio seleccionat
     */

    public void ManageAircraft() {

    }

    public void DisplayAirSpace() {
        airport.Maintenance();
        System.out.println("Situació de les aeronaus:\n");
        airport.ShowInfo();
        airport.DetectDangers();
    }

    public void Main() {
        boolean stop = false;
        while (!stop) {
            int number = c.NextInt("Controlador aeri\n1- Afegir un avió a l’espai aeri.\n2- Gestionar un avió de l’espai Aeri.\n3- Mostrar L’espai Aeri actual.\n4- Sortir", "Opció: ");
            switch (number) {
                case 1 -> c.AddAircraft();
                case 2 -> c.ManageAircraft();
                case 3 -> c.DisplayAirSpace();
                default -> stop = true;
            }
        }
    }

    public static void main(String[] args) {
        c.Main();
    }
}