package Utils.Errors;

import CodeGen.CodeGeneratorImp;

public class CastError extends RuntimeException{
    String srcType;
    String destType;

    public CastError(String srcType, String destType) {
        this.srcType = srcType;
        this.destType = destType;
    }


    public void error() {

        System.err.println("Can not cast " + srcType + " to " + destType + " at line" + CodeGeneratorImp.getScanner().current_Token.lineNumber);
    }
}