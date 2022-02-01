package SemanticsImp.Expression.BinaryExpression.Arithmetic;


import SemanticsImp.Expression.BinaryExpression.BinaryExpression;
import SymbolTable.DSCP.Descriptor;

public class Divide extends BinaryExpression {
    public Divide(Descriptor firstOperand, Descriptor secondOperand) {
        super(firstOperand, secondOperand, "/");
    }

    @Override
    public void compile() {
        super.compile();
    }
}