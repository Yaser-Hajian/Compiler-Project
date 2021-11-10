import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Scanner.Token> tokens = new ArrayList<>();
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
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

}
