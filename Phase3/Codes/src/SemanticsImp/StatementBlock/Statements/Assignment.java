package SemanticsImp.StatementBlock.Statements;

import SemanticsImp.StatementBlock.Statement;
import SymbolTable.DSCP.Descriptor;
import SymbolTable.DSCP.Variable.VariableDSCP;
import SymbolTable.Stack.SemanticStack;
import Utils.AssemblyFileWriter;
import Utils.Type.TypeChecker;

public class Assignment extends Statement {
    private Descriptor leftSide;
    private Descriptor rightSide;

    public Assignment() {}

    @Override
    public void compile() {
        System.out.println("code gen of assignment");
        rightSide = (Descriptor) SemanticStack.pop();
        Descriptor des = (Descriptor) SemanticStack.pop();
        System.out.println(rightSide.getType());
        // System.out.println(des.getType());
        if (TypeChecker.isArrayType(des.getType())) {
            int index = Integer.parseInt(((VariableDSCP) rightSide).getValue());
            AssemblyFileWriter.appendCommandToCode("li", "$t0", String.valueOf(index));
            AssemblyFileWriter.appendCommandToCode("la", "$t1", des.getName());
            AssemblyFileWriter.appendCommandToCode("li", "$t4", String.valueOf(4)); //TODO: convert 4 to size of
            AssemblyFileWriter.appendCommandToCode("mul", "$t0", "$t0", "$t4");
            AssemblyFileWriter.appendCommandToCode("add", "$t1", "$t1", "$t0");
            AssemblyFileWriter.appendCommandToCode("lw", "$t1", "0($t1)");
            Descriptor leftSide = (Descriptor) SemanticStack.pop();
            AssemblyFileWriter.appendCommandToCode("sw", "$t1", leftSide.getName());
            AssemblyFileWriter.appendDebugLine(leftSide.getName());
        } else {
            Descriptor leftSide = (Descriptor) des;
            AssemblyFileWriter.appendComment("assignment " + leftSide.getName() + " = " + rightSide.getName());
            AssemblyFileWriter.appendCommandToCode("la", "$t0", leftSide.getName());
            AssemblyFileWriter.appendCommandToCode("la", "$t1", rightSide.getName());
            AssemblyFileWriter.appendCommandToCode("lw", "$t1", "0($t1)");
            AssemblyFileWriter.appendCommandToCode("sw", "$t1", "0($t0)");
            AssemblyFileWriter.appendDebugLine(leftSide.getName());
        }
    }
}