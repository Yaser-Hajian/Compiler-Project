package Utils.Type;

import CodeGen.Type;
import Utils.Errors.TypeError;

public class TypeChecker {
    public static boolean checkType(Type firstType, Type secondType, String operation) {
        if (firstType == secondType) {
            return true;
        }
        throw new TypeError(operation, firstType, secondType);
    }

    public static boolean isArrayType(Type type) {
        return type == Type.DOUBLE_ARRAY || type == Type.INT_ARRAY || type == Type.STRING_ARRAY;
    }

    public static boolean checkArrayType(Type arrayType, Type elementType) {
        if ((arrayType == Type.INT_ARRAY && elementType == Type.INTEGER_NUMBER)
                || (arrayType == Type.DOUBLE_ARRAY && elementType == Type.REAL_NUMBER)
                || (arrayType == Type.STRING_ARRAY && elementType == Type.STRING)) {
            return true;
        }
        throw new TypeError("TypeError: array type is " + elementType + " array but it is newed with " + arrayType);
    }
}