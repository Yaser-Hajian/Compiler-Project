import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> tokens = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new FileReader("./input.cool"));
            while (true) {
                String currentToken = scanner.nextToken();
                if (scanner.yyatEOF()) {
                    break;
                }
                if (!currentToken.startsWith("Error")) {
                    tokens.add(currentToken);
                }
                System.out.println(currentToken);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

}
