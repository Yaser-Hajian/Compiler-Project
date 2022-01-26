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

            default:
                System.out.println("Not supported Semantic token: "+sem);
        }
    }
}
