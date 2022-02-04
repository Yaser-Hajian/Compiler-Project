package SemanticsImp.Expression.Constants;

import CodeGen.CodeGeneratorImp;
import SymbolTable.DSCP.Variable.GlobalVariableDSCP;
import SymbolTable.DSCP.Variable.VariableDSCP;
import SymbolTable.GlobalSymbolTable;
import SymbolTable.Stack.SemanticStack;
import Utils.AssemblyFileWriter;

public class IntegerConstant extends ConstantExpression{
    protected int intConst;

    public IntegerConstant(int intConst) {
        this.intConst = intConst;
    }

    @Override
    public void compile() {
        System.out.println(intConst);
        VariableDSCP descriptor = (VariableDSCP) GlobalSymbolTable.getSymbolTable().getDescriptor("$" + intConst);
        boolean hasDescriptor = descriptor != null;
        if (!hasDescriptor) {
            String variableName = CodeGeneratorImp.getVariableName();
            descriptor = new GlobalVariableDSCP(variableName, "INTEGER_NUMBER");
            descriptor.setValue(String.valueOf(intConst));
            AssemblyFileWriter.appendComment("integer constant");
            AssemblyFileWriter.appendCommandToCode("li", "$t0", String.valueOf(intConst));
            AssemblyFileWriter.appendCommandToCode("sw", "$t0", variableName);
            GlobalSymbolTable.getSymbolTable().addDescriptor("$" + intConst, descriptor);
            AssemblyFileWriter.appendCommandToData(variableName, "word", "0");
            AssemblyFileWriter.appendDebugLine(variableName);
        }
        SemanticStack.push(descriptor);
    }
}