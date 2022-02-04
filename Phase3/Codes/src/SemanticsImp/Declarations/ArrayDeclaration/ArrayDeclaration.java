package SemanticsImp.Declarations.ArrayDeclaration;

import CodeGen.Type;
import SemanticsImp.Declarations.DeclarationWithType;
import SemanticsImp.Expression.Expression;

import java.util.List;

public class ArrayDeclaration extends DeclarationWithType {
    private int numberOfDimensions;
    private List<Expression> dimensions;

    public ArrayDeclaration(String name, Type type, int numberOfDimensions, List<Expression> dimensions) {
        super(name, type);
        this.numberOfDimensions = numberOfDimensions;
        this.dimensions = dimensions;
    }

    @Override
    public void compile() {

    }
}