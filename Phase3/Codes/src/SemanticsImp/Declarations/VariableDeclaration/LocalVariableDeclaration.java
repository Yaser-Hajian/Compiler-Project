package SemanticsImp.Declarations.VariableDeclaration;

import CodeGen.Type;

public class LocalVariableDeclaration extends VariableDeclaration {

    public LocalVariableDeclaration(String name, Type type) {
        super(name, type, true);
    }

    @Override
    public void compile() {
    }
}