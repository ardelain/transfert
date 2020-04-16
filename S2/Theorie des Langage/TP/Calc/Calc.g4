grammar Calc;

@parser::members {
  
    private int evalexpr (int x, String op, int y) {
	System.out.println("evalexpr x"+x+" op"+op+" y "+y);
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

start
    : expr EOF{System.out.println("HALT ");};

expr returns [double val]
    :    exp=somExpr {$val = $exp.val;System.out.println("WRITE ");}
    ;

somExpr returns [double val]
    :    m1=multExpr       {$val =  $m1.val;} 
         ( '+' m2=multExpr {$val += $m2.val;System.out.println("ADD ");} 
         | '-' m2=multExpr {$val -= $m2.val;System.out.println("SUB ");}
         )* 
    ;

multExpr returns [double val]
    :    a1=opExpr       {$val =  $a1.val;}
         ( '*' a2=opExpr {$val *= $a2.val;System.out.println("MUL ");} 
         | '/' a2=opExpr {$val /= $a2.val;System.out.println("DIV ");}
         )* 
    ;

opExpr returns [double val]
    :    n=ENTIER                {$val = Double.parseDouble($n.text);System.out.println("PUSHI "+$val);}
    |    '(' exp=somExpr ')' {$val = $exp.val;}
    ;

// lexer
NEWLINE : '\r'? '\n'  -> skip;

COMMNENT : ('#' ~('\n'|'\r')*)? '\r'? '\n' ; // and Comment

WS :   (' '|'\t')+ -> skip  ;

ENTIER : ('0'..'9')+  ;

UNMATCH : . -> skip ;
