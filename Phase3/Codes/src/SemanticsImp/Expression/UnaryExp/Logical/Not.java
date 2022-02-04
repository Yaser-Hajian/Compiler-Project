package SemanticsImp.Expression.UnaryExp.Logical;
import SemanticsImp.Expression.BinaryExpression.Logical.LogicalExpression;
import SymbolTable.DSCP.Descriptor;

public class Not extends LogicalExpression {

    public Not(Descriptor firstOperand) {
        super(firstOperand, null, "!");
    }

    @Override
    public void compile() {
        super.compile();
    }
}