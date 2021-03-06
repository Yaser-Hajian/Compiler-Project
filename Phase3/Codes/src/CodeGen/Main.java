package CodeGen;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        String inputCollFilePath = "C:\\Users\\USER\\Desktop\\Compiler Project\\ProjectFiles\\codes\\Phase3\\test\\test.cool";
        String outputFilePath="";
        String tablePath = "C:\\Users\\USER\\Desktop\\Compiler Project\\ProjectFiles\\codes\\Phase3\\PGen\\second-edition\\table.npt";

//        if (args.length >=6){
//            for (int i = 0; i < args.length; i++) {
//                if (args[i].equals("--input")){
//                    //inputCollFilePath=args[i+1];
//                    inputCollFilePath = "C:\\Users\\USER\\Desktop\\Compiler Project\\ProjectFiles\\codes\\Phase3\\test\\test.cool";
//                }
//                if (args[i].equals("--output")){
//                    //outputFilePath = args[i+1];
//                }
//                if (args[i].equals("--table")){
//                    //tablePath = args[i+1];
//                    tablePath = "C:\\Users\\USER\\Desktop\\Compiler Project\\ProjectFiles\\codes\\Phase3\\PGen\\second-edition\\table.npt";
//                }
//            }
//        }else {
//            System.out.println("bad input!");
//            return;
//        }

        My_Scanner my_scanner = new My_Scanner(new FileReader(inputCollFilePath));
        CodeGeneratorImp codeGen = new CodeGeneratorImp(my_scanner);
        Parser parser = new Parser(my_scanner ,codeGen ,tablePath);


//        FileWriter fw = new FileWriter(outputFilePath);
        try {
            parser.parse();
//            fw.write("Syntax is correct!");
//            fw.flush();
            System.out.println("successfull");
        }catch (Exception e){
//            fw.write("Syntax is wrong!");
//            fw.flush();
            System.out.println("error");
        }

    }
}
