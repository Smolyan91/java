package smolyan.java;


import smolyan.java.commands.Operation;
import smolyan.java.operation.OperationImpl;

import java.io.IOException;
import java.util.Arrays;

public class JGrep {

    public static void main(String[] args) throws IOException {
        //TODO выводить сообщения
        if (args.length == 0) { System.out.println("Incorrect request'"); return;}
        new OperationImpl(initTypeCommand(args)).start();
    }

    /***
     * grep:  pattern pathToFile
     * srch(search):  pattern pathToFile
     * rm/del(remove=del):  pathToFile
     * mv(move):  fromFile toFile
     * cp(copy):  originalFile targetFile
     * crd/crf(create directory (-s)/ create file(-s)): ...newFiles
     * rename: newName pathToFile
     * @param arrayArgs
     * @return DataArguments
     */
    private static DataArguments initTypeCommand(String[] arrayArgs){
        Operation operation;
        DataArguments da;
        String typeCommand = arrayArgs[0];
        int countArgs = arrayArgs.length;
        String[] arr = Arrays.copyOfRange(arrayArgs, 1, countArgs);
        switch (typeCommand.toLowerCase()){
            case "grep" : {
                if (countArgs == 3){
                    operation = Operation.GREP;
                }else operation = Operation.ERROR;
            } break;

            case "info": {
                if (countArgs == 2){
                    System.out.println("INFO");
                    operation = Operation.INFO;
                }else operation = Operation.ERROR;
            } break;
            case "rename": operation = Operation.RENAME; break;

            case "del"  : {
                if(countArgs == 2){
                    operation = Operation.RM;
                }else operation = Operation.ERROR;
            } break;

            case "rm"   : {
                if(countArgs == 2){
                    operation = Operation.RM  ;
                }else operation = Operation.ERROR;
            } break;

            case "cp"   : {
                if(countArgs == 3){
                    operation = Operation.CP  ;
                }else operation = Operation.ERROR;
            } break;

            case "setprops":{
                if (countArgs == 3){
                    operation = Operation.SET_PROPS;
                }else operation = Operation.ERROR;
            } break;

            case "mv"   : {
                if(countArgs == 3){
                    operation = Operation.MV  ;
                }else operation = Operation.ERROR;
            } break;

            case "crd"  : {
                //Program can create a maximum of 5 folders
                if(countArgs <= 5){
                    operation = Operation.CRD ;
                }else operation = Operation.ERROR;
            } break;

            case "crf"  : {
                //Program can create a maximum of 10 files
                if(countArgs <= 10){
                    operation = Operation.CRF;
                }else operation = Operation.ERROR;
            } break;

            case "srch" : {
                if(countArgs == 3){
                    operation = Operation.SRCH;
                }else operation = Operation.ERROR;
            }break;

            case "help" : {
                if (countArgs == 2){
                    operation = Operation.HELP;
                } else operation = Operation.ERROR;
            } break;

            default: //TODO перенести в менеджер сообщений
                operation = Operation.ERROR;
                System.out.println("Inter correct command. You can write in command line <jcom help> then you can " +
                        "see information about this commands");
                break;
        }
        da = new DataArguments(operation, countArgs, arr);
        return da;
    }
}
