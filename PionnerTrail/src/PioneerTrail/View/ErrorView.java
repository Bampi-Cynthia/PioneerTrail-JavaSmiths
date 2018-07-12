package PioneerTrail.View;

import java.io.PrintWriter;
import pionnertrail.PioneerTrail;

/*
 * @author Elías
 */
public class ErrorView {

    private static PrintWriter console = PioneerTrail.getOutFile();
    private static PrintWriter log = PioneerTrail.getLogFile();

    public static void display(String className, String errorMessage) {
        console.println(
                "\n----------ERROR-----------------------------"
                + "\n" + errorMessage
                + "\n--------------------------------------------");
        log.printf("%n%n%s", className + " - " + errorMessage);
    }
}
