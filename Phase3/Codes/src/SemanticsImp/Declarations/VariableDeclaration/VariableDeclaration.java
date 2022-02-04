package SemanticsImp.Declarations.VariableDeclaration;


import CodeGen.Type;
import SemanticsImp.Declarations.DeclarationWithType;

public abstract class VariableDeclaration extends DeclarationWithType {

    private boolean isLocal;

    public VariableDeclaration(String name, Type type, boolean isLocal) {
        super(name, type);
        this.isLocal = isLocal;
    }
}