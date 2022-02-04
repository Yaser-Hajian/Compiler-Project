package SemanticsImp.Declarations.FunctionDeclaration;

import CodeGen.Type;
import SemanticsImp.Declarations.DeclarationWithType;
import SemanticsImp.Declarations.VariableDeclaration.LocalVariableDeclaration;

import java.util.List;

public class FunctionDeclaration extends DeclarationWithType {

    private List<LocalVariableDeclaration> parameters;

    public FunctionDeclaration(String name, Type type, List<LocalVariableDeclaration> parameters) {
        super(name, type);
        this.parameters = parameters;
    }

    @Override
    public void compile() {

    }
}