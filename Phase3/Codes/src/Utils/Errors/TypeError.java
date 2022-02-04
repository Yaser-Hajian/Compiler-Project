package Utils.Errors;

public class TypeError extends RuntimeException {
    private static String stringifyMultipleType(String[] types) {
        String returnVal = "";
        for (String s: types){
            returnVal += s.toString() + ", ";
        }
        return returnVal;
    }

    public TypeError(String operation, String... Types) {
        super("TypeError: unsupported operand type(s) for" + operation + ": " + stringifyMultipleType(Types) + " at line " + CodeGenerator.lexical.getLine());
    }

}