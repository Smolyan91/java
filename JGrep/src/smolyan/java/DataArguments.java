package smolyan.java;


import smolyan.java.commands.Operation;

public class DataArguments {
    private Operation commandDA;
    private int countArgs;
    private String[] massArgs;

    public DataArguments(Operation commandDA, int countArgs, String[] massArgs) {
        this.commandDA = commandDA;
        this.countArgs = countArgs;
        this.massArgs = massArgs;
    }

    public Operation getCommandDA() {
        return commandDA;
    }

    public int getNumberArgs() {
        return countArgs;
    }

    public String[] getMassArgs() {
        return massArgs;
    }
}
