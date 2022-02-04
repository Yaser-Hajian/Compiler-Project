package SemanticsImp.Expression.GetInput;

import CodeGen.CodeGeneratorImp;
import SemanticsImp.Expression.Expression;
import SymbolTable.DSCP.Variable.LocalVariableDSCP;
import SymbolTable.Stack.SemanticStack;
import Utils.AssemblyFileWriter;

public class ReadReal extends Expression {

    @Override
    public void compile() {
        AssemblyFileWriter.appendComment("read real");
        AssemblyFileWriter.appendCommandToCode("li", "$v0", "6");
        AssemblyFileWriter.appendCommandToCode("syscall");
        AssemblyFileWriter.appendCommandToCode("mov.s", "$f1", "$f0");
        String variableName = CodeGeneratorImp.getVariableName();
        AssemblyFileWriter.appendCommandToData(variableName, "word", "0");
        AssemblyFileWriter.appendCommandToCode("la", "$t1", variableName);
        AssemblyFileWriter.appendCommandToCode("s.s", "$f1", "0($t1)");
        SemanticStack.push(new LocalVariableDSCP(variableName, "REAL_NUMBER"));
    }
}