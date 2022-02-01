package SemanticsImp.Expression.BinaryExpression.Arithmetic;

import SemanticsImp.Expression.BinaryExpression.BinaryExpression;
import SymbolTable.DSCP.Descriptor;

public class Subtract extends BinaryExpression {
    public Subtract(Descriptor firstOperand, Descriptor secondOperand) {
        super(firstOperand, secondOperand, "-");
    }

    @Override
    public void compile() {
        super.compile();
    }
}