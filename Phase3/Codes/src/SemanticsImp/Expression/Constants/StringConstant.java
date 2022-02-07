package SemanticsImp.Expression.Constants;

import CodeGen.CodeGeneratorImp;
import CodeGen.Type;
import SymbolTable.DSCP.Variable.LocalVariableDSCP;
import SymbolTable.DSCP.Variable.VariableDSCP;
import SymbolTable.GlobalSymbolTable;
import SymbolTable.Stack.SemanticStack;
import Utils.AssemblyFileWriter;

public class StringConstant extends ConstantExpression {
    protected String stringConst;

    public StringConstant(String stringConst) {
        this.stringConst = stringConst;
    }

    @Override
    public void compile() {
        System.out.println(stringConst);
        VariableDSCP descriptor = (VariableDSCP) GlobalSymbolTable.getSymbolTable().getDescriptor("$$" + stringConst);
        boolean hasDescriptor = descriptor != null;
        if (!hasDescriptor) {
            String variableName = CodeGeneratorImp.getVariableName();
            descriptor = new LocalVariableDSCP(variableName, Type.STRING);
            descriptor.setValue(stringConst);
            SemanticStack.push(descriptor);
            AssemblyFileWriter.appendComment("string constant");
            GlobalSymbolTable.getSymbolTable().addDescriptor("$$" + stringConst, descriptor);
            AssemblyFileWriter.appendCommandToData(variableName, "asciiz", "\"" + stringConst + "\"");
            AssemblyFileWriter.appendDebugLine(variableName);
        }
    }
}