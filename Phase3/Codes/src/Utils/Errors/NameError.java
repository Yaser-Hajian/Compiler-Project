package Utils.Errors;

import CodeGen.CodeGeneratorImp;

public class NameError extends RuntimeException {
    public NameError(String name, boolean isDefined) {
        super("NameError: name '" + name + "' is"+ (isDefined ? "": " not") + " defined at line " + CodeGeneratorImp.getScanner().current_Token.lineNumber);
    }

    public NameError(String name, boolean isDefined,String prefix) {
        super(prefix != null ? prefix : "" + "NameError: name '" + name + "' is"+ (isDefined ? "": " not") + " defined at line " + CodeGeneratorImp.getScanner().current_Token.lineNumber);
    }

}