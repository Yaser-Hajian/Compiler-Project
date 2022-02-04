package SymbolTable.DSCP.Array;

import CodeGen.Type;
import SymbolTable.DSCP.Descriptor;

public abstract class ArrayDSCP extends Descriptor {
    private int size;
    private String realName;
    private Type type;

    public ArrayDSCP(String name, Type type, boolean isLocal) {
        super(name, type, isLocal);
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Override
    public void setType(Type type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public String getRealName() {
        return realName;
    }

    @Override
    public Type getType() {
        return type;
    }
}