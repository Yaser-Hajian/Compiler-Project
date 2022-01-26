public class CodeGeneratorImp implements CodeGenerator {
    private My_Scanner scanner;

    public CodeGeneratorImp(My_Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void doSemantic(String sem) {
        System.out.println("Semantic Token is: "+sem);
        switch (sem){
            case "PushInt":
                System.out.println("Push "+ scanner.ICV + " to semantic stack");
                break;
            case "Assignment":
                System.out.println("Code generation for assignment");
                break;
            case "Mult":
                System.out.println("Code generation for Mult");
                break;
            case "Add":
                System.out.println("Code generation for Add");
                break;
            case "jz":
                System.out.println("Code generation for jz");
                break;
            case "cjz":
                System.out.println("Code generation for cjz");
                break;
            case "jp":
                System.out.println("Code generation for jp");
                break;
            case "cjp":
                System.out.println("Code generation for cjp");
                break;
            default:
                System.out.println("Not supported Semantic token: "+sem);
        }
    }
}
