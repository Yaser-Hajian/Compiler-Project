package SymbolTable.DSCP.Variable;

import CodeGen.Type;

public class GlobalVariableDSCP extends VariableDSCP {
    public GlobalVariableDSCP(String name, Type type) {
        super(name, type, false);
    }
}
