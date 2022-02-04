package SemanticsImp.Expression.BinaryExpression;

import SemanticsImp.Declarations.VariableDeclaration.LocalVariableDeclaration;
import SemanticsImp.Expression.Expression;
import SymbolTable.DSCP.Descriptor;
import SymbolTable.DSCP.Variable.LocalVariableDSCP;
import SymbolTable.Stack.SemanticStack;
import Utils.AssemblyFileWriter;

import java.util.ArrayList;

public abstract class BinaryExpression extends Expression {

    protected Descriptor firstOperand;
    protected Descriptor secondOperand;
    protected String operation;

    private ArrayList<Object> PendingProcess = new ArrayList<>();

    public BinaryExpression(Descriptor firstOperand, Descriptor secondOperand, String operation) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operation = operation;
    }

    private String loadAndOperate(Descriptor firstOperandDes, Descriptor secondOperandDes, String operationCommand, String storeCommand, String loadCommand, String variableName0, String variableName1) {
        String variableName =  CodeGeneratorImp.getVariableName();
        AssemblyFileWriter.appendComment("binary " + operationCommand + " expression of " + firstOperandDes.getName() + ", " + secondOperandDes.getName() );
        AssemblyFileWriter.appendCommandToCode("la", "$t0", firstOperandDes.getName());
        AssemblyFileWriter.appendCommandToCode("la", "$t1", secondOperandDes.getName());
        AssemblyFileWriter.appendCommandToCode(loadCommand, variableName0, "0($t0)");
        AssemblyFileWriter.appendCommandToCode(loadCommand, variableName1, "0($t1)");
        AssemblyFileWriter.appendCommandToCode(operationCommand, variableName0, variableName0, variableName1);
        return variableName;
    }

    private void generate2OperandCommands(Descriptor firstOperandDes, Descriptor secondOperandDes, String resultType, String operationCommand, String storeCommand, String loadCommand, String variableName0, String variableName1) {
        String variableName = loadAndOperate(firstOperandDes, secondOperandDes, operationCommand, storeCommand, loadCommand, variableName0, variableName1);

        AssemblyFileWriter.appendCommandToData(variableName, "word", "0");
        AssemblyFileWriter.appendCommandToCode(storeCommand, variableName0, variableName);
        AssemblyFileWriter.appendDebugLine(variableName);
        SemanticStack.push(new LocalVariableDSCP(variableName, resultType));
    }

    private void multiply(Descriptor firstOperandDes, Descriptor secondOperandDes, String resultType, String operationCommand, String storeCommand, String loadCommand, String variableName0, String variableName1) {
        String variableName = loadAndOperate(firstOperandDes, secondOperandDes, operationCommand, storeCommand, loadCommand, variableName0, variableName1);

        AssemblyFileWriter.appendCommandToCode("mfhi", "$t1");
        AssemblyFileWriter.appendCommandToCode("mflo", "$t0");
        AssemblyFileWriter.appendCommandToData(variableName, "space", "64");
        AssemblyFileWriter.appendCommandToCode(storeCommand, variableName0, variableName);
        AssemblyFileWriter.appendDebugLine(variableName);
        SemanticStack.push(new LocalVariableDeclaration(variableName, resultType));
    }

    public static String continueLabel;
    public static String afterCompareLabel;
    public static String variableNameOfContinue;

    private void divide(Descriptor firstOperandDes, Descriptor secondOperandDes, String resultType, String operationCommand, String storeCommand, String loadCommand, String variableName0, String variableName1) {
        String variableName = loadAndOperate(firstOperandDes, secondOperandDes, operationCommand, storeCommand, loadCommand, variableName0, variableName1);

        AssemblyFileWriter.appendCommandToCode("mfhi", "$t1");
        AssemblyFileWriter.appendCommandToCode("mflo", "$t0");
        AssemblyFileWriter.appendCommandToData(variableName, "word", "0");

        AssemblyFileWriter.appendCommandToCode(storeCommand, variableName0, variableName);
        AssemblyFileWriter.appendDebugLine(variableName);
        SemanticStack.push(new LocalVariableDeclaration(variableName, resultType));
    }

    private void generateMinusMinusCommand(Descriptor firstOperandDes, String resultType, String operationCommand/*, boolean isBeforeExpression*/) {
        String variableName = CodeGeneratorImp.getVariableName();
        AssemblyFileWriter.appendComment("binary " + "--" + " expression of " + firstOperandDes.getName());
        AssemblyFileWriter.appendCommandToCode("la", "$t0", firstOperandDes.getName());
        AssemblyFileWriter.appendCommandToCode("lw", "$t0", "0($t0)");

        AssemblyFileWriter.appendCommandToCode(operationCommand, "$t0", "$t0", "-1");
        AssemblyFileWriter.appendCommandToData(variableName, "word", "0");
        AssemblyFileWriter.appendCommandToCode("sw", "$t0", variableName);
        AssemblyFileWriter.appendDebugLine(variableName);
        SemanticStack.push(new LocalVariableDeclaration(variableName, resultType));
        /*if (isBeforeExpression){
        }
        else {
        }*/
    }

    private void generatePlusPlusCommand(Descriptor firstOperandDes, String resultType, String operationCommand/*, boolean isBeforeExpression*/) {
        String variableName = CodeGenerator.getVariableName();
        AssemblyFileWriter.appendComment("binary " + "++" + " expression of " + firstOperandDes.getName());
        AssemblyFileWriter.appendCommandToCode("la", "$t0", firstOperandDes.getName());
        AssemblyFileWriter.appendCommandToCode("lw", "$t0", "0($t0)");

        AssemblyFileWriter.appendCommandToCode(operationCommand, "$t0", "$t0", "0x1");
        AssemblyFileWriter.appendCommandToData(variableName, "word", "0");
        AssemblyFileWriter.appendCommandToCode("sw", "$t0", variableName);
        AssemblyFileWriter.appendDebugLine(variableName);
        SemanticStack.push(new LocalVariableDeclaration(variableName, resultType));
        /*if (isBeforeExpression){
        }
        else {
        }*/
    }

    private void generateCompare(Descriptor firstOperandDes, Descriptor secondOperandDes) {
        variableNameOfContinue = CodeGenerator.getVariableName();
        continueLabel = CodeGenerator.generateNewLabel();
        afterCompareLabel = CodeGenerator.generateNewLabel();
        AssemblyFileWriter.appendComment("compare of real");
        AssemblyFileWriter.appendCommandToCode("la", "$t0", firstOperandDes.getName());
        AssemblyFileWriter.appendCommandToCode("la", "$t1", secondOperandDes.getName());
        AssemblyFileWriter.appendCommandToCode("l.s", "$f0", "0($t0)");
        AssemblyFileWriter.appendCommandToCode("l.s", "$f1", "0($t1)");
        AssemblyFileWriter.appendCommandToCode("c.eq.s", "$f0", "$f1");
        AssemblyFileWriter.appendCommandToCode("bc1t", afterCompareLabel);
        AssemblyFileWriter.appendCommandToCode("li", "$t0", "0");
        AssemblyFileWriter.appendCommandToCode("sw", "$t0", variableNameOfContinue);
        AssemblyFileWriter.addLabel(continueLabel);
//        AssemblyFileWriter.appendDebugLine(variableNameOfContinue);
        SemanticStack.push(new LocalVariableDeclaration(variableNameOfContinue, String.INTEGER_NUMBER));
    }

    private void generateNotCommand(Descriptor firstOperandDes, String resultType, String operationCommand) {
        String variableName = CodeGenerator.getVariableName();
        AssemblyFileWriter.appendComment("binary " + operationCommand + " expression of " + firstOperandDes.getName());
        AssemblyFileWriter.appendCommandToCode("la", "$t0", firstOperandDes.getName());
        AssemblyFileWriter.appendCommandToCode("lw", "$t0", "0($t0)");

        AssemblyFileWriter.appendCommandToCode(operationCommand, "$t0", "$t0");
        AssemblyFileWriter.appendCommandToData(variableName, "word", "0");
        AssemblyFileWriter.appendCommandToCode("sw", "$t0", variableName);
        AssemblyFileWriter.appendDebugLine(variableName);
        SemanticStack.push(new LocalVariableDescriptor(variableName, resultType));
    }

    @Override
    public void compile() {
        System.out.println("BinaryExpr");
        Descriptor firstOperandDes = firstOperand;
        Descriptor secondOperandDes = secondOperand;
        TypeChecker.checkType(firstOperandDes.getType(), secondOperandDes.getType(), "add");
        if (firstOperandDes.getIsLocal()) {
            DescriptorChecker.checkContainsDescriptor(firstOperandDes);
        } else {
            DescriptorChecker.checkContainsDescriptorGlobal(firstOperandDes);
        }
        if (secondOperandDes.getIsLocal()) {
            DescriptorChecker.checkContainsDescriptor(secondOperandDes);
        } else {
            DescriptorChecker.checkContainsDescriptorGlobal(secondOperandDes);
        }

        String resultType = firstOperandDes.getType();
        String storeCommand = "sw", loadCommand = "lw";
        String variableName0 = "$f0", variableName1 = "$f1";

        String extention = null;

        switch (resultType) {
            case INTEGER_NUMBER:
                extention = "";
                storeCommand = "sw";
                loadCommand = "lw";
                variableName0 = "$t0";
                variableName1 = "$t1";
                break;
            case REAL_NUMBER:
                extention = ".s";
                storeCommand = "s.s";
                loadCommand = "l.s";
                variableName0 = "$f0";
                variableName1 = "$f1";
                break;
            case STRING:
                // extention = "";
                // TODO
                break;
            default:
                resultType = null;
        }

        switch (operation) {
            // Arithmatic
            case "+":
                generate2OperandCommands(firstOperandDes, secondOperandDes, resultType, "add"+ extention, storeCommand, loadCommand, variableName0, variableName1);
                break;
            case "-":
                generate2OperandCommands(firstOperandDes, secondOperandDes, resultType, "sub"+ extention, storeCommand, loadCommand, variableName0, variableName1);
                break;
            case "/":
                //TODO: division by 0
                divide(firstOperandDes, secondOperandDes, resultType, "div"+ extention, storeCommand, loadCommand, variableName0, variableName1);
                break;
            case "*":
                multiply(firstOperandDes, secondOperandDes, resultType, "mul"+ extention, resultType==Type.INTEGER_NUMBER ? "sd" : "s.s", loadCommand, variableName0, variableName1);
                break;
            case "%":
                if(firstOperandDes.getType() == Type.INTEGER_NUMBER && secondOperandDes.getType() == Type.INTEGER_NUMBER ) {
                    generate2OperandCommands(firstOperandDes, secondOperandDes, resultType, "rem", storeCommand, loadCommand, variableName0, variableName1);
                }
                else
                    throw new TypeError("%", firstOperandDes.getType(), firstOperandDes.getType());
                break;
            // and, or, xor
            case "&&":
            case "&":
                generate2OperandCommands(firstOperandDes, secondOperandDes, resultType, "and", "sw", "lw", variableName0, variableName1);
                break;
            case "||":
            case "|":
                generate2OperandCommands(firstOperandDes, secondOperandDes, resultType, "or", "sw", "lw", variableName0, variableName1);
                break;
            case "^":
                generate2OperandCommands(firstOperandDes, secondOperandDes, resultType, "xor", "sw", "lw", variableName0, variableName1);
                break;
            case "~":
                generate2OperandCommands(firstOperandDes, secondOperandDes, resultType, "nor", "sw", "lw", variableName0, variableName1);
                break;
            // Comparison
            case "==":
//                generateCompare(firstOperand, secondOperand);
                if (firstOperandDes.getType() == Type.REAL_NUMBER){     //TODO (for all). better: firstOperandDes.getType() == secondOperandDes.getType() == Type.REAL_NUMBER
                    generate2OperandCommands(firstOperandDes, secondOperandDes, resultType, "c.eq.s", storeCommand, loadCommand, variableName0, variableName1);
                }
                else if(firstOperandDes.getType() == Type.INTEGER_NUMBER) {
                    generate2OperandCommands(firstOperandDes, secondOperandDes, resultType, "seq", storeCommand, loadCommand, variableName0, variableName1);
                }
                break;
            case "<":
                if (firstOperandDes.getType() == Type.REAL_NUMBER){
                    generate2OperandCommands(firstOperandDes, secondOperandDes, resultType, "c.lt.s", storeCommand, loadCommand, variableName0, variableName1);
                }
                else if(firstOperandDes.getType() == Type.INTEGER_NUMBER) {
                    generate2OperandCommands(firstOperandDes, secondOperandDes, resultType, "slt", storeCommand, loadCommand, variableName0, variableName1);
                }
                break;
            case ">=":
                if (firstOperandDes.getType() == Type.REAL_NUMBER){
                    generate2OperandCommands(secondOperandDes, firstOperandDes, resultType, "c.le.s", storeCommand, loadCommand, variableName0, variableName1);
                }
                else if(firstOperandDes.getType() == Type.INTEGER_NUMBER) {
                    generate2OperandCommands(firstOperandDes, secondOperandDes, resultType, "sge", storeCommand, loadCommand, variableName0, variableName1);
                }
                break;
            case ">":
                if (firstOperandDes.getType() == Type.REAL_NUMBER){
                    generate2OperandCommands(secondOperandDes, firstOperandDes, resultType, "c.lt.s", storeCommand, loadCommand, variableName0, variableName1);
                }
                else if(firstOperandDes.getType() == Type.INTEGER_NUMBER) {
                    generate2OperandCommands(firstOperandDes, secondOperandDes, resultType, "sgt", storeCommand, loadCommand, variableName0, variableName1);
                }
                break;
            case "<=":
                if (firstOperandDes.getType() == Type.REAL_NUMBER){
                    generate2OperandCommands(firstOperandDes, secondOperandDes, resultType, "c.le.s", storeCommand, loadCommand, variableName0, variableName1);
                }
                else if(firstOperandDes.getType() == Type.INTEGER_NUMBER) {
                    generate2OperandCommands(firstOperandDes, secondOperandDes, resultType, "sle", storeCommand, loadCommand, variableName0, variableName1);
                }
                break;
            case "!=":
                generate2OperandCommands(firstOperandDes, secondOperandDes, resultType, "sne", "sw", "lw", variableName0, variableName1);
                break;
            // Unary
            case "++":
                if(firstOperandDes.getType() == Type.INTEGER_NUMBER) {
                    generatePlusPlusCommand(firstOperandDes, resultType, "addi");
                }
                else
                    throw new TypeError("++", firstOperandDes.getType());
                break;
            case "--":
                if(firstOperandDes.getType() == Type.INTEGER_NUMBER) {
                    generateMinusMinusCommand(firstOperandDes, resultType, "addi");
                }
                else
                    throw new TypeError("--", firstOperandDes.getType());
                break;
            case "!":
                //TODO: check if its logical (not int or ...)
                generateNotCommand(firstOperandDes, resultType, "not");
                break;
            default:
                resultType = null;
        }
    }
}