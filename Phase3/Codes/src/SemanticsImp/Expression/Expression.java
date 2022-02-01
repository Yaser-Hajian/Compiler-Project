package SemanticsImp.Expression;

import SemanticsImp.Compilable;

public abstract class Expression implements Compilable {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}