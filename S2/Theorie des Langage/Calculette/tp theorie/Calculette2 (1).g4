grammar Calculette2;

@parser::members {

    private int evalexpr (int x, String op, int y) {
        if ( op.equals("*") ){
            return x*y;
        } else if ( op.equals("+") ){
            return x+y;
        } else {
           System.err.println("Opérateur arithmétique inconnu : '"+op+"'");
           throw new IllegalArgumentException("Opérateur arithmétique inconnu : '"+op+"'");
        }
    }
        
}

start returns [String result]
    : expr EOF{System.out.println($expr.result + "POP + \n + HALT + \n");}
    ;
expr returns [String result]
	: a=expr '*' b=expr {$result = $a.result + "\n" + $b.result +"\n" + "MUL" + "\n";}
    | a=expr '/' b=expr {$result = $a.result + "\n" + $b.result +"\n" + "DIV" + "\n";}
    | a=expr '+' b=expr {$result = $a.result + "\n" + $b.result +"\n" + "ADD" + "\n";}
    | a=expr '-' b=expr {$result = $a.result + "\n" + $b.result +"\n" + "SUB" + "\n";}
    | ENTIER{$result = "PUSHI" + $ENTIER.int;}
    ;
    
// lexer
NEWLINE : '\r'? '\n'  -> skip;

WS :   (' '|'\t')+ -> skip  ;

ENTIER : ('0'..'9')+  ;

UNMATCH : . -> skip ;


