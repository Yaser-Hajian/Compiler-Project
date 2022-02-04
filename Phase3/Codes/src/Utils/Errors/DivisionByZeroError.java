package Utils.Errors;

import CodeGen.CodeGeneratorImp;

public class DivisionByZeroError extends RuntimeException {
    public DivisionByZeroError() {
        super("ZeroDivisionError: division by zero at line " + CodeGeneratorImp.getScanner().current_Token.lineNumber);
    }
}