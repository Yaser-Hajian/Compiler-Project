package SemanticsImp.StatementBlock.Statements;

import CodeGen.CodeGeneratorImp;
import SemanticsImp.StatementBlock.Statement;
import SymbolTable.DSCP.Descriptor;
import Utils.AssemblyFileWriter;

public class While extends Statement {
    private Descriptor conditionValue;
    private static String startOfConditionLabel;
    private static String endOfWhileLabel;

    public While(Descriptor conditionValue) {
        this.conditionValue = conditionValue;
    }

    @Override
    public void compile() {
        AssemblyFileWriter.appendComment("while code for " + conditionValue);
        AssemblyFileWriter.appendCommandToCode("la", "$t0", conditionValue.getName());
        AssemblyFileWriter.appendCommandToCode("lw", "$t1", "0($t0)");
        endOfWhileLabel = CodeGeneratorImp.generateNewLabel();
        AssemblyFileWriter.appendCommandToCode("beqz", "$t1", endOfWhileLabel);
    }

    public static void startCondition() {
        startOfConditionLabel = CodeGeneratorImp.generateNewLabel();
        AssemblyFileWriter.appendComment("start condition of while");
        AssemblyFileWriter.addLabel(startOfConditionLabel);
    }

    public static void completeWhile() {
        AssemblyFileWriter.appendComment("end of while");
        AssemblyFileWriter.appendCommandToCode("j", startOfConditionLabel);
        AssemblyFileWriter.addLabel(endOfWhileLabel);
    }

}