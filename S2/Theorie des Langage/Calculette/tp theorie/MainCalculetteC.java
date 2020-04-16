import java.io.*;
import org.antlr.v4.runtime.*;
public class MainCalculetteC {
    public static void main(String args[]) throws Exception {
        CalculetteCLexer lex;
        if (args.length == 0) 
            lex = new CalculetteCLexer(new ANTLRInputStream(System.in));
        else 
            lex = new CalculetteCLexer(new ANTLRFileStream(args[0]));
            
        CommonTokenStream tokens = new CommonTokenStream(lex);
        
        CalculetteCParser parser = new CalculetteCParser(tokens);
        try {
            parser.start();    // start l'axiome de la grammaire 
        } catch (RecognitionException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
     
    }
}
