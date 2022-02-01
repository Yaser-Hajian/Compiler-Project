package SemanticsImp.Declarations.VariableDeclaration;


import SemanticsImp.Declarations.DeclarationWithType;

public abstract class VariableDeclaration extends DeclarationWithType {

    private boolean isLocal;

    public VariableDeclaration(String name, String type, boolean isLocal) {
        super(name, type);
        this.isLocal = isLocal;
    }
}