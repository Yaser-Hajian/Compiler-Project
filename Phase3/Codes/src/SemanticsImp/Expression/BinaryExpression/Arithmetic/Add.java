package SemanticsImp.Expression.BinaryExpression.Arithmetic;

import SemanticsImp.Expression.BinaryExpression.BinaryExpression;
import SymbolTable.DSCP.Descriptor;

public class Add extends BinaryExpression {
    public Add(Descriptor firstOperand, Descriptor secondOperand) {
        super(firstOperand, secondOperand, "+");
    }

    @Override
    public void compile() {
        super.compile();
    }
}