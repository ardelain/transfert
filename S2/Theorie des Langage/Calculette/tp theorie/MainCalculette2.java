import java.io.*;
import org.antlr.v4.runtime.*;
public class MainCalculette2 {
    public static void main(String args[]) throws Exception {
        Calculette2Lexer lex;
        if (args.length == 0) 
            lex = new Calculette2Lexer(new ANTLRInputStream(System.in));
        else 
            lex = new Calculette2Lexer(new ANTLRFileStream(args[0]));
            
        CommonTokenStream tokens = new CommonTokenStream(lex);
        
        Calculette2Parser parser = new Calculette2Parser(tokens);
        try {
            parser.start();    // start l'axiome de la grammaire 
        } catch (RecognitionException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
     
    }
}
