package SemanticsImp.Expression.GetInput;

import CodeGen.CodeGeneratorImp;
import SemanticsImp.Expression.Expression;
import SymbolTable.DSCP.Variable.LocalVariableDSCP;
import SymbolTable.Stack.SemanticStack;
import Utils.AssemblyFileWriter;

public class ReadLine extends Expression {
    @Override
    public void compile() {
        AssemblyFileWriter.appendComment("read string");
        AssemblyFileWriter.appendCommandToCode("li", "$v0", "8");
        AssemblyFileWriter.appendCommandToCode("la", "$a0", "strbuffer");
        AssemblyFileWriter.appendCommandToCode("li", "$a1", "20");
        AssemblyFileWriter.appendCommandToCode("move", "$t0", "$a0");
        AssemblyFileWriter.appendCommandToCode("sw", "$t0", "stradr");
        String varName = CodeGeneratorImp.getVariableName();
        LocalVariableDSCP lvd = new LocalVariableDSCP(varName, "STRING");
        AssemblyFileWriter.appendCommandToData(varName, "space", "20");
        AssemblyFileWriter.appendCommandToCode("sw", "$t0", lvd.getName());
        SemanticStack.push(lvd);
        AssemblyFileWriter.appendCommandToCode("syscall");
    }
}