package SemanticsImp.Expression.BinaryExpression.Cast;

import CodeGen.Type;
import SymbolTable.DSCP.Descriptor;

public class IntToDouble extends Cast {
    public IntToDouble(Descriptor operand, Type type) {
        super(operand, type, "i2s");
    }

    @Override
    public void compile() {
        convert(operand, type, "cvt.s.w", "s.s", "l.s");
    }
}