grammar CalculetteC;

@header { import java.util.HashMap;}
@members{ HashMap<String, Integer> memory = new HashMap<String, Integer>();

	int gp ;
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
    :calcul EOF  
    ;

calcul returns [ String code ] 
@init{ $code = new String(); }   // On initialise $code, pour ensuite l'utiliser comme accumulateur 
@after{ System.out.println($code); }
    :   (decl { $code += $decl.code; })*        
        
        NEWLINE*
        
        (instruction { $code += $instruction.code; })*

        { $code += "  HALT\n"; } 
    ;
    
expr  returns [String resultat]
    :  '(' expr ')' {$resultat = $expr.resultat;}
    |  a=expr '*' b=expr{ $resultat = $a.resultat  + "\n" + $b.resultat + "\n" + "MUL" + "\n";}
    |  a=expr '/' b=expr{ $resultat = $a.resultat  + "\n" + $b.resultat + "\n" + "DIV" + "\n";}
    |  a=expr '+' b=expr{ $resultat = $a.resultat  + "\n" + $b.resultat + "\n" + "ADD" + "\n";}
    |  a=expr '-' b=expr{ $resultat = $a.resultat  + "\n" + $b.resultat + "\n" + "SUB" + "\n";}
    |  ENTIER { $resultat = "PUSHI" + $ENTIER.int;}
    ;

decl returns [ String code ] 
    :
        TYPE IDENTIFIANT finInstruction
        {
            memory.put( $IDENTIFIANT.text, gp);
            gp++;
            
            $code = "PUSHI 0\n";
        }
        
    ; 


instruction returns [ String code ] 
    : expr finInstruction 
        { 
            $code = $expr.resultat;
        }
    | assignation finInstruction
        { 
            $code = $assignation.code;
        }
    | finInstruction
        {
            $code = "\n";
        }
    ;


assignation returns [ String code ] 
    : IDENTIFIANT '=' expr
        {  		
        	/*if( memory.get( $IDENTIFIANT.text) == null ){
        	
        		//System.out.println("cette variable n'existe pas!");
        		System.out.println("ici!");
        		System.exit(0); 
        	}*/
        	
        	 $code = $expr.resultat + "\n" + "STORG " + memory.get( $IDENTIFIANT.text);
        }
    ;

finInstruction  : ';';

// lexer
NEWLINE : '\r'? '\n'  -> skip;

WS :   (' '|'\t')+ -> skip  ;

ENTIER : ('0'..'9')+  ;

TYPE : 'int' | 'float' ;

IDENTIFIANT : ('A'..'Z'|'a'..'z')+;

UNMATCH : . -> skip ;	


// lexer


//...


