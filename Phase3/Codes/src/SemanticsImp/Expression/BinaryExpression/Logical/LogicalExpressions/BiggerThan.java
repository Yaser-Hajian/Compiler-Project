package SemanticsImp.Expression.BinaryExpression.Logical.LogicalExpressions;


import SemanticsImp.Expression.BinaryExpression.Logical.LogicalExpression;
import SymbolTable.DSCP.Descriptor;

public class BiggerThan extends LogicalExpression {

    public BiggerThan(Descriptor firstOperand, Descriptor secondOperand) {
        super(firstOperand, secondOperand, ">");
    }

    @Override
    public void compile() {
        super.compile();
    }
}