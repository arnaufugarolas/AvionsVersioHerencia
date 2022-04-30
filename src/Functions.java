import java.util.Scanner;

public class Functions {
    static final Scanner input = new Scanner(System.in);
    static final Functions f = new Functions();

    public void printInRed(String msg) {
        System.out.print((char)27 + "[31m" + msg + (char)27 + "[0m\n");
    }

    public void notImplemented() {
        f.printInRed("Not implemented yet");
    }

    public int nextInt(String msg, String question, int min, int max) {
        System.out.printf("%s\n%s", msg, question);
        return checkInt(question, min, max);
    }

    public int nextInt(String msg, String question) {
        System.out.printf("%s\n%s", msg, question);
        return checkInt(question);
    }

    public int nextInt(String msg, int min, int max) {
        System.out.print(msg);
        return checkInt(msg, min, max);
    }

    public int nextInt(String msg) {
        System.out.print(msg);
        return checkInt(msg);
    }

    private int checkInt(String msg, int min, int max) {
        int intInput = 0; boolean correct = false;
        while (!correct) {
            if (input.hasNextInt()){
                intInput = input.nextInt();
                if (intInput >= min && intInput <= max) correct = true;
                else System.out.printf("%s\n%s", msg, "Introdueix un número entre " + min + " i " + max);
            }
            else {
                input.nextLine();
                f.printInRed("Introdueix un número");
                System.out.print(msg);
            }
        }
        return intInput;
    }

    private int checkInt(String msg) {
        int intInput = 0; boolean correct = false;
        while (!correct) {
            if (input.hasNextInt()){
                intInput = input.nextInt();
                correct = true;
            }
            else {
                input.nextLine();
                f.printInRed("Introdueix un número");
                System.out.print(msg);
            }
        }
        return intInput;
    }
    public String nextString(String msg, String question) {
        System.out.printf("%s\n%s", msg, question);
        return input.next();
    }

}
