package SemanticsImp.StatementBlock.Statements;

import CodeGen.CodeGeneratorImp;
import SemanticsImp.StatementBlock.Statement;
import SymbolTable.DSCP.Descriptor;
import Utils.AssemblyFileWriter;

public class For extends Statement {
    private Descriptor conditionValue;
    private static String startOfConditionLabel;
    private static String endOfForLabel;
    private static String startOfStepLabel;

    public For(Descriptor conditionValue) {
        this.conditionValue = conditionValue;
    }

    @Override
    public void compile() {
        AssemblyFileWriter.appendComment("FOR code for " + conditionValue);
        AssemblyFileWriter.appendCommandToCode("la", "$t0", conditionValue.getName());
        AssemblyFileWriter.appendCommandToCode("lw", "$t1", "0($t0)");
        endOfForLabel = CodeGeneratorImp.generateNewLabel();
        AssemblyFileWriter.appendCommandToCode("beqz", "$t1", endOfForLabel);
    }

    public static void startCondition() {
        startOfConditionLabel = CodeGeneratorImp.generateNewLabel();
        AssemblyFileWriter.appendComment("start condition of for");
        AssemblyFileWriter.addLabel(startOfConditionLabel);
    }

    public static void completeFor() {
        startOfStepLabel = CodeGeneratorImp.generateNewLabel();
        AssemblyFileWriter.appendComment("end of FOR");
        AssemblyFileWriter.appendCommandToCode("j", startOfStepLabel);
    }

    public static void stepStatement() {
        AssemblyFileWriter.appendComment("step of FOR");
        AssemblyFileWriter.addLabel(startOfStepLabel);
    }

    public static void completeStepOfFor() {
        AssemblyFileWriter.appendComment("complete step of FOR");
        AssemblyFileWriter.appendCommandToCode("j", startOfConditionLabel);
        AssemblyFileWriter.addLabel(endOfForLabel);
    }
}