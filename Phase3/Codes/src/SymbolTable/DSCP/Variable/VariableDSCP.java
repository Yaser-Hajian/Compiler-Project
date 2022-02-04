package SymbolTable.DSCP.Variable;

import CodeGen.Type;
import SymbolTable.DSCP.Descriptor;

public abstract class VariableDSCP extends Descriptor {
    private String value;
    private Type type;

    public VariableDSCP(String name, Type type, boolean isLocal) {
        super(name, type, isLocal);
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void setType(Type type) {
        this.type = type;
    }
}