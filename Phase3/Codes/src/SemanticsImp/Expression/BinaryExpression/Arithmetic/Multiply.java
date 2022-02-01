package SemanticsImp.Expression.BinaryExpression.Arithmetic;

import SemanticsImp.Expression.BinaryExpression.BinaryExpression;
import SymbolTable.DSCP.Descriptor;

public class Multiply extends BinaryExpression {
    public Multiply(Descriptor firstOperand, Descriptor secondOperand) {
        super(firstOperand, secondOperand, "*");
    }

    @Override
    public void compile() {
        super.compile();
    }
}