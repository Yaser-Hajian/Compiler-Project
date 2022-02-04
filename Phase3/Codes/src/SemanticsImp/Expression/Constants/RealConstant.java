package SemanticsImp.Expression.Constants;

import SymbolTable.DSCP.Variable.GlobalVariableDSCP;
import SymbolTable.DSCP.Variable.VariableDSCP;
import SymbolTable.GlobalSymbolTable;
import SymbolTable.Stack.SemanticStack;

public class RealConstant extends ConstantExpression {
    protected float realConst;

    public RealConstant(float realConst) {
        this.realConst = realConst;
    }

    @Override
    public void compile() {
        System.out.println(realConst);
        VariableDSCP descriptor = (VariableDSCP) GlobalSymbolTable.getSymbolTable().getDescriptor("$" + realConst);
        boolean hasDescriptor = descriptor != null;
        if (!hasDescriptor) {
            String variableName = CodeGenerator.getVariableName();
            descriptor = new GlobalVariableDSCP(variableName, Type.REAL_NUMBER);
            descriptor.setValue(String.valueOf(realConst));
            AssemblyFileWriter.appendComment("integer constant");
            AssemblyFileWriter.appendCommandToCode("li.s", "$f0", String.valueOf(realConst));
            AssemblyFileWriter.appendCommandToCode("s.s", "$f0", variableName);
            GlobalSymbolTable.getSymbolTable().addDescriptor("$" + realConst, descriptor);
            AssemblyFileWriter.appendCommandToData(variableName, "word", "0");
            AssemblyFileWriter.appendDebugLine(variableName);
        }
        SemanticStack.push(descriptor);
    }
}