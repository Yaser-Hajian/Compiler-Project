package SymbolTable.DSCP.Variable;

import CodeGen.Type;

public class LocalVariableDSCP extends VariableDSCP {
    public LocalVariableDSCP(String name, Type type) {
        super(name, type, true);
    }
}