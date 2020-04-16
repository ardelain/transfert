import java.io.*;
import org.antlr.v4.runtime.*;
public class MainCalculetteE {
    public static void main(String args[]) throws Exception {
        CalculetteELexer lex;
        if (args.length == 0) 
            lex = new CalculetteELexer(new ANTLRInputStream(System.in));
        else 
            lex = new CalculetteELexer(new ANTLRFileStream(args[0]));
            
        CommonTokenStream tokens = new CommonTokenStream(lex);
        
        CalculetteEParser parser = new CalculetteEParser(tokens);
        try {
            parser.start();    // start l'axiome de la grammaire 
        } catch (RecognitionException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
     
    }
}
