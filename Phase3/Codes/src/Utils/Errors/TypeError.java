package Utils.Errors;

import CodeGen.CodeGeneratorImp;
import CodeGen.Type;

public class TypeError extends RuntimeException {
    private static String stringifyMultipleType(Type[] types) {
        String returnVal = "";
        for (Type s: types){
            returnVal += s.toString() + ", ";
        }
        return returnVal;
    }

    public TypeError(String operation, Type... Types) {
        super("TypeError: unsupported operand type(s) for" + operation + ": " + stringifyMultipleType(Types) + " at line " + CodeGeneratorImp.getScanner().current_Token.lineNumber);
    }

}