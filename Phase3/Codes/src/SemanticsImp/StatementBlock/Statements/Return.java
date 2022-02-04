package SemanticsImp.StatementBlock.Statements;

import SemanticsImp.Expression.BinaryExpression.BinaryExpression;
import SemanticsImp.StatementBlock.Statement;
import SymbolTable.DSCP.Descriptor;
import Utils.AssemblyFileWriter;

public class Return extends Statement {

    private Descriptor value;

    public Return(Descriptor value) {
        this.value = value;
    }

    @Override
    public void compile() {
        AssemblyFileWriter.addLabel(BinaryExpression.afterCompareLabel);
        AssemblyFileWriter.appendCommandToCode("li", "$t0", "1");
        AssemblyFileWriter.appendCommandToCode("sw", "$t0", BinaryExpression.variableNameOfContinue);
        AssemblyFileWriter.appendCommandToCode("b", BinaryExpression.continueLabel);
        AssemblyFileWriter.appendComment("return " + value.getName());
        AssemblyFileWriter.appendCommandToCode("li", "$v0", "10");
        AssemblyFileWriter.appendCommandToCode("la", "$t0", value.getName());
        AssemblyFileWriter.appendCommandToCode("lw", "$t0", "0($t0)");
        AssemblyFileWriter.appendCommandToCode("move", "$a0", "$t0");
        AssemblyFileWriter.appendCommandToCode("syscall");
    }
}