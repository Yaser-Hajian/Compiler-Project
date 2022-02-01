package SemanticsImp.Declarations.VariableDeclaration;

public class GlobalVariableDeclaration extends VariableDeclaration {
    public GlobalVariableDeclaration(String name, String type) {
        super(name, type, false);
    }

    @Override
    public void compile() {

    }
}