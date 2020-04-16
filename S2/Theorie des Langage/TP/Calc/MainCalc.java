import java.io.*;
import org.antlr.v4.runtime.*;
public class MainCalc {
    public static void main(String args[]) throws Exception {
        CalcLexer lex;
        if (args.length == 0) 
            lex = new CalcLexer(new ANTLRInputStream(System.in));
        else 
            lex = new CalcLexer(new ANTLRFileStream(args[0]));
            
        CommonTokenStream tokens = new CommonTokenStream(lex);
        
        CalcParser parser = new CalcParser(tokens);
        try {
            System.out.println(parser.start());    // start l'axiome de la grammaire 
        } catch (RecognitionException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
     
    }
}
