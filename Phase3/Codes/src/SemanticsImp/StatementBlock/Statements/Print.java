package SemanticsImp.StatementBlock.Statements;

import SemanticsImp.StatementBlock.Statement;
import SymbolTable.DSCP.Descriptor;
import Utils.AssemblyFileWriter;

public class Print extends Statement {

    private Descriptor value;

    public Print(Descriptor value) {
        this.value = value;
    }

    @Override
    public void compile() {
        boolean isInteger = value.getType().equals("INTEGER_NUMBER") ;
        boolean isFloat = value.getType().equals("REAL_NUMBER") ;
        String outputType = isInteger ? "1" : isFloat ? "2" : "4";
        String comment = isInteger ? "integer" : isFloat ? "float" : "string";
        AssemblyFileWriter.appendComment("print" + " " + comment + " (" + value.getName() + ")");
        AssemblyFileWriter.appendCommandToCode("li", "$v0", outputType);
        AssemblyFileWriter.appendCommandToCode("la", "$t0", value.getName());
        if (isFloat) {
            AssemblyFileWriter.appendCommandToCode("l.s", "$f0", "0($t0)");
            AssemblyFileWriter.appendCommandToCode("mov.s", "$f12", "$f0");
        } else {
            AssemblyFileWriter.appendCommandToCode("lw", "$t0", "0($t0)");
            AssemblyFileWriter.appendCommandToCode("move", "$a0", "$t0");
        }
        AssemblyFileWriter.appendCommandToCode("syscall");
        if (isFloat || isInteger) {
            AssemblyFileWriter.appendComment("new line");
            AssemblyFileWriter.appendCommandToCode("li", "$v0", "4");
            AssemblyFileWriter.appendCommandToCode("la", "$a0", "nl");
            AssemblyFileWriter.appendCommandToCode("syscall");
        }
    }
}