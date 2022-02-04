package Utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AssemblyFileWriter {

    private String filePath;
    private static BufferedWriter writer;

    private static String OUTPUT_ASSEMBLY_FILE_NAME = "mips_code.s";
    private static String TAB = "\t\t";
    private static String SPACE = " ";
    private static String NEW_LINE = "\n";


    private static String code = "";
    private static String data = "";

    public AssemblyFileWriter(String filePath) {
        this.filePath = filePath;
        createCompiledFile();
    }

    public static void appendCommandToCode(String command, String... operands) {
        CommandLine commandLine = new CommandLine(command, new ArrayList<>(Arrays.asList(operands)));
        code += (TAB + commandLine.getCommand());
        if (commandLine.getOperands() != null) {
            String res = String.join(", ", commandLine.getOperands());
            code += (SPACE + res + NEW_LINE);
        }
    }

    public static void appendComment(String comment) {
        appendCommandToCode("# " + comment);
    }

    public static void appendDebugLine(String addressName) {
        appendComment("t7 is just for debugging");
        appendCommandToCode("lw", "$t7", addressName);
    }

    public static void appendCommandToData(String name, String directive, String value) {
        DataLine dataLine = new DataLine(name, directive, value);
        data += (TAB + dataLine + NEW_LINE);
    }

    public static void addLabel(String name) {
        Label lbl = new Label(name);
        code += lbl.toString() + NEW_LINE;
    }

    public static void deleteLabel(String label) {
        code = code.replaceFirst(label + ":", "");
    }

    private void createCompiledFile() {
        try {
            writer = new BufferedWriter(new FileWriter(filePath + OUTPUT_ASSEMBLY_FILE_NAME));
            code += ".text" + NEW_LINE;
            //TODO check if input file has main
            code += ".globl main" + NEW_LINE;
            code += "main:" + NEW_LINE;
            data += ".data" + NEW_LINE;
            appendCommandToData("nl", "asciiz", "\"\\n\"");
            appendCommandToData("strbuffer", "space", "20");
            appendCommandToData("stradr", "word", "0");
        } catch (IOException e) {
            System.err.println("Can not create output file");
            e.printStackTrace();
        }
    }

    public void writeOutputFile() {
        try {
            writer.write(code);
            writer.write(data);
            writer.flush();
        } catch (IOException e) {
            System.err.println("Can not write to output file");
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            System.err.println("Can not close output file");
            e.printStackTrace();
        }
    }
}