grammar nbbin;

// grammar nbbin -> (O|1)^n+... pr entier et (O|1)^-n pour les decimal
// t ->> taille

start returns [ float lg ]
    : nbbin ret EOF { $lg = $nbbin.lg + $ret.lg ; System.out.println("start "+$lg); }
    ;

nbbin  returns [ float lg,int t ]
   : suitenbbin { $lg=$suitenbbin.lg; $t = 1; System.out.println("nbbin "+$lg+" t "+$t);}
   | nbbin1 = nbbin suitenbbin  { $lg = 2*$nbbin1.lg+$suitenbbin.lg ; $t = $nbbin1.t+1; System.out.println("==nbbin2 "+$lg+" = "+2*$nbbin1.lg+"+"+$suitenbbin.lg+" t "+$t);}
   ;

suitenbbin returns [ int lg ]
    : F { $lg = 0;System.out.println("suitenbbin 0");}
    | V { $lg = 1;System.out.println("suitenbbin 1");}
    ;

ret returns [float lg]
    : { $lg = 0; System.out.println("ret " +$lg );}
    | '.' nbbin { $lg = $nbbin.lg /  (float)Math.pow(2,$nbbin.t); System.out.println("ret2 " +$lg +" c "+$nbbin.lg +" /p " + (float)Math.pow(2,$nbbin.t));}
    ;

// lexer rules
F: '0' ;
V: '1' ;
PT : ('.'|',')  ;

UNMATCH :  ( ' '|  '\t'|'\r'| '\n') ->  skip; 
