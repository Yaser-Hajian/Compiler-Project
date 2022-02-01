package SemanticsImp.Declarations.VariableDeclaration;

public class LocalVariableDeclaration extends VariableDeclaration {

    public LocalVariableDeclaration(String name, String type) {
        super(name, type, true);
    }

    @Override
    public void compile() {
    }
}