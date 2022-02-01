package SemanticsImp.Expression.BinaryExpression.Logical;

import SemanticsImp.Expression.BinaryExpression.BinaryExpression;
import SymbolTable.DSCP.Descriptor;

public abstract class LogicalExpression extends BinaryExpression {

    public LogicalExpression(Descriptor firstOperand, Descriptor secondOperand, String operation) {
        super(firstOperand, secondOperand, operation);
    }
}