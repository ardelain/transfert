grammar Calculette;



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


start returns [String resultat ]
    : expr EOF { $resultat = $expr.resultat;
   				 System.out.println($resultat + "POP \nHALT \n");}
    
    ;

expr  returns [String resultat]
    :  a=expr '*' b=expr{ $resultat = $a.resultat  + "\n" + $b.resultat + "\n" + "MUL" + "\n";}
    |  a=expr '/' b=expr{ $resultat = $a.resultat  + "\n" + $b.resultat + "\n" + "DIV" + "\n";}
    |  a=expr '+' b=expr{ $resultat = $a.resultat  + "\n" + $b.resultat + "\n" + "ADD" + "\n";}
    |  a=expr '-' b=expr{ $resultat = $a.resultat  + "\n" + $b.resultat + "\n" + "SUB" + "\n";}
    |  ENTIER { $resultat = "PUSHI" + $ENTIER.int;}
    |  '(' expr ')'
    ;

// lexer
NEWLINE : '\r'? '\n'  -> skip;

WS :   (' '|'\t')+ -> skip  ;

ENTIER : ('0'..'9')+  ;

UNMATCH : . -> skip ;	







decl returns [ String code ] 
    :
        TYPE IDENTIFIANT finInstruction
        {
            // à compléter
        }
    ; 

instruction returns [ String code ] 
    : expression finInstruction 
        { 
            // à compléter
        }
    | assignation finInstruction
        { 
            // à compléter
        }
    | finInstruction
        {
            $code="";
        }
    ;

assignation returns [ String code ] 
    : IDENTIFIANT '=' expression
        {  
            // à compléter
        }
    ;

// lexer
TYPE : 'int' | 'float' ;

//...


