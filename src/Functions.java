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

    public int nextInt(String msg, String question) {
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
                f.printInRed("Introdueix un número");
                System.out.print(question);
            }
        }

        return intInput;
    }

    public String nextString(String msg, String question) {
        System.out.printf("%s\n%s", msg, question);
        return input.next();
    }

}
