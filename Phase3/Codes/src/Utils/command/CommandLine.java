package Utils.command;

import java.util.ArrayList;

public class CommandLine {
    private String command;

    private ArrayList<String> operands;

    public CommandLine(String command, ArrayList<String> operands) {
        this.command = command;
        this.operands = operands;
    }

    public String getCommand() {
        return command;
    }

    public ArrayList<String> getOperands() {
        return operands;
    }

    @Override
    public String toString() {
        return "CommandLine is" +
                "command = " + command +
                ", operands = " + operands.toString() +
                '}';
    }
}