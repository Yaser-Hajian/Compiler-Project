package SemanticsImp.Expression.GetInput;

import SemanticsImp.Expression.Expression;

public class ReadLine extends Expression {
    @Override
    public void compile() {
        AssemblyFileWriter.appendComment("read string");
        AssemblyFileWriter.appendCommandToCode("li", "$v0", "8");
        AssemblyFileWriter.appendCommandToCode("la", "$a0", "strbuffer");
        AssemblyFileWriter.appendCommandToCode("li", "$a1", "20");
        AssemblyFileWriter.appendCommandToCode("move", "$t0", "$a0");
        AssemblyFileWriter.appendCommandToCode("sw", "$t0", "stradr");
        String varName = CodeGenerator.getVariableName();
        LocalVariableDescriptor lvd = new LocalVariableDescriptor(varName, Type.STRING);
        AssemblyFileWriter.appendCommandToData(varName, "space", "20");
        AssemblyFileWriter.appendCommandToCode("sw", "$t0", lvd.getName());
        SemanticStack.push(lvd);
        AssemblyFileWriter.appendCommandToCode("syscall");
    }
}