package SymbolTable.DSCP.Function;

import CodeGen.Type;
import SymbolTable.DSCP.Descriptor;
import SymbolTable.DSCP.Variable.VariableDSCP;

import java.util.HashMap;
import java.util.List;

public class FunctionDSCP extends Descriptor {
    private String labelFrom;
    private HashMap<VariableDSCP, String> variables_in_this_function;

    public FunctionDSCP(String addressName, Type type) {
        super(addressName, type, false);
    }

    public void setLabelFrom(String labelFrom) {
        this.labelFrom = labelFrom;
    }


}
