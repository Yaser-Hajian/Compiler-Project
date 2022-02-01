package SymbolTable.DSCP;

import java.util.Objects;

public abstract class Descriptor {
    private String addressName;
    private String type;
    private boolean isLocal;

    public Descriptor(String addressName, String type, boolean isLocal) {
        this.addressName = addressName;
        this.type = type;
        this.isLocal = isLocal;
    }

    public void setName(String addressName) {
        this.addressName = addressName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
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
        return isLocal == that.isLocal &&
                Objects.equals(addressName, that.addressName) &&
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