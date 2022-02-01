package SemanticsImp.Declarations;


import SemanticsImp.Compilable;

public abstract class Declaration implements Compilable {
    private String name;

    public Declaration(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}