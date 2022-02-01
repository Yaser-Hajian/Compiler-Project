package SymbolTable.Stack;

import java.util.Stack;

public class SemanticStack {
    private static Stack<Object> semanticStack = new Stack<>();

    public static Object push(Object item) {
        return semanticStack.push(item);
    }

    public static Object pop() {
        return semanticStack.pop();
    }

    public static Object top() {
        return semanticStack.peek();
    }

    public static boolean isEmpty() {
        return semanticStack.isEmpty();
    }

    public static void print() {
        System.out.println("semantic stack = " + semanticStack.toString());
        System.out.println("size of semantic stack = " + semanticStack.size());
    }
}
