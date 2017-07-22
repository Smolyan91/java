package smolyan.java;


import smolyan.java.commands.Operation;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JGrep {

    private static Path PATH_TO_FILE;
    private static Operation OPERATION;
    private static String PATTERN_TO_SEARCH;


    public static void main(String[] args) throws IOException {
        //TODO выводить сообщения
        if (args.length == 0 || args.length < 3) { System.out.println("Incorrect request'"); return;}
        OPERATION = initTypeCommand(args[0]); // detect type operation
        PATTERN_TO_SEARCH = args[1].trim();
        PATH_TO_FILE = Paths.get(args[2]).toRealPath();
    }

    private static Operation initTypeCommand(String typeCommand){
        Operation operation;
        switch (typeCommand.toLowerCase()){
            case "grep" : operation = Operation.GREP; break;
            case "del"  : operation = Operation.RM  ; break;
            case "rm"   : operation = Operation.RM  ; break;
            case "cp"   : operation = Operation.CP  ; break;
            case "mv"   : operation = Operation.MV  ; break;
            case "crd"  : operation = Operation.CRD ; break;
            case "crf"  : operation = Operation.CRF ; break;
            case "help" : operation = Operation.HELP; break;
            default: //TODO перенести в менеджер сообщений
                operation = Operation.ERROR;
                System.out.println("Inter correct command. You can write in command line <jcom help> then you can " +
                        "see information about this commands");
                break;
        }
        return operation;
    }
}
