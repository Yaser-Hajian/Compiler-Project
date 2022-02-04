package SymbolTable.DSCP.Array;

import CodeGen.Type;

public class LocalArrayDSCP extends ArrayDSCP {
    public LocalArrayDSCP(String name, Type type) {
        super(name, type, true);
    }
}