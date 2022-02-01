package SemanticsImp.Declarations.FunctionDeclaration;

import SemanticsImp.Declarations.DeclarationWithType;
import SemanticsImp.Declarations.VariableDeclaration.LocalVariableDeclaration;

import java.util.List;

public class FunctionDeclaration extends DeclarationWithType {

    private List<LocalVariableDeclaration> parameters;

    public FunctionDeclaration(String name, String type, List<LocalVariableDeclaration> parameters) {
        super(name, type);
        this.parameters = parameters;
    }

    @Override
    public void compile() {

    }
}