import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to DFSM");
        System.out.println("Enter file name to read inputs: ");

        //Scanner for taking user input
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();
        DFSM dfsm = new DFSM(filePath);

        System.out.println("Program will be looping infinitely, you can write 'exit' whenever to close.");

        while (true) {
            System.out.println("Enter string to check is it accepted by machine: ");
            String string = scanner.nextLine();

            if (string.toLowerCase().equals("exit")) {//Exit or EXIT or exit all of them will break the loop
                break;
            }

            boolean status = dfsm.checkString(string);
            System.out.println("Result: " + status);
        }

        System.out.println("Bye");
        System.exit(1);
    }
}