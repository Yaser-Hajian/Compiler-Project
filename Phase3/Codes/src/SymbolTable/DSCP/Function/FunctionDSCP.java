package SymbolTable.DSCP.Function;

import SymbolTable.DSCP.Descriptor;

public class FunctionDSCP extends Descriptor {
    private String labelFrom;

    public FunctionDSCP(String addressName, String type) {
        super(addressName, type, false);
    }

    public void setLabelFrom(String labelFrom) {
        this.labelFrom = labelFrom;
    }
}
