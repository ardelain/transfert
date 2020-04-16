lexer grammar JetonsJava;

OPERATEUR
    : '<'|'<='|'>'|'>='|'=='|'!='
    ;

MOTCLE
: ( 'break' | 'class' | 'double' | 'else' | 'if' | 'import' | 'public' | 'static' | 'throws' ) 
      { System.out.print("\n[motclé : "+getText()+" ]"); }
    ;
    
IDENTIFIANT 
    :   (('a'..'z' | 'A'..'Z' | '_')('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*)
    { System.out.print(" [ident : "+getText()+" ]"); }
    ;


NOMBRE : (('0'..'9')+)
   { System.out.print(" [NOMBRE : "+getText()+" ]"); }
    ;


WHITE_SPACE
    : (' '|'\n'|'\t'|'\r')+ 
    ;


ACO 
    : ('{') 
    { System.out.print("\t"); }
    ;
    
 COMMENTAIRE
    : (('//')~('\n'|'\t'|'\r')*) 
    { System.out.print("\n[COMENTAIRE : "+getText()+" ]"); }
    ;

 COMMENTAIRE_MULTI
    :  (('/*').*?'*/')
    { System.out.print("\n[COMMENTAIRE_MULTI : "+getText()+" ]"); }
    ;          

    UNMATCH 
    : . 
    ;