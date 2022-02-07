package SymbolTable.DSCP;

import CodeGen.Type;

import java.util.Objects;

public abstract class Descriptor {
    private String addressName;
    private Type type;
    private boolean isLocal;

    public Descriptor(String addressName, Type type, boolean isLocal) {
        this.addressName = addressName;
        this.type = type;
        this.isLocal = isLocal;
    }

    public void setName(String addressName) {
        this.addressName = addressName;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return addressName;
    }

    public boolean getIsLocal() {
        return isLocal;
    }

    public void setIsLocal(boolean local) {
        isLocal = local;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Descriptor that = (Descriptor) o;
        return Objects.equals(addressName, that.addressName) &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressName, type, isLocal);
    }

    @Override
    public String toString() {
        return "SymbolTable.DSCP.Descriptor{" +
                "addressName='" + addressName + '\'' +
                ", type=" + type +
                ", isLocal=" + isLocal +
                '}';
    }
}