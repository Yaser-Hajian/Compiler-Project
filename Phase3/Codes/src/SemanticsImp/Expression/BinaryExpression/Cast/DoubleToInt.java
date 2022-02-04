package SemanticsImp.Expression.BinaryExpression.Cast;

import CodeGen.Type;
import SymbolTable.DSCP.Descriptor;

public class DoubleToInt extends Cast {
    public DoubleToInt(Descriptor operand, Type type) {
        super(operand, type, "s2i");
    }

    @Override
    public void compile() {
        convert(operand, type, "cvt.w.s", "s.s", "l.s");
    }
}