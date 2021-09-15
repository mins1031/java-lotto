import java.util.Scanner;

public class InputScanner {

    private static Scanner scan = new Scanner(System.in);

    public static int scanInteger(){

        int input = scan.nextInt();

        return input;
    }

    public String scanString(){
        return scan.nextLine();
    }



}
