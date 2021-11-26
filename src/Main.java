import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void highlight(ArrayList<Scanner.Token> arrayList , FileWriter fileWriter) throws IOException{

        Map<Integer , ArrayList<Scanner.Token>  >map_token_to_line_number=new HashMap<>();

        for (int i = 0; i < arrayList.size(); i++) {
            Scanner.Token token = arrayList.get(i);
            int line_number = token.lineNumber;

            if (!map_token_to_line_number.containsKey(line_number)){
                map_token_to_line_number.put(line_number , new ArrayList<Scanner.Token>());
            }
            map_token_to_line_number.get(line_number).add(token);


        }
        for (int i : map_token_to_line_number.keySet()) {
            ArrayList<Scanner.Token> tokens = map_token_to_line_number.get(i);
            String writed = "<p>";
            int lineNumber = i+1;
            writed += "<span class=\"count\">"+lineNumber + "- </span> ";
            for (int j = 0; j < tokens.size(); j++) {
                Scanner.Token token = tokens.get(j);
                if (token.type.equals("WhiteSpace") ) {
                    if (token.type.equals("\t")) {
                        String space = "&nbsp &nbsp &nbsp &nbsp";
                        writed += "<span>" + space + "</span>";
                    }else{
                        String space = "&nbsp";
                        writed += "<span>" + space + "</span>";
                    }
                }else {
                    writed += "<span class=\" " +token.type+  "\">"+ token.value+"</span>";
                }

            }
            writed += "</p>";
            fileWriter.write(writed);

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
                tokens.add(currentToken);
                System.out.println(currentToken.type + ": "+ currentToken.value);
            }
            highlight(tokens,fileWriter);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

}
