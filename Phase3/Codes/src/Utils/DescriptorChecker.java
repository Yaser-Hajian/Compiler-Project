package Utils;

import SymbolTable.DSCP.Descriptor;
import SymbolTable.GlobalSymbolTable;
import SymbolTable.Stack.SymbolTableStack;

public class DescriptorChecker {
    public static void checkContainsDescriptor(Descriptor descriptor) {
        System.out.println("name of des = " + descriptor.getName());
        if (!SymbolTableStack.top().containsDescriptor(descriptor.getName())) {
            try {
                throw new NameError( descriptor.getName(), false, "Symbol table ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void checkNotContainsDescriptor(String name) throws Exception {
        if (!SymbolTableStack.isEmpty()) {
            if (SymbolTableStack.top().contains(name)) {
                throw new NameError(name, true, "Symbol table ");
            }
        }
    }

    public static void checkContainsDescriptorGlobal(Descriptor descriptor) {
        System.out.println("name of des = " + descriptor.getName());
        if (!GlobalSymbolTable.getSymbolTable().containsDescriptor(descriptor.getName())) {
            try {
                throw new NameError( descriptor.getName(), false, "Global Symbol table ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void checkNotContainsDescriptorGlobal(String name) {
        if (!GlobalSymbolTable.getSymbolTable().isEmpty()) {
            if (GlobalSymbolTable.getSymbolTable().contains(name)) {
                try {
                    throw new NameError(name, true, "Global Symbol table ");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
