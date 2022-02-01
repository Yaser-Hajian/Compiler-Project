package SymbolTable.DSCP.Variable;

import SymbolTable.DSCP.Descriptor;

public abstract class VariableDSCP extends Descriptor {
    private String value;
    private String type;

    public VariableDSCP(String name, String type, boolean isLocal) {
        super(name, type, isLocal);
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }
}