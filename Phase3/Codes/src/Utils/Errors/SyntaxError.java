package Utils.Errors;


import CodeGen.CodeGeneratorImp;

public class SyntaxError extends RuntimeException {
    public SyntaxError() {
        super("SyntaxError: invalid syntax at line " + CodeGeneratorImp.getScanner().current_Token.lineNumber);
    }
}