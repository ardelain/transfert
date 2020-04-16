grammar Calculette;
@members {
   private TablesSymboles tablesSymboles = new TablesSymboles();
        } 

start
    : calcul /*expr*/ EOF; //{$expr.code=$expr.code+" POP\n WRITE\n HALT\n";System.out.println($expr.code);};
	
calcul returns [ String code ]
@init{ $code = new String(); }   // On initialise $code, pour ensuite l'utiliser comme accumulateur 
@after{ System.out.println($code); }
    :   (decl { $code += $decl.code; })*        
        
        NEWLINE*
        
        (instruction { $code += $instruction.code; })*

        { $code += " WRITE\n POP\n POP\n POP\n HALT\n"; } 
    ;

expr returns [String code]
    : a=expr '*' b=expr{$code=$a.code+$b.code+" MUL\n";}
    | a=expr '+' b=expr{$code=$a.code+$b.code+" ADD\n";}
	| PO expr PF
    | ENTIER {$code=" PUSHI "+$ENTIER.int+"\n";}
	| IDENTIFIANT 
		{
			AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
            $code=" PUSHG "+at.adresse+"\n";
		}
    ;


decl returns [ String code ] 
    :
        TYPE IDENTIFIANT finInstruction
        {
            tablesSymboles.putVar($IDENTIFIANT.text,"int");
			$code=" PUSHI 0\n";
        }
    ; 

instruction returns [ String code ] 
    : expr finInstruction 
        { 
            $code=$expr.code;
        }
    | assignation finInstruction
        { 
            $code=$assignation.code;
        }
    | finInstruction
        {
            $code="";
        }
    ;

finInstruction returns [ String code ] 
    : ';' NEWLINE*   
		{
            $code="";
        }
    ;


assignation returns [ String code ] 
    : IDENTIFIANT '=' expr
        {  
			AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
            $code=" STOREG "+at.adresse+"\n"+$expr.code+" PUSHG "+at.adresse+"\n";
        }
    ;

// lexer
TYPE : 'int' | 'float' ;

NEWLINE : '\r'? '\n'  -> skip;

WS :   (' '|'\t')+ -> skip  ;

ENTIER : ('0'..'9')+  ;

PO : '(';

PF : ')';

UNMATCH : . -> skip ;

IDENTIFIANT : ('a'..'z'|'A'..'Z')+;
