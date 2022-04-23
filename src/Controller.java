/*
- Afegir un avió a l’espai aeri.
- Gestionar un avió de l’espai Aeri.
- Mostrar L’espai Aeri actual.

 */

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    static Controller c = new Controller();
    static Scanner input = new Scanner(System.in);

    ArrayList<Aircraft> Airport = new ArrayList<Aircraft>();

    public static void main(String[] args) {
        c.Main();
    }

    public int NextInt(String msg) {
        System.out.print(msg);
        return input.nextInt();
    }

    public String NextString(String msg) {
        System.out.print(msg);
        return input.next();
    }
    public void Main() {
        boolean stop = false;
        while (!stop) {
            System.out.println("Controlador aeri\n1- Afegir un avió a l’espai aeri.\n2- Gestionar un avió de l’espai Aeri.\n3- Mostrar L’espai Aeri actual.\n4- Sortir");
        }

    }

}