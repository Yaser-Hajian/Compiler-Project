import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void highlight(ArrayList<Scanner.Token> arrayList , FileWriter fileWriter) throws IOException{
        for (int i = 0; i < arrayList.size(); i++) {
            int lineNumber = i+1;
            Scanner.Token token = arrayList.get(i);
            fileWriter.write("<p class=\"" +token.type+ "\">" +"<span class=\"count\">"+lineNumber + "- "+"</span>"+ token.value+"</p>");
        }
        fileWriter.write("</body>");
        fileWriter.write("</html>");
        fileWriter.flush();
        fileWriter.close();
    }
    public static void main(String[] args) throws IOException {
        ArrayList<Scanner.Token> tokens = new ArrayList<>();
        FileWriter fileWriter = new FileWriter("src/Output/output.html" , true);
        try {
            Scanner scanner = new Scanner(new FileReader("src/input.cool"));
            while (true) {
                Scanner.Token currentToken = scanner.nextToken();
                if (scanner.yyatEOF()) {
                    break;
                }
                if (!currentToken.type.startsWith("Error")) {
                    tokens.add(currentToken);
                }
                System.out.println(currentToken.type + ": "+ currentToken.value);
            }
            highlight(tokens,fileWriter);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

}
