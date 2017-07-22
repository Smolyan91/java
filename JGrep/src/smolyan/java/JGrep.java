package smolyan.java;


import java.nio.file.Path;
import java.nio.file.Paths;

public class JGrep {

    public static final String PARAM_GREP = "grep";
    private static Path PATH_TO_FILE;


    public static void main(String[] args) {
        //TODO выводить сообщения
        if (args.length == 0) return;
        if (args.length < 3) { System.out.println("Input file path for grep_operation"); return;}
        if (!PARAM_GREP.equalsIgnoreCase(args[0])) {
            System.out.println("Incorrect command. Maybe you wanted write <grep <pattern> <pathToFile>>");
            return;
        }
        PATH_TO_FILE = Paths.get(args[2]);
    }
}
