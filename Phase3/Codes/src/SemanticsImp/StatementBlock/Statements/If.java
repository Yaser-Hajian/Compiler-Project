package SemanticsImp.StatementBlock.Statements;

import CodeGen.CodeGeneratorImp;
import SemanticsImp.StatementBlock.Statement;
import SymbolTable.DSCP.Descriptor;
import Utils.AssemblyFileWriter;

public class If extends Statement {
    private Descriptor value;
    private static String afterIfLabel;
    private static String afterElseLabel;

    public If(Descriptor value) {
        this.value = value;
    }

    @Override
    public void compile() {
        afterIfLabel = CodeGeneratorImp.generateNewLabel();
        afterElseLabel = CodeGeneratorImp.generateNewLabel();
        AssemblyFileWriter.appendComment("if code for " + value);
        AssemblyFileWriter.appendCommandToCode("la", "$t0", value.getName());
        AssemblyFileWriter.appendCommandToCode("lw", "$t1", "0($t0)");
        AssemblyFileWriter.appendCommandToCode("beqz", "$t1", afterIfLabel);
    }

    public static void completeIf() {
        AssemblyFileWriter.appendComment("complete if code");
        AssemblyFileWriter.appendCommandToCode("j", afterElseLabel);
        AssemblyFileWriter.addLabel(afterIfLabel);
        AssemblyFileWriter.addLabel(afterElseLabel);
    }

    public static void elseCode() {
        AssemblyFileWriter.appendComment("else code");
        AssemblyFileWriter.deleteLabel(afterIfLabel);
        AssemblyFileWriter.addLabel(afterElseLabel);
    }

    public static void completeElse() {
        AssemblyFileWriter.appendComment("complete else code");
        AssemblyFileWriter.deleteLabel(afterElseLabel);
        AssemblyFileWriter.addLabel(afterIfLabel);
    }
}