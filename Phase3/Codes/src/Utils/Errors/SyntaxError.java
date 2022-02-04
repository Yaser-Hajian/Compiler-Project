package Utils.Errors;


public class SyntaxError extends RuntimeException {
    public SyntaxError() {
        super("SyntaxError: invalid syntax at line " + CodeGenerator.lexical.getLine());
    }
}