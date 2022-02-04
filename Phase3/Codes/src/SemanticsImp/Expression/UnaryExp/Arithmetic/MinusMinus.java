package SemanticsImp.Expression.UnaryExp.Arithmetic;

import SemanticsImp.Expression.BinaryExpression.Logical.LogicalExpression;
import SymbolTable.DSCP.Descriptor;

public class MinusMinus extends LogicalExpression {

    public MinusMinus(Descriptor firstOperand) {
        super(firstOperand, null, "--");
    }

    @Override
    public void compile() {
        super.compile();
    }
}