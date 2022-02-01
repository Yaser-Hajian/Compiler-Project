package SemanticsImp.Declarations;

public abstract class DeclarationWithType extends Declaration {
    private String type;

    public DeclarationWithType(String name, String type) {
        super(name);
        this.type = type;
    }

    public String getType() {
        return type;
    }
}