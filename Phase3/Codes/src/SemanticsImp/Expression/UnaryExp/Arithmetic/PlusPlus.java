package SemanticsImp.Expression.UnaryExp.Arithmetic;

import SemanticsImp.Expression.BinaryExpression.Logical.LogicalExpression;
import SymbolTable.DSCP.Descriptor;

public class PlusPlus extends LogicalExpression {

    public PlusPlus(Descriptor firstOperand) {
        super(firstOperand, null, "++");
    }

    @Override
    public void compile() {
        super.compile();
    }
}