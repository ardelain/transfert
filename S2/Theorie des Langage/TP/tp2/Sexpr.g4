grammar Sexpr;

start 
    : sexpr EOF
    ;
sexpr
    : AT 
    | PO suiteSexpr
    ;
    
suiteSexpr
    : PF 
    | liste PF
    ;
liste
    : sexpr suiteListe
    ;
suiteListe
    : /* vide */
    | liste
    ;
 
AT  : ('a'..'z'|'A'..'Z'|'0'..'9'|'_')+
    ;
PO  : '('
    ;
PF  : ')'
    ;
WS  : ( ' '|  '\t'|'\r'| '\n') -> skip ;