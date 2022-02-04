package SemanticsImp.Declarations;

import CodeGen.Type;

public abstract class DeclarationWithType extends Declaration {
    private Type type;

    public DeclarationWithType(String name, Type type) {
        super(name);
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}