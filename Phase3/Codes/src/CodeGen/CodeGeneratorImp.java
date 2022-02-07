package CodeGen;

import SemanticsImp.Expression.BinaryExpression.Arithmetic.*;
import SemanticsImp.Expression.BinaryExpression.Cast.DoubleToInt;
import SemanticsImp.Expression.BinaryExpression.Cast.IntToDouble;
import SemanticsImp.Expression.BinaryExpression.Logical.LogicalExpressions.*;
import SemanticsImp.Expression.Constants.IntegerConstant;
import SemanticsImp.Expression.Constants.RealConstant;
import SemanticsImp.Expression.Constants.StringConstant;
import SemanticsImp.Expression.GetInput.ReadInt;
import SemanticsImp.Expression.GetInput.ReadLine;
import SemanticsImp.Expression.UnaryExp.Arithmetic.MinusMinus;
import SemanticsImp.Expression.UnaryExp.Arithmetic.PlusPlus;
import SemanticsImp.Expression.UnaryExp.Logical.Not;
import SemanticsImp.StatementBlock.Statements.*;
import SymbolTable.DSCP.Array.ArrayDSCP;
import SymbolTable.DSCP.Array.LocalArrayDSCP;
import SymbolTable.DSCP.Descriptor;
import SymbolTable.DSCP.Variable.LocalVariableDSCP;
import SymbolTable.DSCP.Variable.VariableDSCP;
import SymbolTable.GlobalSymbolTable;
import SymbolTable.Stack.SemanticStack;
import SymbolTable.Stack.SymbolTableStack;
import Utils.AssemblyFileWriter;
import Utils.DescriptorChecker;
import Utils.Errors.CastError;
import Utils.Errors.NameError;
import Utils.Type.TypeChecker;

public class CodeGeneratorImp implements CodeGenerator {
    private static My_Scanner scanner;
    private static int variableIndex = 0;
    private static int labelIndex = 0;

    public CodeGeneratorImp(My_Scanner scanner) {
        this.scanner = scanner;
    }

    public static My_Scanner getScanner() {
        return scanner;
    }


    private static int getVariableIndex() {
        return variableIndex;
    }

    private static void incrementVariableIndex() {
        ++variableIndex;
    }

    public static String getVariableName() {
        incrementVariableIndex();
        return "adr" + getVariableIndex();
    }

    public static String generateNewLabel() {
        ++labelIndex;
        return "lbl" + labelIndex;
    }

    VariableDSCP index = null;
    Descriptor arrName = null;
    String str = null;
    String str2 = null;


    @Override
    public void doSemantic(String sem) {
        debugPrint(sem);
        Descriptor firstOperand, secondOperand;
        try {
            switch (sem) {
                case "add":
                    System.out.println("code gen of add");
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new Add(firstOperand, secondOperand).compile();
                    break;
                case "sub":
                    System.out.println("code gen of subtract");
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new Subtract(firstOperand, secondOperand).compile();
                    break;
                case "mult":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new Multiply(firstOperand, secondOperand).compile();
                    System.out.println("code gen of multiply");
                    break;
                case "div":
                    System.out.println("code gen of division");
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new Divide(firstOperand, secondOperand).compile();
                    break;
                case "remainder":
                    System.out.println("code gen of remainder");
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new Remainder(firstOperand, secondOperand).compile();
                    break;
                case "nor":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new Nor(firstOperand, secondOperand).compile();
                    System.out.println("code gen of nor");
                    break;
                case "and":
                case "logicalAnd":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new And(firstOperand, secondOperand).compile();
                    System.out.println("code gen of and");
                    break;
                case "or":
                case "logicalOr":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new Or(firstOperand, secondOperand).compile();
                    System.out.println("code gen of or");
                    break;
                case "xor":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new Xor(firstOperand, secondOperand).compile();
                    System.out.println("code gen of xor");
                    break;
                case "not":
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new Not(firstOperand).compile();
                    System.out.println("code gen of not");
                    break;
                case "minusMinus":
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new MinusMinus(firstOperand).compile();
                    System.out.println("code gen of minus minus");
                    break;
                case "plusPlus":
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new PlusPlus(firstOperand).compile();
                    System.out.println("code gen of plus plus");
                    break;
                case "biggerThan":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new BiggerThan(firstOperand, secondOperand).compile();
                    System.out.println("code gen of biggerThan");
                    break;
                case "biggerThanAndEqual":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new BiggerThanAndEqual(firstOperand, secondOperand).compile();
                    System.out.println("code gen of biggerThanAndEqual");
                    break;
                case "smallerThan":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new SmallerThan(firstOperand, secondOperand).compile();
                    break;
                case "smallerThanAndEqual":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new SmallerThanAndEqual(firstOperand, secondOperand).compile();
                    System.out.println("code gen of smallerThanAndEqual");
                    break;
                case "equal":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new Equal(firstOperand, secondOperand).compile();
                    System.out.println("code gen of equal");
                    break;
                case "notEqual":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new NotEqual(firstOperand, secondOperand).compile();
                    System.out.println("code gen of notEqual");
                    break;
                case "break":
                    //TODO
                    System.out.println("code gen of break");
                    break;
                case "if":
                    new If((Descriptor) SemanticStack.pop()).compile();
                    break;
                case "completeIf":
                    If.completeIf();
                    break;
                case "else":
                    If.elseCode();
                    break;
                case "completeElse":
                    If.completeElse();
                    break;
                case "startConditionWhile":
                    While.startCondition();
                    break;
                case "whileJumpZero":
                    new While((Descriptor) SemanticStack.pop()).compile();
                    break;
                case "completeWhile":
                    While.completeWhile();
                    break;
                case "startConditionFor":
                    For.startCondition();
                    break;
                case "forJumpZero":
                    new For((Descriptor) SemanticStack.pop()).compile();
                    break;
                case "completeFor":
                    For.completeFor();
                    For.stepStatement();
                    For.completeStepOfFor();
                    break;
                case "arrayDcl":
                    DescriptorChecker.checkNotContainsDescriptor((String) scanner.current_Token.value);
                    DescriptorChecker.checkNotContainsDescriptorGlobal((String) scanner.current_Token.value);
                    Type arrType = (Type) SemanticStack.top();
                    if (!SymbolTableStack.top().contains((String) scanner.current_Token.value)) {
                        LocalArrayDSCP lad = new LocalArrayDSCP(getVariableName(), arrType);
                        SymbolTableStack.top().addDescriptor((String) scanner.current_Token.value, lad);
//                    AssemblyFileWriter.appendCommandToData(lad.getName(), "word", "0");
                        SemanticStack.push((String) scanner.current_Token.value);
                    } else {
                        try {
                            throw new NameError((String) scanner.current_Token.value, true);
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                        }
                    }
                    break;
                case "setArrayDescriptor":
                    Type newArrayType = (Type) SemanticStack.pop();
                    VariableDSCP sizeDescriptor = (VariableDSCP) SemanticStack.pop();
                    ArrayDSCP nameOfArrayDes = (ArrayDSCP) SemanticStack.pop();
                    nameOfArrayDes.setSize(Integer.parseInt(sizeDescriptor.getValue()));
                    if (nameOfArrayDes.getIsLocal()) {
                        DescriptorChecker.checkContainsDescriptor(nameOfArrayDes);
                    } else {
                        DescriptorChecker.checkContainsDescriptorGlobal(nameOfArrayDes);
                    }
                    TypeChecker.checkArrayType(nameOfArrayDes.getType(), newArrayType);
                    ArrayDSCP ad = new LocalArrayDSCP(nameOfArrayDes.getName(), newArrayType);
                    ad.setSize(Integer.parseInt(sizeDescriptor.getValue()));
                    if (nameOfArrayDes.getIsLocal()) {
                        SymbolTableStack.top().addDescriptor(nameOfArrayDes.getRealName(), ad);
                    } else {
                        GlobalSymbolTable.getSymbolTable().addDescriptor(nameOfArrayDes.getRealName(), ad);
                    }
                    AssemblyFileWriter.appendCommandToData(nameOfArrayDes.getName(), "space", String.valueOf(4 * Integer.parseInt(sizeDescriptor.getValue())));
                    break;
                case "arrayAccess":
                    index = (VariableDSCP) SemanticStack.pop();
                    arrName = (Descriptor) SemanticStack.pop();
                    AssemblyFileWriter.appendComment("array access with name " + arrName.getName() + " at " + index.getValue());
                    AssemblyFileWriter.appendCommandToCode("la", "$t0", arrName.getName());
                    AssemblyFileWriter.appendCommandToCode("li", "$t4", "4");
                    AssemblyFileWriter.appendCommandToCode("li", "$t1", String.valueOf(index.getValue()));
                    AssemblyFileWriter.appendCommandToCode("mul", "$t1", "$t1", "$t4");
                    AssemblyFileWriter.appendCommandToCode("add", "$t0", "$t0", "$t1");
                    AssemblyFileWriter.appendCommandToCode("lw", "$t0", "0($t0)");
                    LocalVariableDSCP lvd = new LocalVariableDSCP(getVariableName(), changeArrayTypeToElementType(arrName.getType()));
                    AssemblyFileWriter.appendCommandToData(lvd.getName(), "word", "0");
                    SemanticStack.push(lvd);
                    AssemblyFileWriter.appendCommandToCode("sw", "$t0", lvd.getName());
                    break;
                case "popArrayAccess":
                    SemanticStack.pop();
                    SemanticStack.push(arrName);
                    SemanticStack.push(index);
                    break;
                case "arrayAssignment":
                    Descriptor rightSide = (Descriptor) SemanticStack.pop();
                    Descriptor des = (Descriptor) SemanticStack.pop();
                    AssemblyFileWriter.appendComment("left array assignment");
                    if (TypeChecker.isArrayType(des.getType())) {
                        VariableDSCP des2 = (VariableDSCP) SemanticStack.pop();
                        Descriptor nameOfArrayDesc = (Descriptor) SemanticStack.pop();
                        int idx = Integer.parseInt(des2.getValue());
                        int rightIndex = Integer.parseInt(((VariableDSCP) rightSide).getValue());
                        //right
                        AssemblyFileWriter.appendCommandToCode("li", "$t0", String.valueOf(rightIndex));
                        AssemblyFileWriter.appendCommandToCode("la", "$t1", des.getName());
                        AssemblyFileWriter.appendCommandToCode("li", "$t4", String.valueOf(4)); //TODO: convert 4 to size of
                        AssemblyFileWriter.appendCommandToCode("mul", "$t0", "$t0", "$t4");
                        AssemblyFileWriter.appendCommandToCode("add", "$t1", "$t1", "$t0");
                        AssemblyFileWriter.appendCommandToCode("lw", "$t1", "0($t1)");
                        //left
                        AssemblyFileWriter.appendCommandToCode("li", "$t2", String.valueOf(idx));
                        AssemblyFileWriter.appendCommandToCode("la", "$t3", nameOfArrayDesc.getName());
                        AssemblyFileWriter.appendCommandToCode("mul", "$t2", "$t2", "$t4");
                        AssemblyFileWriter.appendCommandToCode("add", "$t3", "$t3", "$t2");
                        //assign
                        AssemblyFileWriter.appendCommandToCode("sw", "$t1", "0($t3)");
                        AssemblyFileWriter.appendDebugLine("0($t3)");

                    } else {
                        VariableDSCP arrIndex = (VariableDSCP) des;
                        Descriptor nameOfArrDes = (Descriptor) SemanticStack.pop();
                        AssemblyFileWriter.appendCommandToCode("li", "$t1", String.valueOf(arrIndex.getValue()));
                        AssemblyFileWriter.appendCommandToCode("la", "$t2", nameOfArrDes.getName());
                        AssemblyFileWriter.appendCommandToCode("li", "$t4", String.valueOf(4)); //TODO: convert 4 to size of
                        AssemblyFileWriter.appendCommandToCode("mul", "$t1", "$t1", "$t4");
                        AssemblyFileWriter.appendCommandToCode("add", "$t1", "$t1", "$t2");
                        AssemblyFileWriter.appendCommandToCode("la", "$t3", rightSide.getName());
                        AssemblyFileWriter.appendCommandToCode("lw", "$t3", "0($t3)");
                        AssemblyFileWriter.appendCommandToCode("sw", "$t3", "0($t1)");
                        AssemblyFileWriter.appendDebugLine("0($t1)");
                    }
                    break;
                case "trueCode":
                    new IntegerConstant(1).compile();
                    break;
                case "falseCode":
                    new IntegerConstant(0).compile();
                    break;
                case "pushInteger":
                    System.out.println("code gen of push integer");
                    IntegerConstant intConst = new IntegerConstant(scanner.ICV);
                    intConst.compile();
                    break;
                case "pushDouble":
                    new RealConstant((float) scanner.RCV).compile();
                    break;
                case "pushString":
                    System.out.println("push str " + scanner.current_Token.value);
                    new StringConstant((String) scanner.current_Token.value).compile();
                    break;
                case "pop":
                    System.out.println("code gen of pop");
                    break;
                case "print":
                    new Print((Descriptor) SemanticStack.pop()).compile();
                    break;
                case "readInteger":
                    new ReadInt().compile();
                    break;
                case "readLine":
                    new ReadLine().compile();
                    break;
                case "returnStatement":
                    new Return((Descriptor) SemanticStack.pop()).compile();
                    break;
                case "pushType":
                    SemanticStack.push(changeStringToType((String) scanner.current_Token.value));
                    break;
                case "popAndPushArrayType":
                    Object o = SemanticStack.pop();
//                System.out.println(o.toString() + "     <- object top");
                    Type type = (Type) o;
                    Type resType = null;
                    switch (type) {
                        case INTEGER_NUMBER:
                            resType = Type.INT_ARRAY;
                            break;
                        case REAL_NUMBER:
                            resType = Type.DOUBLE_ARRAY;
                            break;
                        case STRING:
                            resType = Type.STRING_ARRAY;
                            break;
                    }
                    SemanticStack.push(resType);
                    break;
                case "pushIdDcl":
                    DescriptorChecker.checkNotContainsDescriptor((String) scanner.current_Token.value);
                    SemanticStack.push((String) scanner.current_Token.value);
                    break;
                case "pushId":
                    if (!SymbolTableStack.isEmpty() && SymbolTableStack.top().contains((String) scanner.current_Token.value))
                        SemanticStack.push(SymbolTableStack.top().getDescriptor((String) scanner.current_Token.value));
                    else {
                        try {
                            SemanticStack.push(GlobalSymbolTable.getSymbolTable().getDescriptor((String) scanner.current_Token.value));
                            System.out.println(401);
                        } catch (Exception e1) {
                            try {
                                try {
                                    System.out.println(407);
                                    throw new NameError((String) scanner.current_Token.value, false);
                                } catch (Exception e2) {
                                    System.err.println(e2.getMessage());
                                    System.out.println(410);
                                }
                            } catch (Exception e2) {
                                System.out.println(414);
                                System.err.println(e2.getMessage());
                            }
                        }
                    }
                    break;
                case "addDescriptor":
                    String name = (String) SemanticStack.pop();
                    Object t1 = SemanticStack.pop();
                    if (t1 instanceof String) {
                        o = null;
                        try {
                            if (!SemanticStack.isEmpty()) {
                                o = SemanticStack.pop();
                                SemanticStack.push(o);

                            }
                        } catch (Exception e) {
                            SemanticStack.push(o);
                        }
                    } else if (t1 instanceof Type) {
                        Type t = (Type) t1;
                        if (TypeChecker.isArrayType(t)) {
                            ArrayDSCP lad = (ArrayDSCP) SymbolTableStack.top().getDescriptor(name);
                            lad.setRealName(name);
                        } else {
                            if (!SymbolTableStack.top().contains(name)) {
                                lvd = new LocalVariableDSCP(getVariableName(), t);
                                SymbolTableStack.top().addDescriptor(name, lvd);
                                if (t != Type.STRING) {
                                    AssemblyFileWriter.appendCommandToData(lvd.getName(), "word", "0");
                                } else {
                                    AssemblyFileWriter.appendCommandToData(lvd.getName(), "space", "20");
                                }
                            } else {
                                try {
                                    throw new NameError(name, true);
                                } catch (Exception e2) {
                                    System.err.println(e2.getMessage());
                                }
                            }
                        }
                    }
                    break;
                case "cast":
                    des = (Descriptor) SemanticStack.pop();
                    type = (Type) SemanticStack.pop();
                    if (type == Type.INTEGER_NUMBER) {
                        new DoubleToInt(des, type).compile();
                    } else if (type == Type.REAL_NUMBER) {
                        new IntToDouble(des, type).compile();
                    } else {
                        String srcType = des.getType().toString();
                        String destType = type.toString();
                        new CastError(srcType, destType).error();
                    }
                    break;
                case "addAssign":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    SemanticStack.push(firstOperand);
                    new Add(firstOperand, secondOperand).compile();
                    new Assignment().compile();
                    break;
                case "subAssign":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    SemanticStack.push(firstOperand);
                    new Subtract(firstOperand, secondOperand).compile();
                    new Assignment().compile();
                    break;
                case "multAssign":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    SemanticStack.push(firstOperand);
                    new Multiply(firstOperand, secondOperand).compile();
                    new Assignment().compile();
                    break;
                case "divAssign":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    SemanticStack.push(firstOperand);
                    new Divide(firstOperand, secondOperand).compile();
                    new Assignment().compile();
                    break;
                case "assignment":
                    new Assignment().compile();
                    break;
                case "getLen":
                    ArrayDSCP descriptor;
                    try {
                        descriptor = (ArrayDSCP) SemanticStack.pop();
                        IntegerConstant integerConstant = new IntegerConstant(descriptor.getSize());
                        integerConstant.compile();
                    } catch (Exception e) {
                        System.err.println("len is called in type that is not array");
                    }
                    break;
                default:
                    System.out.println("");
            }
            System.out.println();
        } catch (Exception e) {

            System.err.println("Compile Error Occurred at line " + (scanner.current_Token.lineNumber + 1));
            e.printStackTrace();
        }
    }


    Type changeStringToType(String type) {
        Type res;
        switch (type) {
            case "bool":
            case "int":
                res = Type.INTEGER_NUMBER;
                break;
            case "double":
                res = Type.REAL_NUMBER;
                break;
            case "string":
                res = Type.STRING;
                break;
            default:
                res = null;
        }
        return res;
    }

    Type changeArrayTypeToElementType(Type arrType) {
        Type res;
        switch (arrType) {
            case DOUBLE_ARRAY:
                res = Type.REAL_NUMBER;
                break;
            case INT_ARRAY:
                res = Type.INTEGER_NUMBER;
                break;
            case STRING_ARRAY:
                res = Type.STRING;
                break;
            default:
                res = null;
        }
        return res;
    }

    private void debugPrint(String sem) {
        System.out.println("sem = " + sem);
        try {
            System.out.println("token = " + (String) scanner.current_Token.value);
            SemanticStack.print();
            SymbolTableStack.top().print();
            GlobalSymbolTable.print();
        } catch (Exception e) {
        }
    }
}