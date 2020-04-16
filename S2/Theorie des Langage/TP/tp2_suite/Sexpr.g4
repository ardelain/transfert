grammar Sexpr;

start returns [ int lg ]
    : sexpr EOF { $lg = $sexpr.lg  ; System.out.println("start "+$lg); }
    ;

sexpr  returns [ int lg ]
   : AT { $lg = 1; System.out.println("sexpr "+$lg);}
   | PO suiteSexpr { $lg = $suiteSexpr.lg ;  System.out.println("sexpr2 "+$lg);}
   ;

suiteSexpr returns [ int lg ]
    : PF { $lg = 0;}
    | liste PF {System.out.println("suiteSexpr "+$lg+" = "+$liste.lg); $lg = $liste.lg;}
    ;

liste returns [int lg]
    : sexpr suiteListe { System.out.println("liste "+$lg+" = "+$suiteListe.lg+" + "+ $sexpr.lg);$lg = $suiteListe.lg + $sexpr.lg ; }
    ;

suiteListe returns [int lg]
    : { $lg = 0; }
    | liste { System.out.println("suiteListe "+$lg+" = "+$liste.lg);$lg = $liste.lg; }
    ;

AT  : ('a'..'z'|'A'..'Z'|'0'..'9'|'_')+
    ;
PO  : '('
    ;
PF  : ')'
    ;
WS  : ( ' '|  '\t'|'\r'| '\n') -> skip ;
